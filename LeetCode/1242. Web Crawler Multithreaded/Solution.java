import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

//interface HtmlParser {
//    public List<String> getUrls(String url);
//}

class Solution {

//    Set<String> crawledUrls = Collections.synchronizedSet(new HashSet<>());
//    Set<String> crawlingUrls = Collections.synchronizedSet(new HashSet<>());
    Set<String> crawledUrls = new HashSet<>();
    Set<String> crawlingUrls = new HashSet<>();

    public CompletableFuture<Void> crawlAsync(String hostname, String url, HtmlParser htmlParser) {
        return CompletableFuture.runAsync(() -> {
//            htmlParser.getUrls(url)
//                .stream()
//                .filter(newUrl -> hostname.equals(newUrl.split("/")[2]))
//                .filter(newUrl -> crawledUrls.add(newUrl) && crawlingUrls.add(newUrl))
//                .forEach(newUrl -> crawlAsync(hostname, newUrl, htmlParser));

            for (String newUrl : htmlParser.getUrls(url)) {
                synchronized (crawlingUrls) {
                    if (!crawledUrls.contains(newUrl) && !crawlingUrls.contains(newUrl) && hostname.equals(newUrl.split("/")[2])) {
                        crawlingUrls.add(newUrl);
                        crawlAsync(hostname, newUrl, htmlParser);
                    }
                }
            }

            synchronized (crawlingUrls) {
                crawlingUrls.remove(url);
                crawledUrls.add(url);
                if (crawlingUrls.isEmpty()) {
                    crawlingUrls.notify();
                }
            }
        });
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        String hostname = startUrl.split("/")[2];

        crawlingUrls.add(startUrl);
        crawlAsync(hostname, startUrl, htmlParser);

        synchronized (crawlingUrls) {
            try {
                crawlingUrls.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return new ArrayList<>(crawledUrls);
    }
}

// Not 100% correct
//class Solution {
//
//    Set<String> crawledUrls = new HashSet<>();
//    Set<String> crawlingUrls = new HashSet<>();
//    List<CompletableFuture<Void>> futures = new LinkedList<>();
//    Lock setLock = new ReentrantLock();
//
//    public void crawlAsync(String hostname, String url, HtmlParser htmlParser) {
//        setLock.lock();
//        try {
//            if (crawledUrls.contains(url) || crawlingUrls.contains(url) || !hostname.equals(url.split("/")[2])) {
//                return;
//            }
//            crawlingUrls.add(url);
//            crawledUrls.add(url);
//        } finally {
//            setLock.unlock();
//        }
//
//        CompletableFuture
//                .supplyAsync(() -> htmlParser.getUrls(url))
//                .thenAcceptAsync(urls -> {
//                    urls.stream().map(element -> {
//                        crawlAsync(hostname, element, htmlParser);
//                        return "";
//                    }).collect(Collectors.toList());
//                });
//
//        setLock.lock();
//        try {
//            crawlingUrls.remove(url);
//        } finally {
//            setLock.unlock();
//        }
//    }
//
//    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//
//        String hostname = startUrl.split("/")[2];
//
//        crawlAsync(hostname, startUrl, htmlParser);
//
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        while (!crawlingUrls.isEmpty()){}
//
//        return new ArrayList<>(crawledUrls);
//    }
//}

// Correct, but kind of slow
//class Solution {
//
//    Set<String> allUrls = new HashSet<>();
//    Set<String> currentUrls = new HashSet<>();
//    Set<String> newUrls = new HashSet<>();
//    Lock lock = new ReentrantLock();
//
//    public CompletableFuture<Void> oneCrawlAsync(String hostname, String url, HtmlParser htmlParser) {
//        return CompletableFuture.runAsync(() -> {
////            System.out.println("crawling " + url);
//            List<String> crawledUrls = htmlParser.getUrls(url);
////            System.out.println("crawled: " + crawledUrls);
//
//            for (String newUrl : crawledUrls) {
//                lock.lock();
//                try {
//                    if (!allUrls.contains(newUrl) && hostname.equals(newUrl.split("/")[2])) {
////                        System.out.println("adding " + newUrl + " to newUrls");
//                        newUrls.add(newUrl);
//                    }
//                } finally {
//                    lock.unlock();
//                }
//            }
//        });
//    }
//
//    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
//
//        String hostname = startUrl.split("/")[2];
//
//        currentUrls.add(startUrl);
//        while (!currentUrls.isEmpty()) {
////            System.out.println("currentUrls: " + currentUrls);
//            allUrls.addAll(currentUrls);
//            List<CompletableFuture<Void>> futures = currentUrls.stream()
//                    .map(element -> oneCrawlAsync(hostname, element, htmlParser))
//                    .collect(Collectors.toList());
//            try {
//                CompletableFuture
//                        .allOf(futures.toArray(new CompletableFuture[0]))
//                        .get();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//            currentUrls = newUrls;
//            newUrls = new HashSet<>();
//        }
//        return new ArrayList<>(allUrls);
//    }
//}

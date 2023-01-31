import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

class StockPrice {
    private HashMap<Integer, Integer> timestampToPrice;
    private TreeMap<Integer, Integer> prices;
    private int latestTimestamp;
    public StockPrice() {
        timestampToPrice = new HashMap<>();
        prices = new TreeMap<>();
        latestTimestamp = Integer.MIN_VALUE;
    }

    public void update(int timestamp, int price) {
        if (timestampToPrice.containsKey(timestamp)) {
            int oldPrice = timestampToPrice.get(timestamp);
            int occurrence = prices.get(oldPrice);
            if (occurrence == 1) {
                prices.remove(oldPrice);
            } else {
                prices.put(oldPrice, occurrence - 1);
            }
        }
        timestampToPrice.put(timestamp, price);
        prices.put(price, prices.getOrDefault(price, 0) + 1);
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return timestampToPrice.get(latestTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

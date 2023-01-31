import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public HashMap<String, Integer> map;

    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>();
        for (String str : cpdomains) {
            String[] strs = str.split(" ");
            int count = Integer.parseInt(strs[0]);
            String domain = strs[1];
            String cur = "";
            for (int i = domain.length() - 1; i >= 0; i--) {
                char c = domain.charAt(i);
                if (c == '.') {
                    map.put(cur, map.getOrDefault(cur, 0) + count);
                }
                cur = c + cur;
            }
            map.put(cur, map.getOrDefault(cur, 0) + count);
        }

        LinkedList<String> ans = new LinkedList<>();
        for (String domain : map.keySet()) {
            ans.add(map.get(domain) + " " + domain);
        }
        return ans;
    }
}

//class Solution {
//    class Domain {
//        String name;
//        int count;
//        HashMap<String, Domain> children;
//
//        public Domain(String name, int count) {
//            this.name = name;
//            this.count = count;
//            children = new HashMap<>();
//        }
//    }
//
//    public HashMap<String, Domain> map;
//
//    public void addDomain(String str) {
//        String[] strs = str.split(" ");
//        int count = Integer.parseInt(strs[0]);
//        String[] names = strs[1].split("\\.");
//
//        HashMap<String, Domain> domains = this.map;
//        for (int i = names.length - 1; i >= 0; i--) {
//            String name = names[i];
//            if (domains.containsKey(name)) {
//                domains.get(name).count += count;
//            } else {
//                Domain domain = new Domain(name, count);
//                domains.put(name, domain);
//            }
//            domains = domains.get(name).children;
//        }
//    }
//
//    public void dfs(Domain domain, String str, LinkedList<String> ans) {
//        str = domain.name + str;
//        ans.add(domain.count + " " + str);
//        str = "." + str;
//        for (Domain child : domain.children.values()) {
//            dfs(child, str, ans);
//        }
//    }
//
//    public List<String> subdomainVisits(String[] cpdomains) {
//        map = new HashMap<>();
//        for (String str : cpdomains) {
//            addDomain(str);
//        }
//        LinkedList<String> ans = new LinkedList<>();
//        for (Domain domain : map.values()) {
//            System.out.println("a");
//            dfs(domain, "", ans);
//        }
//        return ans;
//    }
//}

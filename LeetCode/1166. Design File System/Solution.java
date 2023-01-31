import java.util.HashMap;

class TreeNode {
    public int val;
    public HashMap<String, TreeNode> childs;

    public TreeNode() {
        this.val = -1;
        this.childs = new HashMap<>();
    }

    public TreeNode(int val) {
        this.val = val;
        this.childs = new HashMap<>();
    }
}

class FileSystem {
    private TreeNode root;
    public FileSystem() {
        root = new TreeNode();
    }

    public boolean createPath(String path, int value) {
        if (path == "" || path == "/") {
            return false;
        }
        if (path.charAt(0) != '/') {
            return false;
        }
        String[] dirs = path.split("/");
        TreeNode curr = root;
        int i = 1;
        for (; i < dirs.length - 1; i++) {
            String dir = dirs[i];
            if (!curr.childs.containsKey(dir)) {
                return false;
            } else {
                curr = curr.childs.get(dir);
            }
        }
        String leaf = dirs[i];
        if (curr.childs.containsKey(leaf)) {
            return false;
        } else {
            curr.childs.put(leaf, new TreeNode(value));
            return true;
        }
    }

    public int get(String path) {
        if (path == "" || path == "/") {
            return -1;
        }
        if (path.charAt(0) != '/') {
            return -1;
        }
        String[] dirs = path.split("/");
        TreeNode curr = root;
        int i = 1;
        for (; i < dirs.length; i++) {
            String dir = dirs[i];
            if (!curr.childs.containsKey(dir)) {
                return -1;
            } else {
                curr = curr.childs.get(dir);
            }
        }
        return curr.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

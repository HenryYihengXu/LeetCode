class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    TreeNode commonAncestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return commonAncestor;
    }

    public int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, p, q);
        int right = dfs(node.right, p, q);
        int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;
        if (left + right + mid >= 2 && commonAncestor == null) {
            commonAncestor = node;
        }
        return left + right + mid;
    }
}

//class Solution {
//    boolean foundP = false;
//    boolean foundQ = false;
//    TreeNode commonAncestor = null;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        System.out.println(root.val + ", " + (commonAncestor == null ? "null" : commonAncestor.val));
//        boolean foundHere = false;
//        if (root.val == p.val) {
//            foundP = true;
//            foundHere = true;
//            if (commonAncestor == null) {
//                commonAncestor = root;
//            }
//        } else if (root.val == q.val) {
//            foundQ = true;
//            foundHere = true;
//            if (commonAncestor == null) {
//                commonAncestor = root;
//            }
//        }
//
//        if (foundP && foundQ) {
//            return commonAncestor;
//        }
//
//        TreeNode found = null;
//        if (root.left != null) {
//            found = lowestCommonAncestor(root.left, p, q);
//            System.out.println("left found: " + (found == null ? "null" : found.val));
//            if (foundP && foundQ) {
//                return commonAncestor;
//            } else if (found != null) {
//                commonAncestor = root;
//            }
//        }
//
//
//        if (root.right != null) {
//            found = lowestCommonAncestor(root.right, p, q);
//            System.out.println("right found: " + (found == null ? "null" : found.val));
//            if (foundP && foundQ) {
//                return commonAncestor;
//            } else if (found != null) {
//                commonAncestor = root;
//            }
//        }
//
//        if (foundHere || found != null) {
//            return commonAncestor;
//        } else {
//            return null;
//        }
//    }
//
//}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int startValue;
    public int destValue;
    public boolean foundStart;
    public boolean foundDest;
    public boolean firstFoundDest;
    public int startDepth;
    public int destDepth;
    public String ans;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        destDepth = 0;
        startDepth = 0;
        StringBuilder path = new StringBuilder("");
        dfs(root, path, 0, false);
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder path, int depth, boolean isLeft) {
//        System.out.println(node.val + ", " + depth);
        if (node.val == startValue) {
//            System.out.println("found start");
            foundStart = true;
            startDepth = depth;
        }
        if (node.val == destValue) {
//            System.out.println("found dest");
            foundDest = true;
            destDepth = depth;
            if (!foundStart) {
                firstFoundDest = true;
            }
        }
        if (foundStart && foundDest) {
//            System.out.println("found both");
            if (firstFoundDest) {
                ans = path.reverse().toString();
            } else {
                ans = path.toString();
            }
            return;
        }

        if (node.left != null) {
            if (!foundStart && !foundDest) {
                dfs(node.left, path, depth + 1, true);
                if (foundStart && foundDest) {
                    return;
                }
            } else if (foundStart) {
                path.append('L');
                dfs(node.left, path, depth + 1, true);
                if (foundStart && foundDest) {
                    return;
                }
                path.deleteCharAt(path.length() - 1);
            } else if (foundDest) {
                path.append('U');
                dfs(node.left, path, depth + 1, true);
                if (foundStart && foundDest) {
                    return;
                }
                path.deleteCharAt(path.length() - 1);
            }
        }
        if (node.right != null) {
            if (!foundStart && !foundDest) {
                dfs(node.right, path, depth + 1, false);
                if (foundStart && foundDest) {
                    return;
                }
            } else if (foundStart) {
                path.append('R');
                dfs(node.right, path, depth + 1, false);
                if (foundStart && foundDest) {
                    return;
                }
                path.deleteCharAt(path.length() - 1);
            } else if (foundDest) {
                path.append('U');
                dfs(node.right, path, depth + 1, false);
                if (foundStart && foundDest) {
                    return;
                }
                path.deleteCharAt(path.length() - 1);
            }
        }

        if (foundDest && depth <= destDepth) {
            destDepth -= 1;
            path.append(isLeft ? 'L' : 'R');
        }
        if (foundStart && depth <= startDepth) {
            startDepth -= 1;
            path.append('U');
        }
    }

}

//class Solution {
//    public int startValue;
//    public int destValue;
//    String startPath;
//    String destPath;
//
//    public String getDirections(TreeNode root, int startValue, int destValue) {
//        String ans = "";
//        this.startValue = startValue;
//        this.destValue = destValue;
//        dfs(root, new StringBuilder(ans));
//        dfs(root, new StringBuilder(ans));
//        int i = 0;
//        for (; i < Math.min(startPath.length(), destPath.length()); i++) {
//            if (startPath.charAt(i) != destPath.charAt(i)) {
//                break;
//            }
//        }
//        for (int j = 0; j < startPath.length() - i; j++) {
//            ans += "U";
//        }
//        ans = ans + destPath.substring(i);
//        return ans;
//    }
//
//    public boolean dfs(TreeNode node, StringBuilder path) {
//        if (node.val == startValue && startPath == null) {
//            startPath = path.toString();
//            return true;
//        }
//        if (node.val == destValue && destPath == null) {
//            destPath = path.toString();
//            return true;
//        }
//        if (node.left != null) {
//            path.append('L');
//            if (dfs(node.left, path)) {
//                return true;
//            }
//            path.deleteCharAt(path.length() - 1);
//        }
//        if (node.right != null) {
//            path.append('R');
//            if (dfs(node.right, path)) {
//                return true;
//            }
//            path.deleteCharAt(path.length() - 1);
//        }
//        return false;
//    }
//}

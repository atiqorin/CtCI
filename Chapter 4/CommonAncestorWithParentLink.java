import java.util.*;

public class CommonAncestorWithParentLink {
    public static TreeNode commonAncestor(TreeNode a, TreeNode b){
        int diff = depth(a) - depth(b);
        TreeNode small = diff > 0 ? b : a;
        TreeNode deep = diff > 0 ? a : b;
        deep = goUpByDepth(deep, Math.abs(diff));

        while(small != deep && small != null && deep != null){
            small = small.parent;
            deep = deep.parent;
        }
        return small == null || deep == null ? null : small;
    }

    public static TreeNode goUpByDepth(TreeNode n, int depth){
        while(depth > 0 && n != null){
            n = n.parent;
            depth--;
        }
        return n;
    }

    public static int depth(TreeNode n){
        int depth = 0;
        while(n != null){
            n = n.parent;
            depth++;
        }
        return depth;
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    public TreeNode(int data){
        this.data = data;
    }
}

public class Successor {
    public static TreeNode successor(TreeNode node){
        if(node.right != null){
            return leftMostNode(node.right);
        } else {
            TreeNode n = node;
            TreeNode p =  n.parent;
            while(p != null && p.left != n){
                n = p;
                p = p.parent;
            }
            return p;
        }
    }
    public static TreeNode leftMostNode(TreeNode node){
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
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

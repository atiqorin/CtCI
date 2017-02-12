public class CreateMinimalBST {
    public static TreeNode createMinmalBST(int[] arr){
        return createMinmalBST(arr, 0, arr.length - 1);
    }
    public static TreeNode createMinmalBST(int[] arr, int start, int end){
        if(end < start){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinmalBST(arr, start, mid - 1);
        n.left = createMinmalBST(arr, mid + 1, end);
        return n;
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
    }
}
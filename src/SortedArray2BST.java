public class SortedArray2BST {
    public static void main(String[] args) {
        TreeNode tree = sortedArrayToBST(new int[] {-10,-3,0,5,9});
        visitNode(tree);
    }

    private static void visitNode(TreeNode root){
        System.out.print(root.val + " ");
        if (root.left != null){
            visitNode(root.left);
        }
        if (root.right != null){
            visitNode(root.right);
        }
        if(root.left == null && root.right == null) {
            System.out.println();
        }
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + ((hi - lo + 1) / 2);

        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, lo, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, hi);

        return node;
    }
}

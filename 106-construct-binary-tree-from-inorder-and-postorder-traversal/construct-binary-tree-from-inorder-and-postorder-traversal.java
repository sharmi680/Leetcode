class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder);
    }
    private TreeNode build(int[] inorder, int left, int right, int[] postorder) {
        if (left > right) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderMap.get(rootVal);
        root.right = build(inorder, mid + 1, right, postorder);
        root.left = build(inorder, left, mid - 1, postorder);
        return root;
    }
}
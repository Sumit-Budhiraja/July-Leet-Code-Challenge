class Solution {
    int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        int m = inorder.length;
        p = m -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return util(inorder, postorder, 0, m-1, map);
    }
    
    public TreeNode util(int[] inorder, int[] postorder, int s, int e, Map<Integer, Integer> map) {
        if (s > e) return null;
        int curr = postorder[p];
        p--;
        TreeNode node = new TreeNode(curr);
        int index = map.get(curr).intValue();
        if (s == e) return node;
        node.right = util(inorder, postorder, index+1, e, map);
        node.left = util(inorder, postorder, s, index -1, map);
        return node;
    }
}
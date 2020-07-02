class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> answer =new  ArrayList<>();
        if(root==null)
            return answer;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> l   =new ArrayList<>();  // intermediate list containing current level nodes values
            while(size--  >  0 )
            {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
                
            }
        answer.add(0,l); // this is the trick to maintain the reverse level order traversal
        }
        return answer;
    }
}
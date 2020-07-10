class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while(! q.isEmpty()){
            int n = q.size();
            
            if(n > max) max = n;
            
            for(int i=0; i<n; i++){
                TreeNode tn = q.remove(0);
                
                if(tn != null){
                    q.add(tn.left);
                    q.add(tn.right);
                }else{
                    q.add(null);
                    q.add(null);
                }
            }
            
            // trim the queue from left
            while(!q.isEmpty() && q.get(0) == null){
                q.remove(0);
            }
            // trim the queue from right
            while(!q.isEmpty() && q.get(q.size()-1) == null){
                q.remove(q.size()-1);
            }
        }
        
        return max;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer>l = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        st.push(root);
        while(st.isEmpty()==false){
            TreeNode rem = st.pop();
            l.add(rem.val);
            if(rem.right!=null){
                st.push(rem.right);
            }
            if(rem.left!=null){
                st.push(rem.left);
            }
        }
        return l;
    }
}
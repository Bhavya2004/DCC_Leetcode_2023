//Approach:
// i) call the recursive funtion, for the left amd right of root;

// ii) in every node, if we checked left for the left sub tree then we have to check simultaneously for the right of the right subtree.
// by this - preOrder(temp.left,temp1.right);

// iii) in every node, if we checked right for the left sub tree then we have to check simultaneously for the left of the right subtree.
// by this - preOrder(temp.right,temp1.left);

// iv) if both are same then return true;
class Solution {
    public boolean preOrder(TreeNode temp,TreeNode temp1){
        if(temp==null || temp1==null){
            return temp==temp1;
        }
        if(temp.val!=temp1.val) return false;
        
        return preOrder(temp.left,temp1.right) && preOrder(temp.right,temp1.left);
        
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null || preOrder(root.left,root.right); 
    }
}
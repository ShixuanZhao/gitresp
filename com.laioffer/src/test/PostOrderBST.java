package test;

 class TreeNode {
	  public int key;
	   public TreeNode left;
	   public TreeNode right;
	 public TreeNode(int key) {
	      this.key = key;
	   }
 }
public class PostOrderBST {
	public TreeNode reconstruct(int[] post) {
    int[] index = new int[] {post.length - 1};
    return helper(post, index, Integer.MIN_VALUE);
  }
  private TreeNode helper(int[] postOrder, int[] index, int min) {
    if (index[0] < 0 || postOrder[index[0]] <= min) {
      return null;
    }
    TreeNode root = new TreeNode (postOrder[index[0]--]);
    root.right = helper(postOrder, index, root.key);
    root.left = helper(postOrder, index, min);
    return root;
  }
  
  public static void main(String[] args) {
  	int[] post = new int[] {1,4,3,11,8,5};
  	PostOrderBST solution = new PostOrderBST();
  	System.out.println(solution.reconstruct(post));
  }
}


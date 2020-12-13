package test;

public class dfs2 {
	public int minDifference(int[] array) {
    int[] min = new int[]{Integer.MAX_VALUE};
    int total = 0;
    for (int num : array) {
      total += num;
    }
    helper(array, 0, min, 0, 0, total);
    return min[0];
  }

  private void helper(int[] array, int index, int[] min, int curSum, int cnt, int total) {
    if (index == array.length) {
      if (cnt == array.length / 2) {
        min[0] = Math.min(min[0], Math.abs(curSum - (total - curSum)));
      }
      return;
    }
    curSum += array[index];
    helper(array, index + 1, min, curSum, cnt + 1, total);
    curSum -= array[index];
    helper(array, index + 1, min, curSum, cnt - 1, total);
  }
  
  public static void main(String[] args) {
  	dfs2 solution = new dfs2();
  	int[] array = new int[] {3, 7};
  	int min = solution.minDifference(array);
  	System.out.println(min);
  }
}

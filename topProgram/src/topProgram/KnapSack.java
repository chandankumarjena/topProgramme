package topProgram;

public class KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []wt = {1,2,3,5};
		int []pr = {1,4,7,10};
		int capacity = 8;
		System.out.println(KnapSack.getMaxprofit(wt, pr, capacity));
	}

	private static int getMaxprofit(int[] wt, int[] pr, int capacity) {
		// TODO Auto-generated method stub
		if(wt.length == 0 || pr.length == 0 || capacity <= 0) {
			return 0;
		}
		int [][]arr = new int [wt.length][capacity+1];
		
		for(int j = 0; j <= capacity; j++) {
			if(wt[0] <= j) {
				arr[0][j] = pr[0];
			}
		}
		
		for(int i = 1; i < wt.length; i++) {
			for(int j = 1; j<= capacity; j++) {
				int includingProfit = 0;
				if(wt[i] <= j) {
					includingProfit = pr[i] + arr[i-1][j-wt[i]];
				}
				arr[i][j] = Math.max(includingProfit, arr[i-1][j]);
			}
		}
		return arr[wt.length-1][capacity];
	}

}

package topProgram;

public class MinCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []coins = {1, 2, 3, 5};
		int sum = 5;
		System.out.println(MinCoinChange.findMinimumPairs(coins, sum));

	}

	private static int findMinimumPairs(int[] coins, int sum) {
		// TODO Auto-generated method stub
		int numberOfCoins = coins.length;
		if(numberOfCoins == 0 || sum <= 0) {
			return 0;
		}
		
		int [][]arr = new int[numberOfCoins][sum+1];
		
		for(int i = 0 ; i < numberOfCoins ; i++) {
			arr[i][0] = 0;
		}
		
		for(int i = 0; i < numberOfCoins; i++) {
			for(int j = 1; j <= sum; j++) {
				int includingCurrentCoin = Integer.MAX_VALUE;
				int excludingCurrentCoin = Integer.MAX_VALUE;
				if(coins[i] <= j) {
			          includingCurrentCoin = 1 + arr[i][j - coins[i]];
			        }
			        
			        if(i > 0) {
			          excludingCurrentCoin = arr[i - 1][j];
			        }
			        
			        arr[i][j] = Math.min(includingCurrentCoin, excludingCurrentCoin);
			}
		}
		return arr[numberOfCoins - 1][sum];
	}

}

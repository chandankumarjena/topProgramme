package topProgram;

public class CoinExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []coins = {2,3, 5, 10};
		int sum  = 15;
		System.out.println(CoinExchange.totalNumberOfWays(coins, sum));

	}

	private static int totalNumberOfWays(int[] coins, int sum) {
		// TODO Auto-generated method stub
		// return 0 if both the schenarios happens either or
		if(coins.length == 0 || sum <=0) {
			return 0;
		}
		// find the length of total denomination
		int numberOfCoins = coins.length;
		//create a matrix
		int [][]arr = new int[numberOfCoins][sum+1];
		for(int i = 0; i < numberOfCoins; i++) {
			arr[i][0] = 1;
		}
		
		for(int i = 0; i < numberOfCoins; i++) {
		      for(int j = 1; j <= sum; j++) {
		        
		        int includingCurrentCoin = 0;
		        int excludingCurrentCoin = 0;
		        
		        if(coins[i] <= j) {
		          includingCurrentCoin = arr[i][j - coins[i]];
		        }
		        
		        if(i > 0) {
		          excludingCurrentCoin = arr[i - 1][j];
		        }
		        
		        arr[i][j] = includingCurrentCoin + excludingCurrentCoin;
		    }
		 }    
		return arr[numberOfCoins - 1][sum];
	}

}

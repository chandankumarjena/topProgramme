package topProgram;

public class StairProblem {
	//using recursion
	public static int totalCases(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		if(n==2) return 2;
		
		return totalCases(n-1) + totalCases(n-2) + totalCases(n-3);
	}
	
	public static int topDownApproach(int n) {
		return 0;
	}
	
	public static int bottomDownApproach(int n) {
		int []arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i <= n; i++  ) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		return arr[n];
		
	}
	
	public static int improvedBottomDownApproach(int n) {
		int  a =1;
		int b = 1;
		int c = 2;
		int d =0;
		for(int i = 3; i <= n; i++) {
			d = a + b + c;
			a = b;
			b = c;
			c = d;
		}
		return d;
	}
	
	public static int topDown(int[] arr, int n) {
	    if(n == 0) 
	      return 1;
	    if(n == 1) 
	      return 1;
	    if(n == 2) 
	      return 2;
	    
	    if(arr[n] == 0) {
	      arr[n] = topDown(arr, n - 1)
	          + topDown(arr, n - 2)
	          + topDown(arr, n - 3);
	    }
	    
	    return arr[n];
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalCases(4));
		System.out.println(bottomDownApproach(4));
		System.out.println(improvedBottomDownApproach(4));
		System.out.println(topDown(new int[4+1], 4));
		
	}

}

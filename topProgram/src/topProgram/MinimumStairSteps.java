package topProgram;

public class MinimumStairSteps {
	
	public static int topDown(int []arr, int n) {
		if(n == 0)
			return 0;
		if(n == 1 || n== 2 || n == 3) {
			return 1;
		}
		if(arr[n] == 0) {
			arr[n] = 1 + Math.min(Math.min(topDown(arr, n-1), topDown(arr, n-2)), topDown(arr, n-3));
		}
		return arr[n];
	}
	
	public static int bottomUp(int n) {
		int []f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			f[i] = 1 + Math.min(Math.min(f[i-1], f[i-2]), f[i-3]);
		}
		return f[n];
	}
	
	public static int bottomUpImproved(int n) {
		int a = 0;
		int b = 1;
		int c = 1;
		int d = 0;
		for(int i = 3; i <= n; i++) {
			d = 1 + Math.min(Math.min(a, b), c);
			a = b;
			b = c;
			c = d;
		}
		return d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(topDown(new int[6], 5));
		System.out.println(bottomUp(5));
		System.out.println(bottomUpImproved(5));
	}

}

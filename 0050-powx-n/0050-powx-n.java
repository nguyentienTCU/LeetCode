class Solution {
    public double myPow(double x, int n) {
        if(n==0) {
			return 1;
		}
		
		int halfN = 0;
		if(n<0) {
			halfN = -(n/2);
			x = 1/x;
		}else {
			halfN = n/2;
		}
		double t;
		if(n%2==0) {
			t = myPow(x, halfN);
			return t*t;
		}else {
			t = myPow(x, halfN);
		}
		return x*t*t;
    }
}
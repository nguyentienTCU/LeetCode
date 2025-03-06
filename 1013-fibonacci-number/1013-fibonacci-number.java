class Solution {
    int[] fib = new int[31];
    public int fib(int n) {
        if(fib[n]!=0){
            return fib[n];
        }
        if(n<=1){
            fib[n] = n;
            return n;
        }
        fib[n] = fib(n-1)+fib(n-2);
        return fib[n];
    }
}
class Solution {
    private boolean[][] checkPalindrome;
    public String longestPalindrome(String s) {
        int n = s.length();
        this.checkPalindrome = new boolean[n][n];
        int max = 0;
        int start = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(j-i+1>max){
                    if(isPalindrome(s,i,j)){
                        max = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+max);
    }

    private boolean isPalindrome(String s, int i, int j){
;        while(i<j){
            if (s.charAt(i) != s.charAt(j)) {
            checkPalindrome[i][j] = false;
            return false;
        }
            i++;
            j--;
        }
        checkPalindrome[i][j] = true;
        return true;
    }
}
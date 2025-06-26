class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> check = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int right=0; right<s.length(); right++){
            char current = s.charAt(right);
            while(check.contains(current)){
                check.remove(s.charAt(left));
                left++;
            }
            check.add(current);
            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
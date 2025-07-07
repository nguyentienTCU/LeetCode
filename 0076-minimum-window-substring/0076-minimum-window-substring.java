class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int matchCount = 0;

        for(int right=0; right<s.length(); right++){
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0)+1);

            if(map.containsKey(rightChar) && window.get(rightChar).intValue()<=map.get(rightChar).intValue()){
                matchCount++;
            }

            while(matchCount == t.length()){
                if(right-left+1 < minLength){
                    minStart = left;
                    minLength = right-left+1;
                }
                
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(map.containsKey(leftChar) && window.get(leftChar).intValue()<map.get(leftChar).intValue()){
                    matchCount--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
}
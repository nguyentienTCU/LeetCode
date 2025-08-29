class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length()) return false;
        int[] charsNum = new int[26];

        for(char c : magazine.toCharArray()){
            charsNum[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(charsNum[c-'a'] == 0) return false;
            charsNum[c-'a']--;
        }

        return true;
    }
}

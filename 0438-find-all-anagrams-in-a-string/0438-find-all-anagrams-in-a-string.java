class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if(m<n) return ans;

        int[] need = new int[26];
        for(char c : p.toCharArray()) need[c-'a']++;

        int[] window = new int[26];
        int matches=0;

        for(int i=0; i<n; i++){
            int idx = s.charAt(i)-'a';
            window[idx]++;
        }

        for(int i=0; i<26; i++){
            if(window[i]==need[i]) matches++;
        }

        if(matches==26) ans.add(0);

        for(int right=n; right<m; right++){
            int add = s.charAt(right)-'a';
            int remove = s.charAt(right-n)-'a';

            if(window[add]==need[add]) matches--;
            window[add]++;
            if(window[add]==need[add]) matches++;

            if(window[remove]==need[remove]) matches--;
            window[remove]--;
            if(window[remove]==need[remove]) matches++;

            if(matches==26) ans.add(right-n+1);
        }

        return ans;
    }
}
class Solution {
    private final String[] KEY = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length()==0) return res;
        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb, res);
        return res;
    }

    public void backtrack(String digits, int i, StringBuilder sb, List<String> res){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = KEY[digits.charAt(i)-'0'];
        for(char c : letters.toCharArray()){
            sb.append(c);
            backtrack(digits, i+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
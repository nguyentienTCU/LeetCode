class Solution {
    public boolean isValid(String s) {
       Stack<Character> parentheses = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                parentheses.push(c);
            }else {
                if(parentheses.isEmpty()){
                    return false;
                }

                char bracket = parentheses.pop();
                if(bracket=='(' && c!=')'){
                    return false;
                }else if(bracket=='{' && c!='}'){
                    return false;
                } else if(bracket=='[' && c!=']'){
                    return false;
                }

            }
        }
        return parentheses.isEmpty();
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c==']'){
                String str = "";
                while(stack.peek()!='['){
                    str = stack.pop()+str;
                }
                stack.pop();
                String number = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    number = stack.pop()+number;
                }
                int n = Integer.parseInt(number);
                str = str.repeat(n);
                for(int j=0; j<str.length();j++){
                    stack.push(str.charAt(j));
                }
            }else{
                stack.push(c);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = stack.pop()+result;
        }
        return result;
    }
}
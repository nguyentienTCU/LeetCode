class Solution {
    public int calculate(String s) {
        int n = s.length();
        int num = 0;
        char op = '+';
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }

            if((!Character.isDigit(c) && c!=' ') || i==n-1){
                switch(op){
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop()*num);
                        break;
                    case '/':
                        st.push(st.pop()/num);
                        break;
                }
                op=c;
                num=0;
            }
        }
        int ans=0;
        while(!st.isEmpty()) ans+=st.pop();
        return ans;
    }
}
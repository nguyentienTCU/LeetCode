class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a;
        int b;
        for(String t : tokens){
            switch(t){
                case "+":
                    st.push(st.pop()+st.pop());
                    break;
                case "-":
                    b = st.pop();
                    a = st.pop();
                    st.push(a-b);
                    break;
                case "*":
                    st.push(st.pop()*st.pop());
                    break;
                case "/":
                    b = st.pop();
                    a = st.pop();
                    st.push(a/b);
                    break;
                default:
                    st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
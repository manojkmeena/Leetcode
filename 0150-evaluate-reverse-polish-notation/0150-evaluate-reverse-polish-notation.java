class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b + a);
            }
            else if(s.equals("-")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b - a);
            }
            else if(s.equals("*")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b * a);
            }
            else if(s.equals("/")){
                int a = stk.pop();
                int b = stk.pop();
                stk.push(b / a);
            }
            else{
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.peek();
    }
}
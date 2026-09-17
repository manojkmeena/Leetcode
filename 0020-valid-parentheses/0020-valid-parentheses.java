class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' && !stk.isEmpty() && stk.peek() == '('){
                stk.pop();
            }
            else if(c == ']' && !stk.isEmpty() && stk.peek() == '['){
                stk.pop();
            }
            else if(c == '}' && !stk.isEmpty() && stk.peek() == '{'){
                stk.pop();
            }
            else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}
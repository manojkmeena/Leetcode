class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stk.isEmpty())
                    stk.pop();
            } else if (log.equals("./")) {
                continue;
            } else {
                stk.push(log);
            }
        }
        return stk.isEmpty() ? 0 : stk.size();
    }
}
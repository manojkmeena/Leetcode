class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                operations = Math.max(0, operations - 1);
            } else if (log.equals("./")) {
                continue;
            } else {
                operations++;
            }
        }
        return operations;
    }
}
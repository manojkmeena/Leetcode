class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stk = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int startIdx = i;
            while(!stk.isEmpty() && stk.peek()[1] > heights[i]){
                int[] popped = stk.pop();
                int area = popped[1] * (i - popped[0]);
                maxArea = Math.max(maxArea, area);
                startIdx = popped[0];
            }
            stk.push(new int[]{startIdx, heights[i]});
        }
        while(!stk.isEmpty()){
            int[] popped = stk.pop();
            int area = popped[1] * (heights.length - popped[0]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
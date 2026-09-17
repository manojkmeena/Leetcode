class Solution {
    public int trap(int[] height) {
        int totalUnit = 0;
        int leftp = 0;
        int rightp = height.length-1;
        int leftMax = height[leftp];
        int rightMax = height[rightp];
        while(leftp < rightp){
            if(leftMax < rightMax){
                leftp++;
                leftMax = Math.max(leftMax, height[leftp]);
                totalUnit += leftMax - height[leftp];
            }
            else{
                rightp--;
                rightMax = Math.max(rightMax, height[rightp]);
                totalUnit += rightMax - height[rightp];
            }
        }
        return totalUnit;
    }
}
class Solution {
    public int trap(int[] height) {
        int totalUnit = 0;
        int leftp = 0;
        int rightp = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(leftp <= rightp){
            if(leftMax < rightMax){
                int unit = Math.min(leftMax,rightMax) - height[leftp];
                totalUnit = unit > 0 ? totalUnit + unit : totalUnit;
                leftMax = Math.max(leftMax, height[leftp]);
                leftp++;
            }
            else{
                int unit = Math.min(leftMax,rightMax) - height[rightp];
                totalUnit = unit > 0 ? totalUnit + unit : totalUnit;
                rightMax = Math.max(rightMax, height[rightp]);
                rightp--;
            }
        }
        return totalUnit;
    }
}
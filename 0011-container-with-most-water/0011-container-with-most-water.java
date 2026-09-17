class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftp = 0;
        int rightp = height.length -1;
        while(leftp < rightp){
            int length = rightp - leftp;
            int width = Math.min(height[leftp], height[rightp]);
            int area = length * width;
            maxArea = Math.max(maxArea, area);
            if(height[leftp] < height[rightp])
                leftp ++;
            else
                rightp --;
        }
        return maxArea;
    }
}
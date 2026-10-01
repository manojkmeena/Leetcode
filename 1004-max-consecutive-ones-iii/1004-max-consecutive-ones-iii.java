class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int flipped = 0;
        int maxWindowSize = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                flipped++;
            }
            while (flipped > k) {
                if (nums[l] == 0) {
                    flipped--;
                }
                l++;
            }
            maxWindowSize = Math.max(maxWindowSize, r - l + 1);
            r++;
        }
        return maxWindowSize;
    }
}
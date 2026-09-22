class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];
        while (l <= r) {
            if (nums[l] < nums[r]) {
                return Math.min(nums[l], res);
            }
            int m = (l + r) / 2;
            res = Math.min(nums[m], res);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
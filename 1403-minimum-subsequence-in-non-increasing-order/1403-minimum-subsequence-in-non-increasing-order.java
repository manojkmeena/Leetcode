class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int currSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(nums[i]);
            currSum += nums[i];
            if (currSum > totalSum - currSum) {
                break;
            }
        }
        return res;
    }
}
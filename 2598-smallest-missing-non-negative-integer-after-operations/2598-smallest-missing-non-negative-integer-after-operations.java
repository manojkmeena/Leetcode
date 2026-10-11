class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] modFreqList = new int[value];
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            modFreqList[mod]++;
        }
        int mex = 0;
        while (true) {
            int modMex = mex % value;
            if (modFreqList[modMex] > 0) {
                modFreqList[modMex]--;
                mex++;
            } else {
                break;
            }
        }
        return mex;
    }
}
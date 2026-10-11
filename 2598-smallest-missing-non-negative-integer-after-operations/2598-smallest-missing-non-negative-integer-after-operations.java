class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> modFreqMap = new HashMap<>();
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            modFreqMap.put(mod, modFreqMap.getOrDefault(mod, 0) + 1);
        }
        int mex = 0;
        while (true) {
            int modMex = mex % value;
            if (modFreqMap.containsKey(modMex) && modFreqMap.get(modMex) > 0) {
                modFreqMap.put(modMex, modFreqMap.get(modMex) - 1);
            } else {
                break;
            }
            mex++;
        }
        return mex;
    }
}
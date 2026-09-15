class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> freqArray = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            freqArray.add(new ArrayList<>());
        }
        freqMap.forEach((value,freq) -> {
            freqArray.get(freq).add(value);
        });

        int[] res = new int[k];
        int idx = 0;
        for(int i = freqArray.size() - 1; i >=0; i--){
            for(int num: freqArray.get(i)){
                res[idx] = num;
                idx++;
                if(idx == k)
                    return res;
            }
        }
        return res;
    }
}
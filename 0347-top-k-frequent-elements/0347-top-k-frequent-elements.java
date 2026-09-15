class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency Map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // array with freq as index
        List<Integer>[] freqArray = new List[nums.length + 1];
        for (int i = 0; i < freqArray.length; i++) {
            freqArray[i] = new ArrayList<>();
        }
        freqMap.forEach((key, value) -> freqArray[value].add(key));

        // traverse freq array from back and return
        int[] res = new int[k];
        int index = 0;
        for(int i = freqArray.length -1; i>=0; i--){
            for(int value: freqArray[i]){
                res[index] = value;
                index ++;
                if(index == k){
                    return res;
                }
            }
        }
        return res;
    }
}
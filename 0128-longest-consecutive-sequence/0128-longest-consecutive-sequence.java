class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for(int num : set){
            if(set.contains(num-1))
                continue;
            int currentNum = num + 1;
            int currentLength = 1;
            while(set.contains(currentNum)){
                currentNum++;
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
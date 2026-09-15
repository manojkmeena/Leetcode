class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> counts = new HashSet<>();
        for(int i : nums){
            if (!counts.add(i)){
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preffix = new int[nums.length];
        int[] suffix = new int[nums.length];
        preffix[0] = 1;
        for(int i = 1; i < nums.length; i++){
            preffix[i] = preffix[i-1] * nums[i-1];
        }
        suffix[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = preffix[i] * suffix[i];
        }
        return res;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int p1=0; p1<nums.length-2; p1++){
            if(nums[p1] > 0) break;
            if(p1!= 0 && nums[p1] == nums[p1-1]) continue;
            int p2 = p1+1;
            int p3 = nums.length-1;
            while(p2<p3){
                int sum = nums[p1] + nums[p2] + nums[p3];
                if(sum == 0){
                    res.add(Arrays.asList(nums[p1] , nums[p2] , nums[p3]));
                    p2++;
                    p3--;
                    while(p2<p3 && nums[p2] == nums[p2-1]) p2++;
                }
                else if(sum > 0) p3--;
                else p2++;
            }
        }
        return res;
    }
}
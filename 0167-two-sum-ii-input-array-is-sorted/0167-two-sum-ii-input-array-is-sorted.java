class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                int[] sol = {i+1,j+1};
                return sol;
            }
            if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[2];
    }
}
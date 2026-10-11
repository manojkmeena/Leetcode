class Solution {
    public int countLargestGroup(int n) {
        int[] sumFreq = new int[37];
        int maxSize = 0;
        int maxGroupCount = 0;
        for (int i = 1; i <= n; i++) {
            int digitSum = digitSum(i);
            sumFreq[digitSum]++;
            if (maxSize < sumFreq[digitSum]) {
                maxSize = sumFreq[digitSum];
                maxGroupCount = 1;
            } else if (maxSize == sumFreq[digitSum]) {
                maxGroupCount++;
            }
        }
        return maxGroupCount;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
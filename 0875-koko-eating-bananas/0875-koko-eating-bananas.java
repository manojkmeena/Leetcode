class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;
            long timeToEat = 0;
            for (int p : piles) {
                timeToEat += (p + k - 1) / k; // round up div
            }
            if (timeToEat > h) {
                l = k + 1;
            } else {
                res = Math.min(res, k);
                r = k - 1;
            }
        }
        return res;
    }
}
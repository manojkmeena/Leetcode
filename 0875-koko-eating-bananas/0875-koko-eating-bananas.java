class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        
        int minK = r;
        while (l <= r) {
            int k = (l + r) / 2;
            long timeToEat = 0;
            for (int p : piles) {
                timeToEat += (p + k - 1) / k; // round up div
            }
            if (timeToEat > h) {
                l = k + 1;
            } else {
                minK = Math.min(minK, k);
                r = k - 1;
            }
        }
        return minK;
    }
}
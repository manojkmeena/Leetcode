class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small;
        int[] big;
        if (nums1.length <= nums2.length) {
            small = nums1;
            big = nums2;
        } else {
            small = nums2;
            big = nums1;
        }

        int totalSize = small.length + big.length;
        int half = totalSize / 2;

        int l = 0;
        int r = small.length;
        while (l <= r) {
            int m = (l + r) / 2;
            int smallend = m - 1 >= 0 ? small[m - 1] : Integer.MIN_VALUE;
            int smallnext = m < small.length ? small[m] : Integer.MAX_VALUE;
            int bigend = half - m - 1 >= 0 ? big[half - m - 1] : Integer.MIN_VALUE;
            int bignext = half - m < big.length ? big[half - m] : Integer.MAX_VALUE;
            if ((smallend <= bignext) && (bigend <= smallnext)) {
                if (totalSize % 2 == 0) {
                    return (Math.max(smallend, bigend) + Math.min(smallnext, bignext)) / 2.0;
                }
                return Math.min(smallnext, bignext);
            }
            if (smallend > bignext) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
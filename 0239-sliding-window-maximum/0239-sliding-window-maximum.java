class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int l = 0;
        int r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while (r < nums.length) {
            while (!dq.isEmpty() && dq.getLast() < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(nums[r]);
            if (r - l + 1 == k) {
                res[index++] = dq.getFirst();
                if (nums[l] == dq.getFirst()) {
                    dq.removeFirst();
                }
                l++;
            }
            r++;
        }
        return res;
    }
}
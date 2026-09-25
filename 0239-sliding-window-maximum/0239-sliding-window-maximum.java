class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        int l = 0;
        int r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while (r < nums.length) {
            // deque in decreasing order
            while (!dq.isEmpty() && dq.getLast() < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(nums[r]);
            // fix window
            if (r - l + 1 == k) {
                res[index++] = dq.getFirst(); // first always max
                // if first element is the one moved out of window
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
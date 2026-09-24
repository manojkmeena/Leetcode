class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxSub = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            maxSub = Math.max(maxSub, set.size());
        }
        return maxSub;
    }
}
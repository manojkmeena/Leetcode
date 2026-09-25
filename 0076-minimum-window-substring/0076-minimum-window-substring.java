class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> sWindowCount = new HashMap<>();
        // have = satisfied unique chars, need = required unique chars
        int have = 0;
        int need = tCount.size();
        int minLength = Integer.MAX_VALUE;
        int[] res = { -1, -1 };
        int l = 0;
        // Expand window using right pointer
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sWindowCount.put(c, sWindowCount.getOrDefault(c, 0) + 1);
            // Mark character as satisfied when required frequency is reached
            if (tCount.containsKey(c) && tCount.get(c).equals(sWindowCount.get(c))) {
                have++;
            }
            // Shrink window while all required characters are satisfied
            while (have == need) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    res = new int[] { l, r };
                }
                char lc = s.charAt(l);
                sWindowCount.put(lc, sWindowCount.get(lc) - 1);
                // Mark character as unsatisfied if its required count is lost
                if (tCount.containsKey(lc) && tCount.get(lc) > sWindowCount.get(lc)) {
                    have--;
                }
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> sWindowCount = new HashMap<>();
        int have = 0;
        int need = tCount.size();
        int minLength = Integer.MAX_VALUE;
        String res = "";
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sWindowCount.put(c, sWindowCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && tCount.get(c).equals(sWindowCount.get(c))) {
                have++;
            }
            while (have == need) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                char lc = s.charAt(l);
                sWindowCount.put(lc, sWindowCount.get(lc) - 1);
                if (tCount.containsKey(lc) && tCount.get(lc) > sWindowCount.get(lc)) {
                    have--;
                }
                l++;
            }
        }
        return res;
    }
}
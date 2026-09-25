class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1CharFreq = new int[26];
        int[] s2WindowCharFreq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1CharFreq[s1.charAt(i) - 'a'] += 1;
            s2WindowCharFreq[s2.charAt(i) - 'a'] += 1;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1CharFreq[i] == s2WindowCharFreq[i]) {
                matches++;
            }
        }
        int l = 0;
        int r = s1.length();
        while (r < s2.length()) {
            if (matches == 26) {
                return true;
            }
            int rIndex = s2.charAt(r) - 'a';
            s2WindowCharFreq[rIndex] += 1;
            if (s1CharFreq[rIndex] == s2WindowCharFreq[rIndex]) {
                matches++;
            } else if (s1CharFreq[rIndex] + 1 == s2WindowCharFreq[rIndex]) {
                matches--;
            }
            int lIndex = s2.charAt(l) - 'a';
            s2WindowCharFreq[lIndex] -= 1;
            if (s1CharFreq[lIndex] == s2WindowCharFreq[lIndex]) {
                matches++;
            } else if (s1CharFreq[lIndex] - 1 == s2WindowCharFreq[lIndex]) {
                matches--;
            }
            r++;
            l++;
        }
        return matches == 26;
    }
}
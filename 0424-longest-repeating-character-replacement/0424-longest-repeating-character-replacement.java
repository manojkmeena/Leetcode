class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int[] windowCharcount = new int[26];
        int maxRepeating = 0;
        for (int r = 0; r < s.length(); r++) {
            int windowsize = r - l + 1;
            windowCharcount[s.charAt(r) - 'A'] += 1;
            while (windowsize - getMaxFreq(windowCharcount) > k) {
                windowCharcount[s.charAt(l) - 'A'] -= 1;
                l++;
                windowsize--;
            }
            maxRepeating = Math.max(maxRepeating, windowsize);
        }
        return maxRepeating;
    }

    private int getMaxFreq(int[] windowCharcount) {
        int maxFreq = 0;
        for (int freq : windowCharcount) {
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}
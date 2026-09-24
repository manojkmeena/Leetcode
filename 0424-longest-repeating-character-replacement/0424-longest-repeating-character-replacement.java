class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int windowsize = 0;
        int[] charcount = new int[26];
        int maxRepeating = 0;
        for (int r = 0; r < s.length(); r++) {
            windowsize++;
            charcount[s.charAt(r) - 'A'] += 1;
            while (windowsize - getMaxFreq(charcount) > k) {
                windowsize--;
                charcount[s.charAt(l) - 'A'] -= 1;
                l++;
            }
            maxRepeating = Math.max(maxRepeating, windowsize);
        }
        return maxRepeating;
    }

    private int getMaxFreq(int[] charcount) {
        int maxFreq = 0;
        for (int freq : charcount) {
            maxFreq = Math.max(maxFreq, freq);
        }
        return maxFreq;
    }
}
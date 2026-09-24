class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int[] windowCharcount = new int[26];
        int maxRepeating = 0;
        for (int r = 0; r < s.length(); r++) {
            int windowsize = r - l + 1;
            windowCharcount[s.charAt(r) - 'A'] += 1;
            int mazFreq = Arrays.stream(windowCharcount).max().getAsInt();
            while (windowsize - mazFreq > k) {
                windowCharcount[s.charAt(l) - 'A'] -= 1;
                l++;
                windowsize--;
            }
            maxRepeating = Math.max(maxRepeating, windowsize);
        }
        return maxRepeating;
    }
}
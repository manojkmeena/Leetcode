class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1CharFreq = new int[26];
        int[] s2WindowCharFreq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1CharFreq[s1.charAt(i) - 'a'] += 1;
            s2WindowCharFreq[s2.charAt(i) - 'a'] += 1;
        }
        int l = 0;
        int r = s1.length();
        while (r < s2.length()) {
            if (Arrays.equals(s1CharFreq, s2WindowCharFreq)) {
                return true;
            } else {
                s2WindowCharFreq[s2.charAt(l) - 'a'] -= 1;
                s2WindowCharFreq[s2.charAt(r) - 'a'] += 1;
                l++;
                r++;
            }
        }
        return Arrays.equals(s1CharFreq, s2WindowCharFreq);
    }
}
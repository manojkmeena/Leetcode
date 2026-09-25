class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharFreq = new int[26];
        for(char c : s1.toCharArray()){
            s1CharFreq[c - 'a'] += 1;
        }
        int[] s2WindowCharFreq = new int[26];
        int l = 0;
        int r = 0;
        while(r < s2.length()){
            if(r<s1.length()){
                s2WindowCharFreq[s2.charAt(r) - 'a'] += 1;
                r++;
                continue;
            }
            if(Arrays.equals(s1CharFreq, s2WindowCharFreq)){
                return true;
            }
            else{
                s2WindowCharFreq[s2.charAt(l) - 'a'] -= 1;
                s2WindowCharFreq[s2.charAt(r) - 'a'] += 1;
                l++;
                r++;
            }
        }
        if(Arrays.equals(s1CharFreq, s2WindowCharFreq)){
            return true;
        }
        return false;
    }
}
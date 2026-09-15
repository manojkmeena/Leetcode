class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] hashtable = new int[26];
        for(int i = 0; i < s.length(); i++){
            hashtable[s.charAt(i) - 'a'] ++ ;
            hashtable[t.charAt(i) - 'a'] -- ;
        }
        for(int r : hashtable){
            if(r!=0){
                return false;
            }
        }
        return true;
    }
}
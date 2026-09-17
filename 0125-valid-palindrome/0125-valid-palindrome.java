class Solution {
    public boolean isPalindrome(String s) {
        String alhpaNum = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] arr = alhpaNum.toCharArray();
        for(int i = 0, j = arr.length - 1; i<j; i++, j--){
            if(arr[i] != arr[j]) return false;
        }
        return true;
    }
}
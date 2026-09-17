class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0, j = arr.length - 1; i<j; i++, j--){
            while(!Character.isLetterOrDigit(arr[i]) && i<j) i++;
            while(!Character.isLetterOrDigit(arr[j]) && i<j) j--;
            if(Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) return false;
        }
        return true;
    }
}
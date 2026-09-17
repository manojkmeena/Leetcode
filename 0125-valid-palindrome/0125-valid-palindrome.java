class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i<j){
            while(!Character.isLetterOrDigit(arr[i]) && i<j) i++;
            while(!Character.isLetterOrDigit(arr[j]) && i<j) j--;
            if(Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) return false;
            i++;
            j--;
        }
        return true;
    }
}
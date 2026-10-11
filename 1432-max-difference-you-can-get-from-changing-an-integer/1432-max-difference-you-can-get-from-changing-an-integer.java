class Solution {
    public int maxDiff(int num) {
        String sNum = String.valueOf(num);
        char[] maxNum = sNum.toCharArray();
        char x = 'x';
        for (int i = 0; i < maxNum.length; i++) {
            if (maxNum[i] != '9' && x == 'x') {
                x = maxNum[i];
            }
            if (x != 'x' && maxNum[i] == x) {
                maxNum[i] = '9';
            }
        }
        char[] minNum = sNum.toCharArray();
        x = 'x';
        char y = '1';
        if(minNum[0] != '1'){
            x = minNum[0];
        }
        for (int i = 0; i < minNum.length; i++) {
            if (minNum[i] != '1' && minNum[i] != '0' && x == 'x') {
                x = minNum[i];
                y = '0';
            }
            if (x != 'x' && minNum[i] == x) {
                minNum[i] = y;
            }
        }
        return Integer.valueOf(new String(maxNum)) - Integer.valueOf(new String(minNum));
    }
}
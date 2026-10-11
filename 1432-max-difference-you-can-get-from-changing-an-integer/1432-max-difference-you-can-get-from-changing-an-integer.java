class Solution {
    public int maxDiff(int num) {
        String maxNum = String.valueOf(num);
        char x = 'x';
        for (int i = 0; i < maxNum.length(); i++) {
            if (maxNum.charAt(i) != '9' && x == 'x') {
                x = maxNum.charAt(i);
            }
        }
        maxNum = maxNum.replace(x, '9');
        String minNum = String.valueOf(num);
        x = 'x';
        char y = '1';
        if (minNum.charAt(0) != '1') {
            x = minNum.charAt(0);
        } else {
            for (int i = 1; i < minNum.length(); i++) {
                if (minNum.charAt(i) != '1' && minNum.charAt(i) != '0'
                        && x == 'x') {
                    x = minNum.charAt(i);
                    y = '0';
                }
            }
        }
        minNum = minNum.replace(x, y);
        return Integer.valueOf(maxNum) - Integer.valueOf(minNum);
    }
}
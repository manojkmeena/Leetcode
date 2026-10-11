class Solution {
    public int maxDiff(int num) {
        String maxNum = String.valueOf(num);
        char x = 'x';
        for (int i = 0; i < maxNum.length(); i++) {
            char c = maxNum.charAt(i);
            if (c != '9' && x == 'x') {
                x = c;
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
                char c = minNum.charAt(i);
                if (c != '1' && c != '0' && x == 'x') {
                    x = c;
                    y = '0';
                }
            }
        }
        minNum = minNum.replace(x, y);
        return Integer.valueOf(maxNum) - Integer.valueOf(minNum);
    }
}
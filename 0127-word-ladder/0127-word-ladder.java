class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Deque<String> dq = new ArrayDeque<>();
        dq.offer(beginWord);
        words.remove(beginWord);

        int level = 1;
        while (!dq.isEmpty()) {
            int dqSize = dq.size();
            for (int i = 0; i < dqSize; i++) {
                String curWord = dq.poll();
                if (curWord.equals(endWord)) {
                    return level;
                }
                char[] chars = curWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (words.contains(nextWord)) {
                            dq.offer(nextWord);
                            words.remove(nextWord);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}
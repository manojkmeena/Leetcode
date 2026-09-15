class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rseen = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cseen = new HashMap<>();
        HashMap<Integer, HashSet<Character>> sqseen = new HashMap<>();
        for(int c=0; c < 9; c++){
            for(int r=0; r < 9; r++){
                char value = board[r][c];
                if(value == '.') continue;
                int sq = (r/3)*3 + (c/3);
                
                rseen.putIfAbsent(r, new HashSet<>());
                cseen.putIfAbsent(c, new HashSet<>());
                sqseen.putIfAbsent(sq, new HashSet<>());

                if(!rseen.get(r).add(value)) return false;
                if(!cseen.get(c).add(value)) return false;
                if(!sqseen.get(sq).add(value)) return false;
            }
        }
        return true;
    }
}
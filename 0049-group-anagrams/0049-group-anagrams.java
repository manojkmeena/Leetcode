class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String sorteds = new String(sc);
            map.putIfAbsent(sorteds, new ArrayList());
            map.get(sorteds).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
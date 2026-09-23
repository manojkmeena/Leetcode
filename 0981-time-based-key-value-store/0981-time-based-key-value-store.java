class TimeMap {

    Map<String, List<Pair<Integer, String>>> tmap;

    public TimeMap() {
        tmap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        tmap.putIfAbsent(key, new ArrayList<>());
        tmap.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairs = tmap.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = pairs.size() - 1;
        String res = "";
        while (l <= r) {
            int m = (l + r) / 2;
            if (pairs.get(m).getKey() <= timestamp) {
                res = pairs.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
class UndergroundSystem {

    HashMap<Integer, String> checkinStation;
    HashMap<Integer, Integer> checkinTime;
    HashMap<String, int[]> routeMap;

    public UndergroundSystem() {
        checkinStation = new HashMap<>();
        checkinTime = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkinStation.put(id, stationName);
        checkinTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = checkinStation.get(id);
        int startTime = checkinTime.get(id);
        String route = startStation + "-" + stationName;
        int totalTime = routeMap.containsKey(route) ? routeMap.get(route)[0] + t - startTime : t - startTime;
        int totalCount = routeMap.containsKey(route) ? routeMap.get(route)[1] + 1 : 1;
        routeMap.put(route, new int[] { totalTime, totalCount });
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int totalTime = routeMap.get(route)[0];
        int totalCount = routeMap.get(route)[1];
        return (double) totalTime / totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    // Helper class to store active check-in details for a customer
    private static class CheckInInfo {
        final String station;
        final int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class to track aggregated duration and trip counts for a route
    private static class RouteStats {
        double totalTime;
        int count;

        RouteStats(int time) {
            this.totalTime = time;
            this.count = 1;
        }

        void addTrip(int time) {
            this.totalTime += time;
            this.count++;
        }

        double getAverage() {
            return totalTime / count;
        }
    }

    // Tracks customer id -> active check-in information
    private final Map<Integer, CheckInInfo> checkInMap;

    // Tracks "startStation->endStation" -> aggregated statistics
    private final Map<String, RouteStats> routeStatsMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeStatsMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove customer's active trip in O(1)
        CheckInInfo checkIn = checkInMap.remove(id);
        int duration = t - checkIn.time;

        String routeKey = checkIn.station + "->" + stationName;

        // Aggregate statistics for this route in O(1)
        RouteStats stats = routeStatsMap.get(routeKey);
        if (stats == null) {
            routeStatsMap.put(routeKey, new RouteStats(duration));
        } else {
            stats.addTrip(duration);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        return routeStatsMap.get(routeKey).getAverage();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
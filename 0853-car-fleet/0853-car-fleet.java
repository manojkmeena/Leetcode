class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeedPair = new int[position.length][2];
        for(int i=0; i<position.length; i++){
            posSpeedPair[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(posSpeedPair, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> fleetTime = new Stack<>(); 
        for(int[] car : posSpeedPair){
            double currentCarTime = (double)(target - car[0]) / car[1];
            if(fleetTime.isEmpty() || fleetTime.peek() < currentCarTime){
                fleetTime.push(currentCarTime);
            }
        }
        return fleetTime.size();
    }
}
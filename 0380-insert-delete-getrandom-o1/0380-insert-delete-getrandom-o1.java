class RandomizedSet {
    // Stores values contiguously for uniform O(1) random sampling by index
    private final List<Integer> list;
    // Maps value -> index in 'list' for O(1) existence checks and index lookups
    private final Map<Integer, Integer> valToIndex;
    private final Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // Add to the end of the list and record its index in the map
        valToIndex.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes val from the set if present.
     * Uses swap-with-last trick to achieve O(1) array deletion.
     */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int indexToRemove = valToIndex.get(val);
        int lastElement = list.get(list.size() - 1);
        // Move the last element to the position of the element being removed
        list.set(indexToRemove, lastElement);
        valToIndex.put(lastElement, indexToRemove);
        // Remove the last element (now a duplicate) in O(1)
        list.remove(list.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
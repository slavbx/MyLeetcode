package org.leetcode;

import java.util.*;

class Task380 {
    Map<Integer, Integer> map;
    List<Integer> keys;
    Random rnd;

    public Task380() {
        this.map = new HashMap<>();
        this.keys = new ArrayList<>();
        this.rnd = new Random();
    }

    public boolean insert(int val) {
        boolean result = !map.containsKey(val);
        map.put(val, 0);
        if (result) keys.add(val);
        return result;
    }

    public boolean remove(int val) {
        boolean result = map.containsKey(val);
        map.remove(val);
        keys.remove(Integer.valueOf(val));
        return result;
    }

    public int getRandom() {
        return keys.get(rnd.nextInt(keys.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

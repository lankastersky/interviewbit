/*
LRU Cache

Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get
and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should 
invalidate the least recently used item before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of 
unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently 
used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 

https://www.interviewbit.com/problems/lru-cache/
*/

public class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    Integer cache[]; // a cyclic array
    int cur = 0; // pos of the next available slot in the cache
    
    public Solution(int capacity) {
        cache = new Integer[capacity];
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            updateCache(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            updateCache(key);
            return;
        }
        Integer keyToRemove = cache[cur];
        if (keyToRemove != null) {
            map.remove(keyToRemove);
        }
        map.put(key, value);
        cache[cur] = key;
        cur = (cur + 1) % cache.length;
        printCache();
    }
    
    void updateCache(int key) {
        // to mark the key as most recent, we need to put it to cur - 1 pos
        // We start looking for key pos from cur pos (end of queue)
        // and rotate values between prev key pos and cur - 1 to left.
        int n = cache.length;
        for (int i = 0; i < n; i++) {
            int ind = (i + cur + n) % n; // starting from the end of queue
            if (cache[ind] != null && cache[ind] == key) {
                int j = ind;
                while (j != (cur - 1 + n) % n) {
                    cache[j] = cache[(j + 1) % n];
                    j = (j + 1) % n;
                } 
                cache[(cur - 1 + n) % n] = key;
                break;
            }
        }
        printCache();
    }
    
    void printCache() {
        // for (int i = 0; i < cache.length; i++) {
        //     System.out.print(cache[i] + ",");
        // }
        // System.out.println();
    }
}

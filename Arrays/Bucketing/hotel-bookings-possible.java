/*
Hotel Bookings Possible

A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. 
Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms
in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:

First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.

Example :
Input : 
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False / 0 

At day = 5, there are 2 guests in the hotel. But I have only one room. 

https://www.interviewbit.com/problems/hotel-bookings-possible/
*/

public class Solution {
    // class Pair {
    //     int a;
    //     int d;
    //     Pair(int a, int d) {
    //         this.a = a;
    //         this.d = d;
    //     }
    // }
    
    boolean ARRIVE = false;
    boolean DEPART = true;
    
    class Event {
        int time;
        boolean type;
        Event(int time, boolean type) {
            this.time = time;
            this.type = type;
        }
    }
    
    public boolean hotel(
        ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
            
        int n = arrive.size();
        if (n == 0) {
            return false;
        }
        if (K == 0) {
            return false;
        }
        // Gives TLE
        // ArrayList<Pair> pairs = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     if (arrive.get(i).equals(depart.get(i))) {
        //         continue;
        //     }
        //     pairs.add(new Pair(arrive.get(i), depart.get(i)));
        // }
        // Collections.sort(pairs, (p1, p2) -> Integer.compare(p1.d, p2.d));
        // n = pairs.size();
        // for (int i = 0; i < n; i++) {
        //     Pair p = pairs.get(i);
        //     print(p.a + "," + p.d);
        // }
        // println("");
        // for (int i = 0; i < n; i++) {
        //     Pair p = pairs.get(i);
        //     int d = p.d;
        //     int res = 1;
        //     for (int j = i + 1; j < n; j++) {
        //         Pair p2 = pairs.get(j);
        //         int a2 = p2.a;
        //         if (a2 < d) { // crossing
        //             res++;
        //         }
        //     }
        //     if (res > K) {
        //         print(i + ":" + res + ":" + p.a + "," + p.d);
        //         return false;
        //     }
        // }
        // return true;
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arrive.get(i).equals(depart.get(i))) {
                continue;
            }
            events.add(new Event(arrive.get(i), ARRIVE));
            events.add(new Event(depart.get(i), DEPART));
        }
        Collections.sort(events, (e1, e2) -> {
            int res = Integer.compare(e1.time, e2.time);
            if (res == 0) {
                res = Boolean.compare(e1.type, e2.type);
            }
            return res;
        });
        // Skip cases when someone arrive and departs simultaneously
        for (int i = 1; i < events.size(); i++) {
            Event prev = events.get(i - 1);
            Event next = events.get(i);
            if (prev.time == next.time && prev.type != next.type) {
                events.remove(prev);
                events.remove(next);
                i--;
            }  
        }
        int m = events.size();
        int res = 0;
        for (int i = 0; i < m; i++) {
            Event e = events.get(i);
            if (e.type == ARRIVE) {
                res++;
            } else if (e.type == DEPART) {
                res--;
            }
            if (res > K) {
                return false;
            }
        }
        return true;
    }
    void print(String s) {
        //System.out.print(s + " ");
    }
    
    void println(String s) {
        //System.out.println(s + " ");
    }
}

/*
Random Attendance

Dr. Dhruv is a superb professor of Mathematics. He is so lenient that he doesn’t even take attendance. But his students are not so cooperative. 
Frustrating of all aspects is that students have stopped attending classes of Dr. Dhruv. Dr. Dhruv is really disappointed and he has decided to start taking attendance. There are A students in his class. Ordinary professors take a roll call as [1, 2, 3, …, A] but Dr. Dhruv is no ordinary man. He has come up with a different method of taking roll call. His method is as follows:

He has a list B of K random integers which means that he will call out only K students. He will first treat the numbers [1, 2, 3, .., A] as strings 
[“1”, “2”, “3”, .., “A”]. Then he will sort this vector of strings in lexicographic order (see example below). Now, Dr. Dhruv will call the numbers 
which are at B[i]-th (0 <= i < K) position in the sorted order (see example below).

Simply putting, if the sorted order is S, then he will call students in the order { S[B[0] - 1], S[B[1] - 1], …, S[B[K-1] - 1] }. You need to output the numbers in the sequence that Dr. Dhruv will call.

Note: Dr. Dhruv needs this task to finish quickly and hence expected time complexity O(K*log(A))

Constraints:

1 <= K <= 1000  and K <= A
1 <= B[i] <= A (Elements of B may not be distinct, i.e, he can call a student multiple times)
1 <= A <= 10^9   (Yes, Dr. Dhruv can teach 10^9 students at a time)
Example:

Input:
A = 12, B = [2, 5]

Output:
ans = [10, 2]

Sorted list S: ["1", "10", "11", "12", "2", "3", "4", "5", ...., "9"]
ans = [2nd number, 5th number] = [10, 2]

https://www.interviewbit.com/problems/random-attendance/
*/

public class Solution {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        
    }
    
    // Produces OOM
    // public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
    //     ArrayList<Integer> a = new ArrayList<>();
    //     for (int i = 1; i <= A; i++) {
    //         a.add(i);
    //     }
    //     Collections.sort(a, (l, r) -> {
    //         String ls = String.valueOf(l);
    //         String rs = String.valueOf(r);
    //         return ls.compareTo(rs);
    //     });
    //     // for (int i: a) {
    //     //     System.out.print(i + " ");
    //     // }
    //     // System.out.println();
        
    //     ArrayList<Integer> result = new ArrayList<>();
    //     for (int b: B) {
    //         result.add(a.get(b - 1));
    //     }
    //     return result;
    // }
}

package in.ineuron.assignment17;

import java.util.ArrayDeque;
import java.util.Queue;

class Win {
    public int findTheWinner(int n, int k) {
        Queue<Integer> friends = new ArrayDeque<>();

        // Initialize the queue with friend numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            friends.offer(i);
        }

        while (friends.size() > 1) {
            // Perform the counting step
            for (int i = 1; i < k; i++) {
                friends.offer(friends.poll());
            }

            // Remove the last friend counted
            friends.poll();
        }

        // Return the winner
        return friends.poll();
    }
}

public class FindWinnerQ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
        int k = 2;

        Win solution = new Win();
        int winner = solution.findTheWinner(n, k);

        System.out.println("Winner: " + winner);

	}

}

package in.ineuron.assignment17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution6 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        int[] revealed = new int[n];
        Queue<Integer> revealedIndices = new LinkedList<>();
        Queue<Integer> unrevealedIndices = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            unrevealedIndices.add(i);
        }

        int index = 0;
        while (!unrevealedIndices.isEmpty()) {
            revealedIndices.add(unrevealedIndices.poll());
            revealed[revealedIndices.peek()] = deck[index++];
            unrevealedIndices.add(revealedIndices.poll());
        }

        return revealed;
    }
}

public class CardInIncreasingOrderQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] deck = {17, 13, 11, 2, 3, 5, 7};

        Solution6 solution = new Solution6();
        int[] revealed = solution.deckRevealedIncreasing(deck);

        System.out.println("Ordering of revealed cards: " + Arrays.toString(revealed));

	}

}

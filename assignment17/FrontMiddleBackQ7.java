package in.ineuron.assignment17;

import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    private Deque<Integer> frontDeque;
    private Deque<Integer> backDeque;

    public FrontMiddleBackQueue() {
        frontDeque = new ArrayDeque<>();
        backDeque = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        frontDeque.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (frontDeque.size() > backDeque.size()) {
            backDeque.offerFirst(frontDeque.pollLast());
        }
        frontDeque.offerLast(val);
    }

    public void pushBack(int val) {
        backDeque.offerLast(val);
        balance();
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        if (frontDeque.isEmpty()) {
            return backDeque.pollFirst();
        }
        return frontDeque.pollFirst();
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }
        if (frontDeque.size() == backDeque.size()) {
            return frontDeque.pollLast();
        }
        return backDeque.pollFirst();
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        if (backDeque.isEmpty()) {
            return frontDeque.pollLast();
        }
        return backDeque.pollLast();
    }

    private void balance() {
        if (frontDeque.size() > backDeque.size() + 1) {
            backDeque.offerFirst(frontDeque.pollLast());
        } else if (backDeque.size() > frontDeque.size()) {
            frontDeque.offerLast(backDeque.pollFirst());
        }
    }

    private boolean isEmpty() {
        return frontDeque.isEmpty() && backDeque.isEmpty();
    }
}

public class FrontMiddleBackQ7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrontMiddleBackQueue queue = new FrontMiddleBackQueue();

        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushFront(4);

        System.out.println(queue.popFront()); // Output: 4
        System.out.println(queue.popMiddle()); // Output: 3
        System.out.println(queue.popMiddle()); // Output: 1
        System.out.println(queue.popBack()); // Output: 2

	}

}

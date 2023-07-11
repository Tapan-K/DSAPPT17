package in.ineuron.assignment17;
import java.util.*;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);

        // Remove timestamps older than t - 3000
        while (requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }
}


public class RecentCounterQ4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecentCounter recentCounter = new RecentCounter();

        int count1 = recentCounter.ping(100);
        System.out.println("Number of recent requests: " + count1);

        int count2 = recentCounter.ping(300);
        System.out.println("Number of recent requests: " + count2);

        int count3 = recentCounter.ping(900);
        System.out.println("Number of recent requests: " + count3);

        int count4 = recentCounter.ping(1500);
        System.out.println("Number of recent requests: " + count4);

        int count5 = recentCounter.ping(3000);
        System.out.println("Number of recent requests: " + count5);

	}

}

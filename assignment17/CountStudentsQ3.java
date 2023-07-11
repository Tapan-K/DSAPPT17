package in.ineuron.assignment17;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Solution3 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();

        for (int student : students) {
            queue.add(student);
        }

        for (int sandwich : sandwiches) {
            stack.push(sandwich);
        }

        int unableToEat = 0;

        while (!queue.isEmpty()) {
            if (queue.peek() == stack.peek()) {
                queue.poll();
                stack.pop();
                unableToEat = 0; // Reset the count for consecutive unable to eat students
            } else {
                int student = queue.poll();
                queue.add(student);
                unableToEat++;

                // Check if all students in the queue are unable to eat
                if (unableToEat == queue.size()) {
                    break;
                }
            }
        }

        return queue.size();
    }
}

public class CountStudentsQ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};

        Solution3 solution = new Solution3();
        int unableToEat = solution.countStudents(students, sandwiches);

        System.out.println("Number of students unable to eat: " + unableToEat);

	}

}

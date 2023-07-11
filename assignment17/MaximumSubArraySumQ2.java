package in.ineuron.assignment17;
class Solution2 {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currMax = 0;
        int currMin = 0;

        // Case 1: Maximum sum subarray is within array bounds
        for (int num : nums) {
            totalSum += num;
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
        }

        // Case 2: Maximum sum subarray wraps around the circular array
        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }

        return maxSum;
    }
}

public class MaximumSubArraySumQ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, -2, 3, -2};

        Solution2 solution = new Solution2();
        int maxSum = solution.maxSubarraySumCircular(nums);

        System.out.println("Maximum Sum: " + maxSum);

	}

}

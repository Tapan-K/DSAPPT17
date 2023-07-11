package in.ineuron.assignment17;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        // Create a hashmap to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // No non-repeating character found
        return -1;
    }
}

public class FirstUniqueCharacterQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";

        Solution solution = new Solution();
        int index = solution.firstUniqChar(s);

        System.out.println("Output: " + index);

	}

}

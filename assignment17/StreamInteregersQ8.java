package in.ineuron.assignment17;

class DataStream {
    private int[] buffer;
    private int value;
    private int k;
    private int currentIndex;

    public DataStream(int value, int k) {
        this.buffer = new int[k];
        this.value = value;
        this.k = k;
        this.currentIndex = 0;
    }

    public boolean consec(int num) {
        buffer[currentIndex] = num;
        currentIndex = (currentIndex + 1) % k;
        
        if (currentIndex == 0) {
            for (int i = 0; i < k; i++) {
                if (buffer[i] != value) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
}

public class StreamInteregersQ8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStream stream = new DataStream(5, 3);

        System.out.println(stream.consec(1)); // Output: false
        System.out.println(stream.consec(5)); // Output: false
        System.out.println(stream.consec(5)); // Output: true
        System.out.println(stream.consec(5)); // Output: true
        System.out.println(stream.consec(1)); // Output: false

	}

}

import java.io.File;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;

// element finder class
public class ElementFinder {
	
	public static int Kth_finder(String filename, int K, String operation) {
		
		// compare integers
		Comparator<Integer> comparator = null;
		if(operation.equals("largest")) {
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
			};
		}
		else {
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			};
		}
		// catch for any error or exception in the heap
		Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(" ");
                for(String number : data) {
                	int intNumber = Integer.parseInt(number);
                	heap.add(intNumber, intNumber);
                }
            }
            sc.close(); 	
        } catch (FileNotFoundException e) {
			
			// print the error if it exists
            System.out.println(e);
        }
		if(K > heap.size()) {
			return -1;
		}
		int kth = K;

		while(kth > 1) {
			heap.poll();
			kth--;	
		}
		return heap.peek().getKey();
	}
}
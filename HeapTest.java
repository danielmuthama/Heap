import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Comparator;

// test class
public class HeapTest {
	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		assertEquals(8, heap.entries.size());
	}

	@Test
	public void testElementFinder() {
		assertEquals(13, ElementFinder.Kth_finder("cse12pa8\\src\\input.txt", 4, "largest"));
		//assertEquals(13, ElementFinder.Kth_finder("cse12pa8\\src\\test.txt", 4, "largest"));
	}
	
	@Test
	public void testRemoveMin() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		heap.poll();
		heap.poll();
		heap.poll();
		assertEquals(new Entry<Integer, String>(15, "10"), heap.poll());
	}
	
	@Test
	public void testRemoveMax() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		heap.poll();
		heap.poll();
		heap.poll();
		assertEquals(new Entry<Integer, String>(19, ""), heap.poll());
	}


}
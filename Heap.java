import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

// Heap class
public class Heap<K extends Comparable<? super K>, V> implements PriorityQueue<K, V> {
	
	public List<Entry<K, V>> entries;
	public Comparator<K> comparator;
	public Heap(Comparator<K> comparator) {
		this.comparator = comparator;
		entries = new ArrayList<Entry<K, V>>();
		
	}
	
	@Override
	public void add(K k, V v) {
		Entry<K, V> entry = new Entry<K, V>(k, v);
		entries.add(entry);
		bubbleUp(entries.size()-1);
		
	}
	
	@Override
	public Entry<K, V> poll() throws NoSuchElementException{
		if(isEmpty()) {
			throw new NoSuchElementException("Empty Heap");
		}
		Entry<K, V> root = entries.get(0);
		entries.set(0, entries.get(entries.size()-1));
		entries.remove(entries.size()-1);
		bubbleDown(0);
		return root;
	}
	
	@Override
	public Entry<K, V> peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Empty Heap");
		}
		return entries.get(0);
	}
	
	@Override
	public List<Entry<K, V>> toArray() {
		return entries;
	}
	
	@Override
	public boolean isEmpty() {
		return this.entries.size() == 0;
	}
	
	public void bubbleUp(int index) {
		if(index < this.entries.size() && index >= 0) {
			
			Entry<K,V> e = this.entries.get(index);
			Entry<K,V> parent = this.entries.get(parent(index));
			int comp = this.comparator.compare(e.key, parent.key);
			if(comp > 0) {
				swap(index, parent(index));
				bubbleUp(parent(index));
			}
		}
	
	}
	
	public void bubbleDown(int index) {
		if(index < this.entries.size() && index >= 0) { 
			int leftIndex = left(index);
			if(leftIndex < this.entries.size()) { 
				int largerChildIndex = leftIndex;
				int rightIndex = right(index);
				if(existsAndGreater(rightIndex, leftIndex)) {
					largerChildIndex = rightIndex;
				}
				if(existsAndGreater(largerChildIndex, index)) {
					swap(index, largerChildIndex);
					bubbleDown(largerChildIndex);
				}
			}
		}
	}
// 	parent heap
	public int parent(int index) {
		return (index-1)/2;
	}
// left heap child	
	public int left(int index) {
		return (2*index)+1;
	}
// right heap child
	public int right(int index) {
		return (2*index)+2;
	}
// swap the nodes	
	public void swap(int i1, int i2) {
		Entry<K, V>  tempEntry = entries.get(i1);
		entries.set(i1,  entries.get(i2));
		entries.set(i2, tempEntry);
	}
// parse through the nodes
	public boolean existsAndGreater(int firstNodeIndex, int secondNodeIndex) {
		if(firstNodeIndex >= entries.size() || secondNodeIndex >= entries.size()) {
			return false;
		}
		if(firstNodeIndex < entries.size() || secondNodeIndex < entries.size()) {
			if(this.comparator.compare(entries.get(firstNodeIndex).getKey(), entries.get(secondNodeIndex).getKey()) > 0) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return entries.size();
	}
	public String toString() {
		String entriesString = "";
		for(Entry<K, V> entry : entries) {
			entriesString +=  entry.toString() + "\n";
		}
		return entriesString;
	}
	
}
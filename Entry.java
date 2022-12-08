// entry class
public class Entry<K, V> {
	K key; 
	V value;
	public Entry(K k, V v) {
		this.key = k;
		this.value = v;
	}
	public String toString() {
		return key + ": " + value;
	}
	public K getKey() {
		return key;
	}
}
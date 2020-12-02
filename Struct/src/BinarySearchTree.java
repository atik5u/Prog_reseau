
public interface BinarySearchTree<K extends Comparable<K>, T> {

	/*
	 * Question 2
	 */
	public void add(K clef,T element);
	
	/*
	 * Question 3
	 */
	public boolean is_in(K clef);
	
	/*
	 * Question 5
	 */
	public  T get(K clef);
	
	/*
	 * Question 6
	 */
	public String toString();

	
	
	
}

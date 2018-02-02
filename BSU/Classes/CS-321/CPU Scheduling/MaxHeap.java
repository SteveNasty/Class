import java.util.Arrays;
public class MaxHeap <T extends Comparable<T>>{
	private final int DEFAULT_CAPACITY = 10;
	private int size;
	private T[] maxHeap;
	private int rear;
	
	public void MaxHeap() {
		maxHeap = (T[])(new Object[DEFAULT_CAPACITY]);
		this.size = 0;
		this.rear = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(T target) {
		expandIfNecessary();
		maxHeap[rear] = target;
		size++;
		rear++;		
	}
	
	public void heapifyUp(int target) {
		while(target != 0 && maxHeap[parent(target)].compareTo(maxHeap[target])<0) {
			swap(parent(target), target);
			target = parent(target);
		}
	}
	
	public void swap(int swap1, int swap2) {
		expandIfNecessary();
		maxHeap[rear] = maxHeap[swap1];
		maxHeap[swap1] = maxHeap[swap2];
		maxHeap[swap2] = maxHeap[rear]; 
		maxHeap[rear] = null;				
	}
	
	public int parent(int index) {
		int location = ((index -1)/2);
		return location;
	}
	
	public int leftChild(int index) {
		int location = ((index*2)+1);
		return location;
	}
	
	public int rightChild(int index) {
		int location = ((index*2)+2);
		return location;
	}
	
	
	
	private void expandIfNecessary() {
//		int i = 0;
//		while(i < maxHeap.length && maxHeap[i] != null) {
//			i++;
//		}
//		if(maxHeap[i] != null) {
		if(maxHeap.length == size)
			maxHeap = Arrays.copyOf(maxHeap, 2*maxHeap.length);
//		}
	}
}

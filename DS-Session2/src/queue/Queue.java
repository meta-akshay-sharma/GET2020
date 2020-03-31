package queue;

/**
 * 
 * @author Akshay
 * Class Queue To implement the Simple queue.
 */
public class Queue {
private int queue[], front, rear, size;
	
	Queue(int arraySize) {
	    queue = new int[arraySize];
	}

	
	/**
	 * isFull function checks whether the queue is full or not.
	 * @return
	 */
	private boolean isFull() {
		if (size == queue.length)
			return true;
		return false;
	}
	
	
	/**
	 * enqueue function adds new element to the Queue.
	 * @param data
	 */
	public void enqueue(int data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			size++;
			front = front%(queue.length);
			queue[front++] = data;
			System.out.println("enqueue "+data);
		}
	}

	
	/**
	 * dequeue function deletes an element from queue as FIFO(first in first out).
	 * @return
	 */
	public String dequeue() {
		if (isEmpty()){
			return "queue is empty";
		}
		else{
			size--;
			return "Dequeue "+queue[rear++];
		}
	}
	
	
	/**
	 * isEmpty function checks whether the queue is empty or not. 
	 * @return
	 */
	private boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * display function to display the elements of the Queue. 
	 */
	public void display() {
		if (front <= rear){
			for (int index=rear; index<queue.length; index++)
				System.out.print(queue[index]+"->");
			for (int index=0; index!=front; index++)
				System.out.print(queue[index]+"->");
		}
		else
			for (int indexi=rear; indexi<front; indexi++)
				System.out.print(queue[indexi]+"->");
	}

}

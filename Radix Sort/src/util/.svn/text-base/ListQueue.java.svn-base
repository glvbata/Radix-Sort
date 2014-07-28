
package util;

// ListQueue class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void enqueue( x ) --> Insert x
// AnyType getFront( ) --> Return least recently inserted item
// AnyType dequeue( ) --> Return and remove least recent item
// boolean isEmpty( ) --> Return true if empty; else false
// void makeEmpty( ) --> Remove all items
// ******************ERRORS********************************
// getFront or dequeue on empty queue

/**
 * List-based implementation of the queue.
 * 
 * @author Mark Allen Weiss
 */
public class ListQueue<AnyType> implements Queue<AnyType> {

  // O(1)
  /**
   * Construct the queue.
   */
  public ListQueue() {
    front = back = null;
  }

  // O(1)
  /**
   * Test if the queue is logically empty.
   * 
   * @return true if empty, false otherwise.
   */
  public boolean isEmpty() {
    return front == null;
  }

  // O(1)
  /**
   * Insert a new item into the queue.
   * 
   * @param x the item to insert.
   */
  public void enqueue(final AnyType x) {
    if (isEmpty()) {
      back = front = new ListNode<AnyType>(x);
    } else {
      // Regular case
      back = back.next = new ListNode<AnyType>(x);
    }
  }

  // O(1)
  /**
   * Return and remove the least recently inserted item from the queue.
   * 
   * @return the least recently inserted item in the queue.
   * @throws UnderflowException if the queue is empty.
   */
  public AnyType dequeue() {
    if (isEmpty()) {
      throw new UnderflowException("ListQueue dequeue");
    }

    final AnyType returnValue = front.element;
    front = front.next;
    return returnValue;
  }

  // O(1)
  /**
   * Get the least recently inserted item in the queue. Does not alter the
   * queue.
   * 
   * @return the least recently inserted item in the queue.
   * @throws UnderflowException if the queue is empty.
   */
  public AnyType getFront() {
    if (isEmpty()) {
      throw new UnderflowException("ListQueue getFront");
    }
    return front.element;
  }

  // O(1)
  /**
   * Make the queue logically empty.
   */
  public void makeEmpty() {
    front = null;
    back = null;
  }

  // O(N)
  /**
   * The string representation of the queue.
   * 
   * @return the string representation of the queue.
   */
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    if (isEmpty()) {
      sb.append("");
    } else {
      ListNode<AnyType> current = front;
      front = current.next;

      sb.append(current.element);
      sb.append(" <--- Front");
      sb.append("\n");

      while (front != null) {
        current = front;
        front = current.next;
        sb.append(current.element);
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * The front.
   */
  protected ListNode<AnyType> front;

  /**
   * The back.
   */
  protected ListNode<AnyType> back;
}

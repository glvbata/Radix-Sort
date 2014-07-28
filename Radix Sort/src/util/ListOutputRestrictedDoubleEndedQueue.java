
package util;

/**
 * A queue that has the ability to add in front of the queue.
 * 
 * @author Gian Lendl V. Bata
 * @version v1.0
 * @param <E> A generic type.
 */
public class ListOutputRestrictedDoubleEndedQueue<E> extends ListQueue<E> implements
    OutputRestrictedDoubleEndedQueue<E> {

  // O(1)
  @Override
  public void enqueueAtFront(final E the_element) {
    if (isEmpty()) {
      front = new ListNode<E>(the_element);
      back = front;

    } else {
      final ListNode<E> temp = front;
      front = new ListNode<E>(the_element);
      front.next = temp;
    }
  }
}

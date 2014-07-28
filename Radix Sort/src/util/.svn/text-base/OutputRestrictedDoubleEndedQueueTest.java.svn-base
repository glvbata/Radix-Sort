/*
 * Gian Lendl V. Bata
 * 
 * TCSS 342 – Winter 2013 Assignment 2
 */

package util;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * The test class for the OutputRestrictedDoubleEndedQueue interface.
 * 
 * @author Gian Lendl V. Bata
 * @version v1.0
 */
public class OutputRestrictedDoubleEndedQueueTest {

  /**
   * My queue.
   */
  private ListOutputRestrictedDoubleEndedQueue<Integer> my_queue;

  /**
   * Initializes the test fixture before each test method is run.
   * 
   * @throws Exception
   */
  @Before
  public void setUp() {
    my_queue = new ListOutputRestrictedDoubleEndedQueue<Integer>();
  }

  /**
   * Test method for
   * {@link ListOutputRestrictedDoubleEndedQueue#enqueueAtFront()}.
   */
  @Test
  public void testEnqueueAtFront() {
    addElements(2); // add the element 0 and 1.

    assertTrue("The queue front element should be = 0.", 0 == my_queue.getFront());
    assertTrue("The queue back element should be = 1.", 1 == my_queue.back.element);

    my_queue.enqueueAtFront(2); // adds the element 2 in front.

    assertTrue("The queue front element should be = 2.", 2 == my_queue.getFront());
    assertTrue("The queue front.next element should be = 0", 0 == my_queue.front.next.element);
    assertTrue("The queue fback element should be = 1.", 1 == my_queue.back.element);

  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#enqueue()}.
   */
  @Test
  public void testEnqueue() {
    addElements(3);
    assertTrue("The queue front element should be = 0.", 0 == my_queue.getFront());
    assertTrue("The queue front.next element should be = 1", 1 == my_queue.front.next.element);
    assertTrue("The queue back element should be = 2.", 2 == my_queue.back.element);
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#dequeue()}.
   */
  @Test
  public void testDequeue() {
    addElements(3);
    assertTrue("The queue front element should be = 0.", 0 == my_queue.getFront());
    assertTrue("The queue front.next element should be = 1", 1 == my_queue.front.next.element);
    assertTrue("The queue back element should be = 2.", 2 == my_queue.back.element);

    my_queue.dequeue();

    assertTrue("The queue front element should be = 1.", 1 == my_queue.getFront());
    assertTrue("The queue back element should be = 2.", 2 == my_queue.back.element);
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    addElements(3);
    assertTrue("The queue front element should be null.", null != my_queue.front &&
                                                          null != my_queue.back);

    my_queue.makeEmpty();
    assertTrue("The queue front element should be null.", null == my_queue.front &&
                                                          null == my_queue.back);
  }

  /**
   * Test method for
   * {@link ListOutputRestrictedDoubleEndedQueue#enqueueAtFront()}.
   */
  @Test
  public void testEmptyEnqueueAtFront() {
    my_queue.enqueueAtFront(1);
    assertTrue("The queue front element should be = 1.", 1 == my_queue.front.element);
    assertTrue("The queue back element should be = 1.", 1 == my_queue.back.element);
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#dequeue()}.
   */
  @Test(expected = UnderflowException.class)
  public void testEmptyDequeue() {
    my_queue.dequeue();
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#getFront()}.
   */
  @Test(expected = UnderflowException.class)
  public void testEmptyGetFront() {
    my_queue.getFront();
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#toString()}.
   */
  @Test
  public void testToString() {
    final String output = "100 <--- Front\n1\n2\n5\n";

    addElements(3);
    my_queue.dequeue();
    my_queue.enqueue(5);
    my_queue.enqueueAtFront(100);

    // 100 1 2 5
    assertTrue("The string representation of the queue should be ",
               output.equals(my_queue.toString()));
  }

  /**
   * Test method for {@link ListOutputRestrictedDoubleEndedQueue#toString()}.
   */
  @Test
  public void testEmptyQueueToString() {
    assertTrue("The string representation of an empty queue should be nothing",
               "".equals(my_queue.toString()));
  }

  /**
   * Adds the specified number of Integers to my_qeueue.
   * 
   * @param the_elements the number of elements to be added to the queue.
   */
  public void addElements(final int the_elements) {
    for (int i = 0; i < the_elements; i++) {
      my_queue.enqueue(i);
    }
  }
}

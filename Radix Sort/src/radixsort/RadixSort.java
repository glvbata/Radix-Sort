/*
 * Gian Lendl V. Bata
 * 
 * TCSS 342 – Winter 2013 Assignment 2
 */

package radixsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.ListOutputRestrictedDoubleEndedQueue;
import util.Queue;

/**
 * The radix sort class where it reads a txt file that has unsorted integers.
 * These integers are now going to be sorted within this class. This class opens
 * the file first, reads the integers, sorts it then closes the file.
 * 
 * @author Gian Lendl V. Bata
 * @version v1.0
 */
public class RadixSort {

  /**
   * The number of digits // 0 - 9.
   */
  private static final int DIGITS = 10;

  /**
   * My scanner.
   */
  private Scanner my_scanner;

  /**
   * My list of queue integers.
   */
  private List<ListOutputRestrictedDoubleEndedQueue<Integer>> my_buckets;

  /**
   * My main queue.
   */
  private ListOutputRestrictedDoubleEndedQueue<Integer> my_queue;

  /**
   * Opens a file that contains a queue that needs to be sorted.
   */
  public void openFile() {
    try {
      my_scanner = new Scanner(new File("src/in.txt"));
    } catch (final FileNotFoundException e) {
      System.out.println("Could not find file.");
    }
  }

  /**
   * The method the reads the file and returns a queue of integers.
   * 
   * @return Queue of integers
   */
  public Queue<Integer> readFile() {
    final ListOutputRestrictedDoubleEndedQueue<Integer> queue =
        new ListOutputRestrictedDoubleEndedQueue<Integer>();

    while (my_scanner.hasNext()) {
      final int element = my_scanner.nextInt();
      queue.enqueue(element);
    }

    return queue;
  }

  /**
   * Sorts the unsorted queue and returns it.
   * 
   * @return the sorted queue
   */
  public Queue<Integer> sortedQueue() {
    my_queue = (ListOutputRestrictedDoubleEndedQueue<Integer>) readFile();
    my_buckets = new ArrayList<>();
    int current_element;
    int digit;

    for (int i = 0; i < DIGITS; i++) {
      my_buckets.add(new ListOutputRestrictedDoubleEndedQueue<Integer>());
    }

    while (!my_queue.isEmpty()) {
      current_element = my_queue.getFront();
      digit = current_element % DIGITS;

      my_buckets.get(digit).enqueue(current_element);
      my_queue.dequeue();
    }

    extract();

    while (!my_queue.isEmpty()) {
      current_element = my_queue.getFront();
      digit = (current_element % 100) / DIGITS;

      my_buckets.get(digit).enqueue(current_element);
      my_queue.dequeue();
    }

    extract();

    while (!my_queue.isEmpty()) {
      current_element = my_queue.getFront();
      digit = (current_element % 1000) / 100;

      my_buckets.get(digit).enqueue(current_element);
      my_queue.dequeue();
    }

    extract();

    while (!my_queue.isEmpty()) {
      current_element = my_queue.getFront();
      digit = (current_element % 10000) / 1000;

      my_buckets.get(digit).enqueue(current_element);
      my_queue.dequeue();
    }

    extract();
    return my_queue;
  }

  /**
   * A method that extracts the integers inside the list of queues into the main
   * queue.
   */
  public void extract() {
    for (int i = 0; i < DIGITS; i++) {
      while (!my_buckets.get(i).isEmpty()) {
        my_queue.enqueue(my_buckets.get(i).getFront());
        my_buckets.get(i).dequeue();
      }
    }
  }

  /**
   * Closes the read file.
   */
  public void closeFile() {
    my_scanner.close();
  }
}

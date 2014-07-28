/*
 * Gian Lendl V. Bata
 * 
 * TCSS 342 – Winter 2013 Assignment 2
 */

package radixsort;

import java.io.IOException;
import java.util.Formatter;

import util.Queue;

/**
 * A class that creates a txt file that contains a sorted queue.
 * 
 * @author Gian Lendl V. Bata
 * @version v1.0
 */
public class CreateFile {

  /**
   * My formatter.
   */
  private Formatter my_formatter;

  /**
   * Opens an output file to write on.
   */
  public void openFile() {
    try {
      my_formatter = new Formatter("src/out.txt");
    } catch (final IOException e) {
      System.out.println("Could not write file.");
    }
  }

  /**
   * Writes the data on the opened file.
   */
  public void writeData() {
    final RadixSort radix_sort = new RadixSort();
    radix_sort.openFile();
    final Queue<Integer> queue = radix_sort.sortedQueue();
    my_formatter.format("%s", queue);
    radix_sort.closeFile();
  }

  /**
   * Closes the opened file.
   */
  public void closeFile() {
    my_formatter.close();
  }
}

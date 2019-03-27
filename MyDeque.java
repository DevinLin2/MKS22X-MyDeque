import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    // data.addFirst("hi");
    // data.addFirst("there");
    // data.addFirst("bob");
    // data.addFirst("my");
    // data.addFirst("name");
    // data.addFirst("is");
    // data.addFirst("steve");
    // data.addFirst("whats");
    // data.addFirst("up");
    // data.addFirst("sack");
    // //data.removeFirst();
    // data.addFirst("bobby");
    // System.out.println(data.getLast());
    // System.out.println(data.getFirst());
    // System.out.println(data.size());
    // data.debug();
    // System.out.println(data.start);
    // System.out.println(data.end);
    // System.out.println(data);
  }

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = -1;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = -1;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String ans = "{";
    for (int i = start; i <= end; i++) {
      if (i < 0) {
        ans += data[i + data.length]; // this allows for the negative index to be converted into the correct positive index
      } else {
        ans += data[i];
      }
      if (start < end) {
        ans += " ";
      }
    }
    ans += "}";
    return ans;
  }

  private void debug() {
    String ans = "";
    int index = 0;
    for (int i = 0; i < size; i++) {
      ans += data[index] + " ";
      index++;
    }
    System.out.println(ans);
  }

  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("Enter a new valid element");
    }
  }
  // public void addLast(E element) {
  //   if (element == null) {
  //     throw new NullPointerException("Enter a new valid element");
  //   }
  // }
  // public E removeFirst() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("The list is empty");
  //   }
  // }
  // public E removeLast() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("The list is empty");
  //   }
  // }
  // public E getFirst() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("The list is empty");
  //   }
  // }
  // public E getLast() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("The list is empty");
  //   }
  // }
  //
  // @SuppressWarnings("unchecked")
  // private void resize() {
  // }
}

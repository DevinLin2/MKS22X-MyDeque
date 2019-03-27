import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    data.addLast("hi");
    data.addLast("there");
    data.addLast("bob");
    data.addLast("my");
    data.addLast("name");
    data.addLast("is");
    data.addLast("steve");
    data.addLast("whats");
    data.addLast("up");
    data.addLast("sack");
    //data.removeFirst();
    data.addLast("bobby");
    System.out.println(data.getLast());
    System.out.println(data.getFirst());
    System.out.println(data.size());
    data.debug();
    System.out.println(data.start);
    System.out.println(data.end);
    System.out.println(data);
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
    if (start - 1 < 0) {
      if (start * -1 == data.length - 1 || size == data.length) {
        resize(); // dont need to redefine start and end as that will be taken care of using "+ data.length"
      }
      size++;
      start--;
      data[data.length + start] = element;
    } else {
      // this means that start is not negative
      start--;
      data[start] = element;
      size++;
    }
  }
  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("Enter a new valid element");
    }
    if (end == data.length - 1 || size == data.length) {
      resize();
    }
    size++;
    end++;
    if (end < 0) {
      data[end + data.length] = element; // this takes care of the cases where end is in front of start
    } else {
      data[end] = element; // the regular case
    }
  }
  public E removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException("The list is empty");
    }
    start++;
    E toRemove = data[data.length + start];
    data[data.length + start] = null;
    size--;
    return toRemove;
  }
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
  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[]) new Object[data.length * 2 + 1];
    for (int i = start; i <= end; i++) {
      if (i < 0) {
        newData[i + newData.length] = data[i + data.length];
      } else {
        newData[i] = data[i];
      }
    }
    data = newData;
  }
}

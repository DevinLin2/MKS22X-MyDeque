public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    data.addLast("hi");
    data.addLast("there");
    data.addLast("bob");
    data.removeLast();
    System.out.println(data);
  }

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String ans = "{";
    int addedIndex = 0;
    int s = start;
    while (addedIndex != size && s != end) {
      if (s >= data.length) {
        s = 0;
      }
      ans += data[s] + " ";
      addedIndex++;
      s++;
    }
    ans += "}";
    return ans;
  }
  // public void addFirst(E element) {
  //
  // }
  public void addLast(E element) {
    size++;
    data[end] = element;
    end++;
    // have to make this a loop
  }
  public E removeFirst() {
    E removed = data[start];
    data[start] = null;
    start++;
    size--;
    if (start >= data.length) {
      start = 0;
    }
    return removed;
  }
  public E removeLast() {
    E removed = data[end];
    data[end] = null;
    end--;
    size--;
    if (end < 0) {
      end = data.length - 1;
    }
    return removed;
  }
  public E getFirst() {
    return data[start];
  }
  public E getLast() {
    return data[end];
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[]) new Object[size * 2];
    int addedIndex = 0;
    int s = start;
    while (addedIndex != size && s != end) {
      if (s >= data.length) {
        s = 0;
      }
      newData[addedIndex] = data[s];
      addedIndex++;
      s++;
    }
    data = newData;
  }
}

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    data.addLast("hi");
    data.addLast("there");
    data.addLast("bob");
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
  // public E removeFirst() {
  //
  // }
  // public E removeLast() {
  //
  // }
  public E getFirst() {
    return data[start];
  }
  public E getLast() {
    return data[end];
  }
}

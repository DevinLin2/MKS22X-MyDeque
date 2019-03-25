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
    data.addLast("bobby");
    data.addLast("this");
    data.addLast("fantastic");
    System.out.println(data.getLast());
    System.out.println(data.getFirst());
    System.out.println(data.size());
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
  public void addFirst(E element) {

  }
  public void addLast(E element) {
    if (size == data.length) {
      resize();
      start = 0;
      end = size;
    }
    if (end == data.length) {
      end = 0;
      data[end] = element;
      end++;
    } else {
      size++;
      data[end] = element;
      end++;
    }
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
    return data[end - 1];
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

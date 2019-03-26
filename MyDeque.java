public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public static void main(String[] args) {
    MyDeque data = new MyDeque();
    data.addFirst("hi");
    data.addFirst("there");
    data.addFirst("bob");
    data.addFirst("my");
    data.addFirst("name");
    data.addFirst("is");
    data.addFirst("steve");
    data.addFirst("whats");
    data.addFirst("up");
    data.addFirst("bobby");
    //data.removeFirst();
    data.addFirst("bobby");
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
    if (size == data.length) {
      resize();
      start = 0;
      end = size;
    }
    if (start == 0 && size != 0) {
      start = data.length - 1;
      data[start] = element;
      size++;
    } else {
      if (size != 0) {
        start--;
      }
      data[start] = element;
      size++;
    }
  }
  public void addLast(E element) {
    if (size == data.length) {
      resize();
      start = 0;
      end = size;
    }
    if (end == data.length - 1) {
      end = 0;
      data[end] = element;
      size++;
    } else {
      if (size != 0) {
        end++;
      }
      data[end] = element;
      size++;
    }
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
    E[] newData = (E[]) new Object[size * 2 + 1];
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

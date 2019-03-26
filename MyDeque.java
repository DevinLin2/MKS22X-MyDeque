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
    data.addFirst("sack");
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
        ans += data[i+data.length];
      } else {
        ans += data[i];
      }
      if (start < end) {
        ans += " ";
      }
    }
    return ans + "}";
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

  @SuppressWarnings("unchecked")
  public void addFirst(E element) {
    if (start - 1 < 0) {
      if (start * -1 == data.length - 1 || size == data.length) {
        resize();
      }
      start--;
      data[data.length+start] = element;
      size++;
    } else {
      start--;
      data[start] = element;
      size++;
    }
  }

  @SuppressWarnings("unchecked")
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
    if (start < 0) {
      return data[start + data.length];
    }
    return data[start];
  }
  public E getLast() {
    if (end < 0){
      return data[end + data.length];
    }
    return data[end];
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[]) new Object[size * 2 + 1];
    for (int i = start; i <= end; i++) {
      if (i < 0) {
        newData[newData.length + i] = data[data.length + i];
      } else {
        newData[i] = data[i];
      }
    }
    data = newData;
  }
}

import java.util.*;

public class Calculator{
  public static void main(String[] args) {
    eval("8 2 + 99 9 - * 2 + 9 -");
  }
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s) {
    MyDeque data = new MyDeque();
    String[] values = s.split(" ");
    for (int i = 0; i < values.length; i++) {
      
    }
    return 0.0;
  }
}

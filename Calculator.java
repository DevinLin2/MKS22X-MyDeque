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
    double ans = 0.0;
    for (int i = 0; i < values.length; i++) {
      try {

      } catch(NumberFormatException e) {
        
      }
    }
    return ans;
  }
}

import java.util.*;

public class Calculator{
  public static void main(String[] args) {
    System.out.println(eval("8 2 + 99 9 % * 2 + 9 -"));
  }
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s) {
    MyDeque data = new MyDeque();
    String[] values = s.split(" ");
    for (int i = 0; i < values.length; i++) {
      try {
        double num = Double.parseDouble(values[i]);
        data.addLast(num);
      } catch(NumberFormatException e) {
        double second = (double) data.removeLast();
        double first = (double) data.removeLast();
        double partialAns = 0.0;
        if (values[i].equals("+")) {
          partialAns = first + second;
          data.addLast(partialAns);
        }
        if (values[i].equals("-")) {
          partialAns = first - second;
          data.addLast(partialAns);
        }
        if (values[i].equals("*")) {
          partialAns = first * second;
          data.addLast(partialAns);
        }
        if (values[i].equals("/")) {
          partialAns = first / second;
          data.addLast(partialAns);
        }
        if (values[i].equals("%")) {
          partialAns = first % second;
          data.addLast(partialAns);
        }
      }
    }
    return (double) data.getLast();
  }
}

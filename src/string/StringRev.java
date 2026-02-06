package string;

public class StringRev {
  public static void main(String[] args) {

    String testVal = new String("this is me");

    StringRev.printReverse(testVal.toCharArray());

  }

  private static void printReverse(char[] str) {
    helper(0, str);
  }

  private static void helper(int index, char[] str) {
    if (str == null || index >= str.length) {
      return;
    }
    helper(index + 1, str);
    System.out.print(str[index]);
  }
}

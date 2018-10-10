//Dawid Irzyk 1K311/PO

class Main {

  public static void main(String[] args) {
    System.out.println(suma(1, 13, 3));
  }

  public static int suma(int a, int b, int c) {
    if (a == 13)
      return 0;
    if (b == 13)
      return a;
    if (c == 13)
      return a + b;

    return a + b + c;
  }

}
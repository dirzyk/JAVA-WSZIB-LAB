//Dawid Irzyk 1K311/PO

class Main {

  public static void main(String[] args) {
    int a = 1, b = 13;
    if (fun2(a, b))
      System.out.println("teen");
  }

  public static boolean fun2(int a, int b) {
    return ((a >= 13 && a <= 19) && (b < 13 || b > 19)) || ((b >= 13 && b <= 19) && (a < 13 || a > 19));
  }

}
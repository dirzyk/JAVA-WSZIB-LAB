//Dawid Irzyk 1K311/PO

class Main {

  public static boolean fun1(int[] tab) {
    for (int i = 0; i < (tab.length - 2); i++) {
      if (tab[i] == 1 && tab[i + 1] == 2 && tab[i + 2] == 3)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] array = { 3, 2, 14, 1, 2, 3, 6 };
    System.out.println(fun1(array));
  }

}
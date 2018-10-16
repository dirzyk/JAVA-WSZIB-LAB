//Dawid Irzyk 1K311/PO

import java.util.Scanner;
import java.util.*;
import java.io.*;
 
class Main {
 public static void main(String[] args) throws java.lang.Exception {
 
  String imie, nazwisko, email, tmp = "y";
  String[] emails = new String[10];
  int ilosc = 0;
  int dalej = 1;
 
  while (dalej != 0) {
   Scanner odczyt = new Scanner(System.in);
 
   System.out.println("Podaj Imię");
   imie = odczyt.nextLine();
 
   System.out.println("Podaj Nazwisko");
   nazwisko = odczyt.nextLine();
 
   email = new String(nazwisko.toLowerCase() + "." + imie.toLowerCase());
 
   emails[ilosc] = new String(email+"@mex.com");
   
   int licznik = 0;
 
  for (int i = 0; i < ilosc; i++) {
    if(emails[i].equals(emails[ilosc])){
      licznik++;
      emails[ilosc] = new String(email+licznik+"@mex.com");
    }
  }
    ilosc++;
   System.out.println("Continue? (1 - yes / 0 - no)");
   dalej = odczyt.nextInt();
  }
 
  for (String x: emails)
   if (x != null)
    System.out.println(x);
 
 }
}
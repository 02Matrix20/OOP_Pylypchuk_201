package LAB2;

import LAB2.Ex50.SomeClass;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
//import LAB2.Ex50;.SomeClass;

public class Main {


    public class NPE{
        public void show(){

        }
    }
    public static void main(String[] args) throws IOException {
        //-----------------41--------------------
        //------------------ArrayIndexOutOfBoundsException----------
        System.out.println("--------------------ArrayIndexOutOfBoundsException--------------------");
        int[] array = {897, 56, 78, 90, 12, 123, 75};
        System.out.println("Елементи масиву: ");
        System.out.println(Arrays.toString(array));
        // System.out.println("Введіть індекс необхідного елемента:");
        try {
            int element = 10;
            System.out.println("Елемент індексу: " + array[element]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введений вами індекс відсутній в масиві!! Помилка ArrayIndexOutOfBoundsException ");
        }

        //------------------ArithmeticException----------
        System.out.println("--------------------ArithmeticException--------------------");
        int a = 4;
        try {
            System.out.println(a/0);
        } catch (ArithmeticException e) {
            System.out.println("Відбулася неприпустима арифметична операція!!");
        }

        //------------------NullPointerException----------
        System.out.println("--------------------NullPointerException--------------------");
        NPE npe = null;
        try {
            npe.show();
        }catch (NullPointerException e){
            System.out.println("Відбулася помилка NullPointerException");
        }

        //------------------IndexOutOfBoundsException----------
        System.out.println("--------------------IndexOutOfBoundsException--------------------");
        Scanner scan = new Scanner( System.in );
        int data=9, slot=11 ;
        int[] value = new int[10];

        try
        {
            System.out.print("Введіть дані: ");
            data = scan.nextInt();
            System.out.print("Введіть індекс масиву: ");
            slot = scan.nextInt();
            value[slot] = data;
        }

        catch (IndexOutOfBoundsException ex )
        {
            System.out.println("Відбулася помилка IndexOutOfBoundsException");
        }

        //------------------Exception----------
        System.out.println("--------------------Exception--------------------");
        try {
            FileInputStream file = new FileInputStream("test.txt");
            System.out.println("Файл готовий");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        //-----------------50--------------------
        SomeClass sc = new SomeClass();
        SomeClass sc2 = new SomeClass();
    }
}
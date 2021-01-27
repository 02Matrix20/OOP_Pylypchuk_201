package com.company;
import java.util.*;


class Operations{
    /* 28	Створіть метод, який приймає параметр int та конвертує його з десяткової
 у шістнадцятирічну систему обчислення та  повертає у вигляді String.*/

    public static String num(int a){
        String  hexstr = Integer.toHexString(a);
        return hexstr;

    }


    /*17   Створіть метод, який приймає на вхід рядок та на виході змінює регістри букв на протилежні.
    Приклад - на вході "рУматРОн" на виході "РуМАТроН" */
    public static String reverseStr(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            charArray[i] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);

        }
        return new String(charArray);
    }


    /*1	Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих чисел, та вивести їх на екран.
    Приклад: діапазон з 5 до 11 та діапазон з 18 до 9. Спільні елементи - 9,10,11.*/
    public static  List<Integer> findCommonElement(int[] arr1, int[] arr2) {

        List<Integer> commonElements = new ArrayList<Integer>();

        for(int i = 0; i < arr1.length ;i++) {
            for(int j = 0; j< arr2.length ; j++) {
                if(arr1[i] == arr2[j]) {
                    if(!commonElements.contains(arr1[i])) {
                        commonElements.add(arr1[i]);
                    }
                }
            }
        }
        return commonElements;
    }

    /*11	Створіть метод, який знаходить суму цифр будь якого числа int.*/
    public static int sum(int n){
        int sum=0;
        while(n!=0){
            sum+=(n%10);
            n/=10;
        }
        return sum;

    }

}
/* 13	 Створіть метод, який сортує будь який масив int[] методом вибору.*/
class Sort{
    private int []arr;
    public Sort(int []arr){
        this.arr =arr;
    }
    public  int[] selectionSort(){

        int []sortArr = arr;

        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int min_i = i;

            for (int j = i+1; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        return sortArr;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("*--------------------28--------------------*");
        System.out.println("Enter the number to convert:");
        int a;
        Scanner scan = new Scanner(System.in);
        a=scan.nextInt();
        System.out.println(Operations.num(a));

        System.out.println("*-------------------17--------------------*");
        System.out.println("Enter text and press the ENTER key:");
        String s;
        Scanner scan1 = new Scanner(System.in);
        s=scan1.nextLine();
        System.out.println(Operations.reverseStr(s));

        System.out.println();

        System.out.println("*-------------------13--------------------*");
        int[] arr = new int [] {5,8,10,6,1,7,4};
        System.out.println("unsorted array:");
        for (int i = 0; i <arr.length;i++) {
            System.out.print(arr[i]+" ");
        }

        Sort sort = new Sort(arr);
        arr = sort.selectionSort();

        System.out.println();
        System.out.println();

        System.out.println("sorted array:");
        for (int i = 0; i <arr.length;i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
        System.out.println();

        System.out.println("*-------------------1--------------------*");


        int arr1[] = { 5,6,7,8,9,10,11,55 };
        int arr2[] = { 18,17,16,15,14,13,12,11,10,9 };
        System.out.println(Operations.findCommonElement(arr1, arr2));



        System.out.println("*-------------------11--------------------*");
        System.out.println("Enter the number:");
        int b;
        Scanner scan2 = new Scanner(System.in);
        b=scan2.nextInt();
        System.out.println("Sum of digit:"+ Operations.sum(b));
    }



}


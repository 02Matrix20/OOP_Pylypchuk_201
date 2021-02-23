package LAB1;
import java.util.*;


class Operations{
    /* 28	Створіть метод, який приймає параметр int та конвертує його з десяткової
 у шістнадцятирічну систему обчислення та  повертає у вигляді String.*/

   /* public  String num(int a) {
        String hexstr = Integer.toHexString(a);
        return hexstr;

    }*/

    private  char[] digits = "0123456789abcdef".toCharArray();

    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder buffer = new StringBuilder();
        while (num != 0) {
            buffer.append(digits[num & 0xF]);
            num = num >> 4;
        }
        return buffer.reverse().toString();
    }

    /*17   Створіть метод, який приймає на вхід рядок та на виході змінює регістри букв на протилежні.
    Приклад - на вході "рУматРОн" на виході "РуМАТроН" */
    public  String reverseStr(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            charArray[i] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);

        }
        return new String(charArray);
    }


    /*1	Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих чисел, та вивести їх на екран.
    Приклад: діапазон з 5 до 11 та діапазон з 18 до 9. Спільні елементи - 9,10,11.*/
    public  List<Integer> findCommonElement(int[] arr1, int[] arr2) {

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
    public  int sum(int n){
        int sum=0;
        while(n!=0){
            sum+=(n%10);
            n/=10;
        }
        return sum;

    }

}
/* 13	 Створіть метод, який сортує будь який масив int[] методом вибору.*/
class SelectionSorter {
    public  void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("*--------------------28--------------------*");
        System.out.println("Enter the number to convert:");
        int a;
        Scanner scan = new Scanner(System.in);
        a=scan.nextInt();
        Operations operation = new Operations();
        // System.out.println(operation.num(a));
        System.out.println(operation.toHex(a));

        System.out.println("*-------------------17--------------------*");
        System.out.println("Enter text and press the ENTER key:");
        String s;
        Scanner scan1 = new Scanner(System.in);
        s=scan1.nextLine();
        System.out.println(operation.reverseStr(s));

        System.out.println();

        System.out.println("*-------------------13--------------------*");
        int[] arr = new int [] {5,8,10,6,1,7,4};
        System.out.println("unsorted array:");
        for (int i = 0; i <arr.length;i++) {
            System.out.print(arr[i]+" ");
        }

        SelectionSorter selectionSort = new SelectionSorter();
        selectionSort.sort(arr);

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
        System.out.println(operation.findCommonElement(arr1, arr2));



        System.out.println("*-------------------11--------------------*");
        System.out.println("Enter the number:");
        int b;
        Scanner scan2 = new Scanner(System.in);
        b=scan2.nextInt();
        System.out.println("Sum of digit:"+ operation.sum(b));
    }



}


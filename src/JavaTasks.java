import java.util.Arrays;

public class JavaTasks {
    public static void main(String[] args) {
        MinMaxAverage arr = new MinMaxAverage();
        MinMaxAverage2 arr2 = new MinMaxAverage2();

        BubbleSort array = new BubbleSort();
        array.sortBubble();
        array.printer();

        PrimeNumbers numbers = new PrimeNumbers();

        DeleteElement element = new DeleteElement();
    }
}
//Задание1 : Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
class MinMaxAverage{
    private int[] arr;

    public MinMaxAverage(){
        arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 10);
        }
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        int min = arr[0];

        double sum = 0;
        for (double a : arr){
            sum += a;
        }
        double avrg = sum / arr.length;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Max: " + max + "\nMin: " + min + "\nAverage: " + avrg);
    }
}
//Задание1 : второй вариант
class MinMaxAverage2{
    private int[] arr;

    public MinMaxAverage2(){
        arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int) (Math.random() * 10);
        }
        int max = arr[0];
        int min = arr[0];
        double avrg = 0;

        for (int i = 0; i < arr.length; i++){
            if (max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];

            avrg += (double) arr[i]/arr.length;
        }
        System.out.print("Array: [");
        for (int a : arr){
            System.out.print( a + " ");
        }
        System.out.print("]");
        System.out.println();
        System.out.println("Max: " + max + "\nMin: " + min + "\nAverage: " + avrg);
    }
}

//Задание2 :  Реализуйте алгоритм сортировки пузырьком для сортировки массива.
class BubbleSort{
    private int[] arr;

    public BubbleSort(){

        arr = new int[] { 12, 4, 8, 10, 236, 7};
    }

    public void toSwap(int first, int second){
        int swap = arr[first];
        arr[first] = arr[second];
        arr[second] = swap;
    }

    public void sortBubble(){
        for( int out = (arr.length - 1); out >= 1; out--){
            for (int in = 0; in < out; in++){
                if (arr[in] > arr[in + 1]){
                    toSwap(in, in + 1);
                }
            }
        }
    }
    public void printer(){
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}

//Задание3 : Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
//Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
class PrimeNumbers{
    public PrimeNumbers(){
        System.out.print("Primes Numbers: ");
        for( int i = 2; i <= 100; i++){
            boolean isPrime = true;
            for(int j = 2; j < i; j++){
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + ", ");
        }
    }
}

//Задание4 : Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).
class DeleteElement{
    public DeleteElement(){
        int[] arr = new int[] {1, 2, 4, 4, 6, 4, 398, 8, 4};
        System.out.println();
        System.out.println("Array without deleted element: " + Arrays.toString(removeElement(arr, 4)));
    }

    public int[] removeElement(int[] arr, int value){
        int offset = 0;

        for(int i = 0; i < arr.length; i++){
            if (arr[i] == value){
                offset++;
            }
            else {
                arr[i - offset] = arr[i];
            }
        }
        return Arrays.copyOf(arr, arr.length - offset);
    }
}





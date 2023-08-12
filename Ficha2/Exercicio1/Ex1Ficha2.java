import java.util.Arrays;
import java.util.Scanner;

public class Ex1Ficha2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Exercicio a):  ler inteiros para um array e depois determinar o valor mínimo desse
        //array.
        System.out.println("Type the number of Integers n that you want to put in the array:");
        int total1 = sc.nextInt();

        int[] arr1 = new int[total1];
        int a = 0;
        for (int i = 0; i < total1 ; i++){
            a = sc.nextInt();
            arr1[i] = a;
        }

        int min = arr1[0];
        for (int j = 1; j < arr1.length ; j++){
            if (min > arr1[j]){
                min = arr1[j];
            }
        }
        System.out.println("o minimo do array e: " + min);


        //Exercicio b):  ler um array de inteiros e dois índices e determinar o array com os
        //valores entre esses índices
        System.out.println("Type the number of Integers n that you want to put in the array:");
        int total2 = sc.nextInt();

        int[] arr2 = new int[total2];
        int b = 0;
        for (int i = 0; i < total2; i++){
            b = sc.nextInt();
            arr2[i] = b;
        }

        System.out.println("Determine 2 numbers of indexes that yout want to use:");
        int ind1 = sc.nextInt();
        int ind2 = sc.nextInt();

        int[] newArr = new int[ind2-ind1 + 1];
        int count = 0;
        if (ind2 < total2){
            for(int j = ind1; j <= ind2; j++){
                newArr[count] = arr2[j];
                count++;
            }
        }else{
            System.out.println("The indexes is bigger ta«han the array!");
        }
        System.out.println("The value of the array is:" + Arrays.toString(newArr));

    }
}

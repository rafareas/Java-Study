import java.util.Scanner;

public class Ex1Ficha2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Exercicio a):  ler inteiros para um array e depois determinar o valor mínimo desse
        //array.
        System.out.println("Digite a quantidade de numeros interios n que vc quer ler:");
        int total = sc.nextInt();

        int[] arr = new int[total];
        int a = 0;
        for (int i = 0; i < total ; i++){
            a = sc.nextInt();
            arr[i] = a;
        }

        int min = arr[0];
        for (int j = 1; j < arr.length ; j++){
            if (min > arr[j]){
                min = arr[j];
            }
        }

        System.out.println("o minimo do array e: " + min);
    }
}

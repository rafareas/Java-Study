import java.util.Scanner;

public class Ex3Ficha1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int intervalo1 = 0;
        int intervalo2 = 0;
        int intervalo3 = 0;
        int intervalo4 = 0;

        System.out.println("Quantas classificações voce quer inserir?: ");
        int n = scanner.nextInt();


        for (int i = 0; i < n; i++){
            System.out.println("Insira uma classificacao");
            int res = scanner.nextInt();

            if (res >= 0 && res < 5){
                intervalo1++;
            }
            if (res >= 5 && res < 10){
                intervalo2++;
            }
            if (res >= 10 && res < 15){
                intervalo3++;
            }
            if (res >= 15 && res <= 20){
                intervalo4++;
            }
        }

        System.out.println("No intervalo de [0,5[ teve " + intervalo1 + " classificacoes.");
        System.out.println("No intervalo de [5,10[ teve " + intervalo2 + " classificacoes.");
        System.out.println("No intervalo de [10,15[ teve " + intervalo3 + " classificacoes.");
        System.out.println("No intervalo de [15,20] teve " + intervalo4 + " classificacoes.");

        scanner.close();
    }

}

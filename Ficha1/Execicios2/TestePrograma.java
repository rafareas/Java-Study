import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ficha1 ficha1 = new Ficha1();

        int res = 1;
        while (res == 1){
            System.out.println("---------------------Bem vindo! Qual operação vc quer fazer?------------------------");
            System.out.println("0 - Converter celsius para Farenheit");
            System.out.println("1 - Saber o maximo entre dois valores");
            System.out.println("2 - Escrever o saldo de uma pessoa");
            System.out.println("3 - Converter Euro para Libra");
            System.out.println("4 - Calcular o fatorial de um numero");
            System.out.println("5 - Tempo gasto para fazer fatorial de 5000");
            int valor = scanner.nextInt();

            switch (valor){
                case 0:
                    System.out.println("digite o valor para converter celsius para Farenheit: ");
                    int graus = scanner.nextInt();
                    System.out.println("O valor de " + graus + " celsius para farenheit e: " + ficha1.celsiusParaFarenheit(graus));
                    break;
                case 1:
                    System.out.println("Digite dois valores para ter o maximo entre eles: ");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    System.out.println("O maximo entre " + a + " " + b + " e: " + ficha1.maximoNumeros(a,b));
                    break;
                case 2:
                    System.out.println("Escreva o seu nome e o valor");
                    String s = scanner.next();
                    int v = scanner.nextInt();
                    System.out.println(ficha1.criaDescricaoConta(s,v));
                    break;
                case 3:
                    System.out.println("Digite o valor e dps a taxa de convercao:");
                    double v1 = scanner.nextDouble();
                    double tc = scanner.nextDouble();
                    System.out.println("A taxa de converçao e: " + ficha1.eurosParaLibras(v1,tc));
                case 4:
                    System.out.println("Digite o valor para calcular seu fatorial: ");
                    int fact = scanner.nextInt();
                    System.out.println("O fatorial de " + fact + " e: " + ficha1.factorial(fact));
                    break;
                case 5:
                    System.out.println("Tempo gasto " + ficha1.tempoGasto() + "ms.");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
            System.out.println("Deseja continuar? (prima 1 para continuar e 0 para sair)");
            res = scanner.nextInt();
        }

    }
}

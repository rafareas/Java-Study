import java.util.Scanner;


public class Ex1Ficha1 {


    public static String diaSemana(int ano, int mes, int dia){
        String[] dias = {"domingo","segunda","terça","quarta","quinta","sexta","sabado"};

        int res = (ano - 1900) * 365 + (ano - 1900)/4;


        if(ano%4 == 0 && (ano%100 != 0 && ano%400 != 0)){
            if(mes<=2){
                res -=1;
            }
        }


        for(int i=1;i<mes;i++) {
            switch (i) {
                case 3:
                    res += 31;
                    break;
                case 10:
                    res += 31;
                    break;
                case 8:
                    res += 31;
                    break;
                case 12:
                    res += 31;
                    break;
                case 7:
                    res += 31;
                    break;
                case 1:
                    res += 31;
                    break;
                case 11:
                    res += 30;
                    break;
                case 5:
                    res += 30;
                    break;
                case 4:
                    res += 30;
                    break;
                case 9:
                    res += 30;
                    break;
                case 2:
                    res += 28;
                    break;
            }
            res += dia;
        }

        int diaSemana = res%7;

        System.out.println(diaSemana);

        return dias[diaSemana];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduza o dia, mês e ano:");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        System.out.println("o dia da semana e: " + diaSemana(ano,mes,dia));

    }

}
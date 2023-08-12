import java.util.Scanner;

public class Ex2Ficha2 {
    public static void main(String[] args) {
        // Considerando que temos uma pauta de 5 alunos e que todos os alunos tem
        // notas a 5 unidades curriculares, define-se o array int[5][5] notasTurma
        // (Alunos X UnidadesCurriculares). Crie um programa que permita:

        Scanner scanner = new Scanner(System.in);

        int[][] notasTurma = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        int operacao = 1;

        while (operacao != 0){
            operacao = 0;
            System.out.println("Which operation do you want to use?");
            System.out.println("1 - ler as notas dos alunos");
            System.out.println("2 - actualiza o array da pauta");
            System.out.println("3 - calcular a média das notas de um aluno");
            System.out.println("0 - exit the program");
            operacao = scanner.nextInt();

            int numAluno;
            int uc;
            int note;
            switch (operacao){
                case 1:
                    System.out.println("which number of student do you want to read?");
                    numAluno = scanner.nextInt();
                    System.out.println("which number of UC do you want to read");
                    uc = scanner.nextInt();
                    System.out.println("->The note of student "+ numAluno + " in the UC "+uc+" is " + notasTurma[numAluno][uc]+"<-");
                    break;
                case 2:
                    System.out.println("Type the number of the student:");
                    numAluno = scanner.nextInt();
                    System.out.println("Type the number of UC that you want to update:");
                    uc = scanner.nextInt();
                    System.out.println("Type the note of student " + numAluno + " that you want to update");
                    note = scanner.nextInt();

                    notasTurma[numAluno][uc] = note;
                    System.out.println("->the note of student " + numAluno + " in the UC " + uc + " is " + note+ "<-");
                    break;
                case 3:
                    System.out.println("which number of student do you want to calculate the average of notes?");
                    numAluno = scanner.nextInt();

                    int totalNotes = 0;
                    for (int i = 0; i < 5;i++){
                        totalNotes += notasTurma[numAluno][i];
                    }
                    double averageNote = totalNotes/5;

                    System.out.println("the average notes of student "+numAluno+" is "+averageNote);
                    break;
                default:
                    System.out.println("------------the program was finished---------------");
                    break;
            }
        }






    }
}

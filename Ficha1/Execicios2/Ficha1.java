import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ficha1 {

    //Exercicio 1: Mudar de Celsius para Farenheit
    public double celsiusParaFarenheit(double graus){
        return (graus * 1.8) + 32;
    }

    //Exercicio 2: Determinar o maximo entre dois numeros
    public int maximoNumeros(int a, int b){
        return Math.max(a,b);
    }

    //Exercicio 3: Ler um nome (String) e um saldo (decimal) e imprimir um texto com os valores obtidos na leitura
    public String criaDescricaoConta(String nome, double saldo){
        String res = "Esse e o nome: " + nome + " e esse e o saldo dele(a): " + saldo;
        return res;
    }

    //Exercicio 4: Ler um valor em euros e uma taxa de conversão para libras e imprimir o resultado da
    //conversão em libras.
    public double eurosParaLibras(double valor, double taxaConversao){
        return valor/taxaConversao;
    }

    //Exercicio 5: Calcular o fatorial de um numero
    public long factorial(int num){
        long fatorial = 1;

        for (int i = 1; i <= num;i++){
            fatorial *= i;
        }
        return fatorial;
    }

    //Exercicio 7: Escreve um programa que determine a data e hora do sistema, calcule o factorial de
    //5000, determine a hora após tal ciclo, e calcule o total de milissegundos que tal ciclo
    //demorou a executar.
    public long tempoGasto(){
        int fatorial = 1;

        LocalDateTime timeInit = LocalDateTime.now();

        for (int i = 1; i <= 5000; i++){
            fatorial *= i;
        }
        LocalDateTime timeEnd = LocalDateTime.now();

        long tempoFinal = Duration.between(timeInit,timeEnd).toMillis();

        return tempoFinal;
    }
}

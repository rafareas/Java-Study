import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class TestCirculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circulo circulo = new Circulo(2,2,4);

        System.out.println("A area do circulo e: "+circulo.calculaArea());
        System.out.println("O perimetro do e: "+circulo.calculaPerimetro());
        System.out.println(circulo.toString());
        circulo.setX(3.0);
        System.out.println(circulo.toString());
    }
}

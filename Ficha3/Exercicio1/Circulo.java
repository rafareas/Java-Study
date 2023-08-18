import java.util.Map;
import java.util.Objects;

public class Circulo {

    // Variaveis de instancia
    private double x;
    private double y;
    private double raio;

    //Construtor por omissão do circulo
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    // Construtor parametrizado do circulo
    // Aceita como parâmetros os valores para cada coordenada
    public Circulo(double cx, double cy,double craio){
        this.x = cx;
        this.y = cy;
        this.raio = craio;
    }

    // Construtor de copia do circulo
    // Aceita como parametro outro Circulo e utiliza os metodos de acesso aos valores das variáveis de instância
    public Circulo(Circulo circulo){
        this.x = circulo.getX();
        this.y = circulo.getY();
        this.raio = circulo.getRaio();
    }

    // Metodos de instancia
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio(){
        return this.raio;
    }

    public void setX(double novoX){
        this.x = novoX;
    }

    public void setY(double novoY){
        this.y = novoY;
    }

    public void setRaio(double novoRaio){
        this.raio = novoRaio;
    }

    public void alteraCentro(double x, double y){
        setX(x);
        setY(y);
    }

    public double calculaArea(){
        return (Math.PI * Math.pow(this.raio,2));
    }

    public double calculaPerimetro(){
        return (2*Math.PI * this.raio);
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return getX() == circulo.getX() && getY() == circulo.getY() && Double.compare(circulo.getRaio(), getRaio()) == 0;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                '}';
    }

    public Circulo clone(){
        return new Circulo(this);
   }
}

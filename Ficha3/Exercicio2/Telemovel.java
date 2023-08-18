import java.util.ArrayList;
import java.util.Objects;

public class Telemovel {
    private String marca;
    private String modelo;
    private ArrayList<String> textoMsg;
    private int displayX;
    private int displayY;
    private int tamArmazenamento;
    private int tamApp;
    private int tamFotos;
    private int tamTotal;
    private int numFotos;
    private int numAppIn;
    private String nomeAppIn;

    public Telemovel(){
        this.marca = "";
        this.modelo = "";
        this.textoMsg = new ArrayList<>();
        this.displayX = 0;
        this.displayY = 0;
        this.tamArmazenamento = 0;
        this.tamApp = 0;
        this.tamFotos = 0;
        this.tamTotal = 0;
        this.numFotos = 0;
        this.numAppIn = 0;
        this.nomeAppIn = "";
    }

    public Telemovel(String nmarca,String nmodelo,ArrayList<String> textoMsg,int displayX,int displayY,int tamArmazenamento,int tamApp,int tamFotos,
                     byte tamTotal,int numFotos,int numAppIn,String nomeAppIn){
        this.marca = nmarca;
        this.modelo = nmodelo;
        this.textoMsg = textoMsg;
        this.displayX = displayX;
        this.displayY = displayY;
        this.tamArmazenamento = tamArmazenamento;
        this.tamApp = tamApp;
        this.tamFotos = tamFotos;
        this.tamTotal = tamTotal;
        this.numFotos = numFotos;
        this.numAppIn = numAppIn;
        this.nomeAppIn = nomeAppIn;
    }

    public Telemovel(Telemovel tel){
        this.marca = tel.getMarca();
        this.modelo = tel.getModelo();
        this.textoMsg = tel.getTextoMsg();
        this.displayX = tel.getDisplayX();
        this.displayY = tel.getDisplayY();
        this.tamArmazenamento = tel.getTamAmazenamento();
        this.tamApp = tel.getTamApp();
        this.tamFotos = tel.getTamFotos();
        this.tamTotal = tel.getTamTotal();
        this.numFotos = tel.getNumFotos();
        this.numAppIn = getNumAppIn();
        this.nomeAppIn = getNomeAppIn();
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String nmarca){
        this.marca = nmarca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String nmodelo){
        this.modelo = nmodelo;
    }

    public ArrayList<String> getTextoMsg(){
        return this.textoMsg;
    }

    public void setTextoMsg(String nTextoMsg){
        textoMsg.add(nTextoMsg);
    }

    public int getDisplayX(){
        return this.displayX;
    }

    public void setDisplayX(int ndisplayX){
        this.displayX = ndisplayX;
    }

    public int getDisplayY(){
        return this.displayY;
    }

    public void setDisplayY(int ndisplayY){
        this.displayY = ndisplayY;
    }

    public int getTamAmazenamento(){
        return this.tamArmazenamento;
    }

    public void setTamArmazenamento(int ntamArmazenamento){
        this.tamArmazenamento = ntamArmazenamento;
    }

    public int getTamApp(){
        return this.tamApp;
    }

    public void setTamApp(int ntamApp){
        this.tamApp = ntamApp;
    }

    public int getTamFotos(){
        return this.tamFotos;
    }

    public void setTamFotos(int ntamFotos){
        this.tamFotos = ntamFotos;
    }

    public int getTamTotal(){
        return this.tamTotal;
    }

    public void setTamTotal(int ntamTotal){
        this.tamTotal = ntamTotal;
    }

    public int getNumFotos(){
        return this.numFotos;
    }

    public void setNumFotos(int nNumFotos){
        this.numFotos = nNumFotos;
    }

    public int getNumAppIn(){
        return this.numAppIn;
    }

    public void setNumAppIn(int nNumAppIn){
        this.numAppIn = nNumAppIn;
    }

    public String getNomeAppIn(){
       return this.nomeAppIn;
    }

    public void setNomeAppIn(String nNomeAppIn){
        this.nomeAppIn = nNomeAppIn;
    }

    public boolean existeEspaco(int numeroBytes){
        return (numeroBytes < tamTotal);
    }

    public void instalaApp(String nome, int tamanho){
        setNomeAppIn(nome);
        setTamApp(tamanho);
        this.numAppIn++;
    }

    public void recebeMsg(String msg){
        setTextoMsg(msg);
    }

    public double tamMedioApps(){
        return (this.tamApp / this.numAppIn);
    }

    public String maiorMsg(){
        int maiorTam = 0;
        String maior = "";
        for (String elem : this.textoMsg){
            if (elem.length() > maiorTam){
                maiorTam = elem.length();
                maior = elem;
            }
        }
        return maior;
    }



    @Override
    public String toString() {
        return "Telemovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", tamArmazenamento=" + tamArmazenamento +
                ", tamApp=" + tamApp +
                ", tamFotos=" + tamFotos +
                ", tamTotal=" + tamTotal +
                ", numFotos=" + numFotos +
                ", numAppIn=" + numAppIn +
                ", nomeAppIn='" + nomeAppIn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return getDisplayX() == telemovel.getDisplayX() && getDisplayY() == telemovel.getDisplayY() && tamArmazenamento == telemovel.tamArmazenamento && getTamApp() == telemovel.getTamApp() && getTamFotos() == telemovel.getTamFotos() && getTamTotal() == telemovel.getTamTotal() && getNumFotos() == telemovel.getNumFotos() && getNumAppIn() == telemovel.getNumAppIn() && Objects.equals(getMarca(), telemovel.getMarca()) && Objects.equals(getModelo(), telemovel.getModelo()) && Objects.equals(getNomeAppIn(), telemovel.getNomeAppIn());
    }

    public Telemovel clone(){
        return new Telemovel(this);
    }
}

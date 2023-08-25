import java.util.Objects;

public class Lampada {
    private enum Modo{
        ON,
        OFF,
        ECO
    }

    private Modo modo;
    private double cpsON;
    private double cpsECO;
    private double consumoTotal;
    private double periodoConsumo;

    public Lampada(){
        this.modo = Modo.OFF;
        this.cpsECO = 1;
        this.cpsON = 2;
        this.consumoTotal = 0;
        this.periodoConsumo = 0;
    }

    public Lampada(Modo x, double cpsON,double cpsECO, double consumoTotal, double periodoConsumo){
        switch (x) {
            case ON: modo = Modo.ON;
                break;
            case OFF: modo = Modo.OFF;
                break;
            case ECO: modo = Modo.ECO;
                break;
        }
        this.cpsON = cpsON;
        this.cpsECO = cpsECO;
        this.consumoTotal = consumoTotal;
        this.periodoConsumo = periodoConsumo;
    }

    public Lampada(Lampada lp){
        this.modo = lp.getModo();
        this.cpsON = lp.getCpsON();
        this.cpsECO = lp.getCpsECO();
        this.consumoTotal = lp.getConsumoTotal();
        this.periodoConsumo = lp.getPeriodoConsumo();
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public double getCpsON() {
        return cpsON;
    }

    public void setCpsON(double cpsON) {
        this.cpsON = cpsON;
    }

    public double getCpsECO() {
        return cpsECO;
    }

    public void setCpsECO(double cpsECO) {
        this.cpsECO = cpsECO;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getPeriodoConsumo() {
        return periodoConsumo;
    }

    public void setPeriodoConsumo(double periodoConsumo) {
        this.periodoConsumo = periodoConsumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return Double.compare(lampada.getCpsON(), getCpsON()) == 0 && Double.compare(lampada.getCpsECO(), getCpsECO()) == 0 && Double.compare(lampada.getConsumoTotal(), getConsumoTotal()) == 0 && Double.compare(lampada.getPeriodoConsumo(), getPeriodoConsumo()) == 0 && getModo() == lampada.getModo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModo(), getCpsON(), getCpsECO(), getConsumoTotal(), getPeriodoConsumo());
    }

    @Override
    public String toString() {
        return "Lampada{" +
                "modo=" + modo +
                ", cpsON=" + cpsON +
                ", cpsECO=" + cpsECO +
                ", consumoTotal=" + consumoTotal +
                ", periodoConsumo=" + periodoConsumo +
                '}';
    }

    public Lampada clone(){
        return new Lampada(this);
    }

    private void calculaEco(){
        this.consumoTotal += (System.currentTimeMillis() - this.periodoConsumo) * this.cpsECO;
    }

    private void calculaOn(){
        this.consumoTotal += (System.currentTimeMillis() - this.periodoConsumo) * this.cpsON;
    }

    public void lampON(){
        if (this.modo == modo.ECO){
            calculaEco();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.ON;
    }

    public void lampOFF(){
        if (this.modo == Modo.ECO) {
            calculaEco();
        }
        if (this.modo == Modo.ON) {
            calculaOn();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.OFF;
    }

    public void lampECO(){
        if (this.modo == Modo.ON) {
            calculaOn();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.ECO;
    }

    public double totalConsumo(){
        //consumo total so mede os usos anteriores, falta o que esta a decorrer agora
        return periodoConsumo() + consumoTotal;
    }

    public double periodoConsumo() {
        double atual = 0;
        if (modo == Modo.ON) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.cpsON;
        else if (modo == Modo.ECO) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.cpsECO;
        return atual;
    }


}

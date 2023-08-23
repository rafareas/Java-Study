import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Encomenda {
    private String nomeCliente;
    private int nif;
    private String morada;
    private int numEnc;
    private String dataEnc;
    private ArrayList<LinhaEncomenda> linhaEnc;

    public Encomenda(){
        this.nomeCliente = "";
        this.nif = 0;
        this.morada = "";
        this.numEnc = 0;
        this.dataEnc = "";
        this.linhaEnc = new ArrayList<>();
    }

    public Encomenda(String nomeCliente,int nif,String morada,int numEnc,String dataEnc,ArrayList<LinhaEncomenda> linhaEnc){
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.dataEnc = dataEnc;
        for (LinhaEncomenda linha : linhaEnc){
            this.linhaEnc.add(linha.clone());
        }
    }

    public Encomenda(Encomenda enc){
        this.nomeCliente = enc.getNomeCliente();
        this.nif = enc.getNif();
        this.morada = enc.getMorada();
        this.numEnc = enc.getNumEnc();
        this.dataEnc = enc.getDataEnc();
        this.linhaEnc = enc.getLinhaEnc();
    }

    public String getNomeCliente(){
        return this.nomeCliente;
    }

    public void setNomeCliente(String nome){
        this.nomeCliente = nome;
    }

    public int getNif(){
        return this.nif;
    }

    public void setNif(int nninf){
        this.nif = nninf;
    }

    public String getMorada(){
        return this.morada;
    }

    public void setMorada(String nmorada){
        this.morada = nmorada;
    }

    public int getNumEnc(){
        return this.numEnc;
    }

    public void setNumEnc(int numEnc){
        this.numEnc = numEnc;
    }

    public String getDataEnc(){
        return this.dataEnc;
    }

    public void setDataEnc(String ndata){
        this.dataEnc = ndata;
    }

    public ArrayList<LinhaEncomenda> getLinhaEnc(){
        ArrayList<LinhaEncomenda> res = new ArrayList<>();
        for (Iterator<LinhaEncomenda> i = this.linhaEnc.iterator(); i.hasNext();){
            LinhaEncomenda linha = i.next();
            res.add(linha.clone());
        }
        return res;
    }

    public void setLinhaEnc(ArrayList<LinhaEncomenda> linha){
        this.linhaEnc = (ArrayList<LinhaEncomenda>) linha.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getNif() == encomenda.getNif() && getNumEnc() == encomenda.getNumEnc() && Objects.equals(getNomeCliente(), encomenda.getNomeCliente()) && Objects.equals(getMorada(), encomenda.getMorada()) && Objects.equals(getDataEnc(), encomenda.getDataEnc()) && Objects.equals(getLinhaEnc(), encomenda.getLinhaEnc());
    }


    @Override
    public String toString() {
        return "Encomenda{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", nif=" + nif +
                ", morada='" + morada + '\'' +
                ", numEnc=" + numEnc +
                ", dataEnc='" + dataEnc + '\'' +
                ", linhaEnc=" + linhaEnc +
                '}';
    }


    public double calculaValorTotal(){
        double res = 0;
        for (LinhaEncomenda enc : this.linhaEnc){
            res += enc.calculaValorLinhaEnc();
        }
        return res;
    }

    public double calculaValorDesconto(){
        return this.linhaEnc.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    public int numeroTotalProdutos(){
        int r = 0;
        for (LinhaEncomenda le : this.linhaEnc){
            r += le.getQuantidade();
        }
        return 0;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        Boolean r = false;
        for (LinhaEncomenda le : this.linhaEnc){
            if (le.getReferencia().equals(refProduto)){
                r = true;
            }
        }
        return r;
    }


    public boolean existeProdutoEncomenda1(String refProduto){
        Boolean existe = false;
        int i = 0;
        while(!existe && i < this.linhaEnc.size()){
            if (this.linhaEnc.get(i).getReferencia().equals(refProduto)){
                existe = true;
            }
            i++;
        }
        return existe;
    }

    public boolean existeProdutoEncomenda2(String refProduto){
        return this.linhaEnc.stream().anyMatch(a -> (a.getReferencia().equals(refProduto)));
    }


    public void adicionaLinha(LinhaEncomenda linha){
        this.linhaEnc.add(linha.clone());
    }

    public void removeProduto(String codProd){
        for (LinhaEncomenda le : this.linhaEnc){
            if (le.getReferencia().equals(codProd)){
                linhaEnc.remove(le);
            }
        }
    }

    //calcula o numero de produtos encomendados nesta encomenda
    public int numProdutos(){
        return this.linhaEnc.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    //calcula a lista dos produtos de uma encomenda
    public List<String> getListaProdutos(){
        return this.linhaEnc.stream().map(LinhaEncomenda::getReferencia).distinct().collect(Collectors.toList());
    }
}

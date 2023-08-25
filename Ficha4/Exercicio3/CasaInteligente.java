import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CasaInteligente {
    List<Lampada> lampadas;

    public CasaInteligente(){
        this.lampadas = new ArrayList<>();
    }

    public CasaInteligente(List<Lampada> lamp){
        this.lampadas = new ArrayList<>(lamp.size());
        for(Lampada l : lamp){
            this.lampadas.add(l.clone());
        }
    }

    public CasaInteligente(CasaInteligente lp){
        this.lampadas = lp.getLampada();
    }

    public List<Lampada> getLampada(){
        List<Lampada> res = new ArrayList<>();
        for(Iterator<Lampada> i = this.lampadas.iterator(); i.hasNext();){
            Lampada l = i.next();
            res.add(l.clone());
        }
        return res;
    }

    public void setLampada(List<Lampada> lamp){
        this.lampadas = lamp.stream().map(Lampada::clone).collect(Collectors.toList());
    }


    public void addLampada(Lampada l){
        this.lampadas.add(l.clone());
    }

    public void ligaLampadaNormal(int index){

    }
}

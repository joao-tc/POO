import java.util.ArrayList; 
import java.util.List;

public class GaragemTrem{
    public List<Composicao> garagemComposicaos;

    public GaragemTrem(){
        this.garagemComposicaos = new ArrayList<>();
    }

    public void addTrem(Composicao trem){
        garagemComposicaos.add(trem);
    }

    public Composicao removeDaGaragemTrem(int index){
        if(index>=0 && index<garagemComposicaos.size()){
            return this.garagemComposicaos.remove(index);
        }

        else{
            System.out.println("Nao existem mais composicoes");
            return null;
        }
    }

    public List<Composicao> listarComposicaos(){
        return this.garagemComposicaos;
    }


}


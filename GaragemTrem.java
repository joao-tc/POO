import java.util.ArrayList; 
import java.util.List;

public class GaragemTrem{
    public List<Composicao> garagemComposicaos;

    public GaragemTrem(){
        garagemComposicaos = new ArrayList<>();
    }

    public void addTrem(Composicao trem){
        garagemComposicaos.add(trem);
    }

    public Composicao removeDaGaragemTrem(int index){
        if(index>=0 && index<garagemComposicaos.size()){
            return garagemComposicaos.remove(index);
        }

        else{
            System.out.println("Nao existem mais composicoes");
            return null;
        }
    }

    public List<Composicao> listarComposicaos(){
        return garagemComposicaos;
    }


}


 import java.util.Arrays;
import javax.sound.midi.SysexMessage;

public class Composicao {
    private int idComposicao;
    private int qtdLocomotivas;
    private int qtdVagoes;
    private Locomotivas [] compLocomotivas;
    private Vagoes [] compVagoes;
    
    public Composicao(int idComposicao){
        this.idComposicao = idComposicao;
        qtdLocomotivas = 0;
        qtdVagoes = 0;
        compLocomotivas = new Locomotivas[3];
        compVagoes = new Vagoes[80];

    }

    public int getIdComposicao(){
        return idComposicao;
    }

   public int getQtdLocomotivas(){
    return qtdLocomotivas;
   }

   public int getQtdVagoes(){
    return qtdVagoes;
   }

   public void addLocomotiva(Locomotivas locomotivax){
    if(qtdLocomotivas<compLocomotivas.length){
        compLocomotivas[qtdLocomotivas] = locomotivax;
        qtdLocomotivas++;
    }
    else{
        System.out.println(" Já comporta o maximo de Locomotivas neste trem. ");
    }
   }
    
}
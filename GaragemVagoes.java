////existe o proximo slot pra sempre por no final do array e isso em todas as classes
import java.util.Arrays;

public class GaragemVagoes {
    public Vagoes[] garagemVagoes;
    private int proximoSlot;
    private int limiteMax;
    

    public GaragemVagoes(int limiteMax){
        this.limiteMax = limiteMax;
        garagemVagoes = new Vagoes[limiteMax];

    }

    public void addVagão(Vagoes vagao){
        //simplesmente adiciona um vagão, 
        // Lembrar que é preciso na hora de remover das Composições adicionar aqui novamente, para não perder tambem la.
        if(proximoSlot<limiteMax){  
            garagemVagoes[proximoSlot] = vagao;
            proximoSlot++;
        }
        else{
            System.out.println("a garagem está Cheia");
        }

    }

    public Vagoes removerVagao(){
        //Esse metodo serve pra retirar o ultimo vagão colocado na garagem, e ele salva o ultimo vagão removido
        //importante notar que só salva o ultimo, então na hora do main, ou em algum momento preciso salvar ele no adicionado em composição 
        if(proximoSlot>0){
            Vagoes vagaoRetirado = garagemVagoes[proximoSlot-1];
            garagemVagoes[proximoSlot-1] = null;
            proximoSlot--;
            return vagaoRetirado;
        }
         else{
             System.out.print(" Não existem mais vagões. ");
             return null;
        }
    }

    @Override
    public String toString() {
        return "GaragemVagoes{" +
                "garagemVagoes=" + Arrays.toString(garagemVagoes) +
                ", limiteMax=" + limiteMax +
                '}';
    }
    
}

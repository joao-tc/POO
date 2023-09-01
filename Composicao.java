import java.util.Arrays;


public class Composicao {
    private int idComposicao;
    private int qtdLocomotivas;
    private int qtdVagoes;
    public Locomotivas [] compLocomotivas;
    public Vagoes [] compVagoes;
    private int qtdMaxLocomotivas, qtdMaxVagoes;
    
    public Composicao(int idComposicao){
        this.idComposicao = idComposicao;
        this.compLocomotivas = compLocomotivas;
        this.compVagoes = compVagoes;
        qtdLocomotivas = 0;
        qtdVagoes = 0;
        qtdMaxLocomotivas = 3;
        qtdMaxVagoes = 80;
        compLocomotivas = new Locomotivas[qtdMaxLocomotivas];
        compVagoes = new Vagoes[qtdMaxVagoes];

    }

    public int getQtdMaxLocomotivas(){
        return qtdMaxLocomotivas;
    }

    public int getQtdMaxVagoes(){
        return qtdMaxVagoes;
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

   public void addVagoes(Vagoes vagoesx){
    switch(qtdLocomotivas){
        case 1:
            if(qtdVagoes<=30){
            compVagoes[qtdVagoes] = vagoesx;
            qtdVagoes++;
            }
            else{System.out.println("Chegou ao limite de vagoes que a locomotiva suporta.");}
            break;
        case 2:
            if(qtdVagoes<=50){
                System.out.println("esta funcionando");
                compVagoes[qtdVagoes] = vagoesx;
                qtdVagoes++;
            }
             else{System.out.println("Chegou ao limite de vagoes que a locomotiva suporta.");}
            break;
        case 3:
            if(qtdVagoes<=80){
                compVagoes[qtdVagoes] = vagoesx;
                qtdVagoes++;
            }
             else{System.out.println("Chegou ao limite de vagoes que a locomotiva suporta.");}
            break;
        default:
            if(qtdLocomotivas==0){
                System.out.println(" Seu trem precisa que as Locomotivas entrem primeiro. ");
            }
            else{
                System.out.println("Não pode colocar mais Vagões");
            }

    }
   }

   public Locomotivas rLocomotivasTrem(){
    if(qtdLocomotivas>0){
        Locomotivas rLocomotiva = compLocomotivas[qtdLocomotivas-1];
        compLocomotivas[qtdLocomotivas-1] = null;
        qtdLocomotivas--;
        return rLocomotiva;
    }
    else{
        System.out.println("Nao existme mais locomotivas.");
        return null;}
   }

   public Vagoes rVagoes(){
    if(qtdVagoes>0){
        Vagoes rVagoes = compVagoes[qtdVagoes-1];
        compVagoes[qtdVagoes-1]=null;
        qtdVagoes--;
        return rVagoes;
    }
    else{
        System.out.println("Nao tem mais Vagoes");
        return null;
    }

   }

   @Override
   public String toString() {
       return "Composicao{" +
               "idComposicao=" + idComposicao +
               ", qtdLocomotivas=" + qtdLocomotivas +
               ", qtdVagoes=" + qtdVagoes +
               ", compLocomotivas=" + Arrays.toString(compLocomotivas) +
               ", compVagoes=" + Arrays.toString(compVagoes) +
               '}';
   }
    
}
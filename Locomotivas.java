public class Locomotivas {

private int idLocomotivas;
private double pesoMax;
private int qtdMaxVagoes;
private int ComposicaoTrem; //id da composicao que a locomotiva ta alocada
private boolean isEmpity;

public Locomotivas(int idLocomotivas, double pesoMax){
    this.idLocomotivas = idLocomotivas;
    this.pesoMax = pesoMax;
    qtdMaxVagoes = 80;
    isEmpity = true;

}

/* 
public boolean getIsEmpity(){
    return isEmpity;
}
*/

public int getIdLocomotiva(){
    return idLocomotivas;
}

public double getPesoMax(){
    return pesoMax;
}


public void setIsEmpity(boolean novoEstado){
    isEmpity = novoEstado;

}


@Override
    public String toString() {
        return "Locomotiva [ID: " + idLocomotivas + ", Carga: " + pesoMax;
    }

    
}

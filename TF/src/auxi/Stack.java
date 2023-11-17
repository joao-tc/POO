package auxi;

import main.Locomotiva;
import main.Main;
import main.Vagao;

public class Stack { // Nessa classe foi criado um sistema de stack com as regras para criacao de novos trens
    
    /*Declaracao de variaveis*/

        // Inicia um Array da superClasse Carro
        private Carro[] stack;

        // Identificador padrao
        private int idComp = -1;
    
        // Variaveis de controle para as locomotivas
        private int nLocomotiva = 0;
        private int maxLocomotiva = 3;
        private boolean lastLocomotiva = true;

        // Variaveis de controle para os vagoes
        private int nVagao = 0;
        private int maxVagao;

        // Controle da Stack
        private double cargaMax;
        private double cargaAt = 0; 
        private int top = 0;

    /*Metodo construtor que recebe o ID da nova composicao*/
    public Stack(int idComp) {
        this.idComp = idComp;

        stack = new Carro[80];
    }

    /*Adiciona novo carro na Stack*/
    public void push(Carro c) {
        // Limita a quantidade maxima de vagoes de acordo com a quantidade de locomotivas
        switch(nLocomotiva){
            case 1:
                maxVagao = 30;
                break;
                
            case 2:
                maxVagao = 50;
                break;

            case 3:
                maxVagao = 80;
                break; 
        }

        if(c instanceof Locomotiva) { // Adiciona nova locomotiva seguindo as regras
            if(nLocomotiva < maxLocomotiva && lastLocomotiva && c.getIsFree()) {
                cargaMax += ((Locomotiva) c).getCapacidadeMax();
                this.stack[top] = c;
                c.setIsFree(false);
                nLocomotiva++;
                c.setIdComp(this.idComp);
                top++;
            } else {
                Main.menuCriar.newAlert(1);
            }
        } else if(c instanceof Vagao){ // Adiciona novo vagao seguindo as regras
            double pesoAt = ((Vagao) c).getPesoMax();
            if(nVagao < maxVagao && c.getIsFree() && cargaAt + pesoAt <= cargaMax) {
                cargaAt += pesoAt;
                this.stack[top] = c;
                c.setIsFree(false);
                nVagao++;
                c.setIdComp(this.idComp);
                lastLocomotiva = false;
                top++;
            } else {
                Main.menuCriar.newAlert(0);
            }
        }
    }

    /*Remove e libera o ultimo carro da Stack*/
    public void pop() {
        top--;

        if(top <= 0) {
            top++;
            return;
        }

        if(this.stack[top] instanceof Vagao) {
            nVagao--;
        } else {
            nLocomotiva--;
        }

        this.stack[top].setIdComp(-1);
        this.stack[top].setIsFree(true);
        this.stack[top] = null;

        if(nVagao == 0) {
            lastLocomotiva  = true;
        }
    }

    /*Setter*/
    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    /*Getters*/
    public int getIdComp(){
        return this.idComp;
    }

    public int getTop() {
        return top;
    }

    public int getLen() {
        int len = 0;
        for(int i = 0; i < stack.length; i++) {
            if(stack[i] == null) {
                break;
            } else {
                len++;
            }
        }
        return len;
    }

    public Carro getObj(int index){
        return stack[index];
    }
    /***/

    /*Metodo toString*/
    public String toString(){
        return "ID_Comp: " + this.idComp + ", Locomotivas: " + this.nLocomotiva + ", Vagões: " + this.nVagao;
    }

    public String totostring() {
        String asd = "";
        for(int i = 0; i < stack.length; i++) {
            if(stack[i] != null)
                asd = asd + stack[i] + "\n";
        }
        return asd;
    }
}

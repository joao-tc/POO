package auxi;

public class Carro { // SuperClasse para ajudar na organizacao da composicao
    
    /*Declaracao de variaveis*/
        // Identificadores
        public int id = 0;
        protected int idComp = -1;

        // Verifica se o carro esta ou nao em uma combinacao
        protected boolean isFree = true;

    /*Getters*/
    public int getId() {
        return id;
    }

    public int getIdComp() {
        return idComp;
    }

    public boolean getIsFree(){
        return isFree;
    }
    /***/

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    
    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }
    /***/

    /*Metodo toString*/
    public String toString(){
        return "ID: " + this.getId() + ", ID_Comp: " + idComp + ", IsFree: " + isFree;
    }
}

public class Vagoes {
    private int idVagoes;
    private double carga;
    private int composicaoTrem; //id da composicao que o vagao esta alocado
    private boolean isLivre;
    
    


    //construtor, ele cria com um id e com uma carga.
    public Vagoes(int id, double carga) {
        this.idVagoes = id;
        this.carga = carga;
        isLivre = true;
    }


    //getter e setters

    public int getId() {
        return idVagoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double cargaNova) {
        carga = cargaNova;
    }

    public void setIsLivre(boolean estado){
        isLivre = estado;
    }


    //tooString
    @Override
    public String toString() {
        return "Vagao [ID: " + idVagoes + ", Carga: " + carga + "Esta livre?: "+ isLivre + "]";
    }
}

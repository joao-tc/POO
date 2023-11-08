package main;

import auxi.Carro;

public class Vagao extends Carro {

    /*Declaracao de variaveis*/
        private double pesoMax;
    
    /*Metodo construtor*/
    public Vagao(int id, double pesoMax) {
        this.id = id;
        this.pesoMax = pesoMax;
    }

    /*Getter*/
    public double getPesoMax() {
        return pesoMax;
    }

}

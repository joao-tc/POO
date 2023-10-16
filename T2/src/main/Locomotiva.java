package main;

import auxi.Carro;

public class Locomotiva extends Carro {
    
    /*Declaracao de variaveis*/
        private double capacidadeMax;

    /*Metodo construtor*/
    public Locomotiva(int id, double capacidadeMax) {
        this.id = id;
        this.capacidadeMax = capacidadeMax;
    }

    /*Getter*/
    public double getCapacidadeMax() {
        return capacidadeMax;
    }
    
}

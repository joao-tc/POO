package garagem;

import java.util.ArrayList;

import auxi.Carro;
import main.Vagao;

public class GaragemVagao { // Cria e armazena objetos do tipo Vagao
    
    public static ArrayList<Carro> vagoes;

    public static void initVagao() {
        vagoes = new ArrayList<>() {
            {
                add(new Vagao());
                add(new Vagao());
                add(new Vagao());
                add(new Vagao());
                add(new Vagao());
                add(new Vagao());
            }
        };

        for(int i = 0; i < vagoes.size(); i++) {
            vagoes.get(i).setId(i);
        }
    }
}

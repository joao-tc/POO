package garagem;

import java.util.ArrayList;

import auxi.Carro;
import main.Locomotiva;

public class GaragemLocomotiva { // Cria e armazena objetos do tipo Locomotiva
    
    public static ArrayList<Carro> locomotivas;

    public static void initLocomotiva() {
        locomotivas = new ArrayList<>() {
            {
                add(new Locomotiva());
                add(new Locomotiva());
                add(new Locomotiva());
                add(new Locomotiva());
            }
        };

        for(int i = 0; i < locomotivas.size(); i++) {
            locomotivas.get(i).setId(i);
        }
    
    }
}

package main;

import java.util.ArrayList;

import auxi.Carro;
import auxi.Leitor;
import auxi.Stack;

import swing.Menu;

public class Main {

    /*Declaracao de variaveis*/

        // Variaveis de controle das composicoes
        public static Stack[] composicoes;
        private static int nComposicoes = 0;
        public static int editIdComp = -1;

        // Garagens
        private static Garagem<Locomotiva> locomotivas;
        private static Garagem<Vagao> vagoes;

    /*Main*/
    public static void main(String[] args) {
        Menu.start();

        composicoes = new Stack[10];
        locomotivas = new Garagem<Locomotiva>();
        vagoes = new Garagem<Vagao>();
        initGaragem();
        initComposicoes();
    }

    /*Display info*/
    public static String printLocomotivas() {
        String asd = "";
        for(int i = 0; i < locomotivas.size(); i++) {
            asd = asd + locomotivas.get(i) + "\n";
        }
        return asd;
    }

    public static String printVagoes() {
        String asd ="";
        for(int i = 0; i < vagoes.size(); i++) {
            asd = asd + vagoes.get(i) + "\n";
        }
        return asd;
    }

    public static String printComposicoes() {
        String asd = "";
        if(nComposicoes > 0) {

            for(int i = 0; i < nComposicoes; i++) {
                if(composicoes[i] == null)
                    continue;
                asd = asd + composicoes[i] + "\n";
            }
        } else {
            asd = "Nenhuma composição listada";
        }

        return asd;
    }
    
    /***/

    /*Retorna a primeira posicao livre na lista de composicoes*/
    public static int firstFree(){
        for(int i = 0; i < composicoes.length; i++) {
            if(composicoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int firstLocFree() {
        for(int i = 0; i < locomotivas.size(); i++) {
            if(locomotivas.get(i).getIsFree() == true) {
                return i;
            }
        }
        return -1;
    }

    /*Inicia nova composicao*/
    public static void startComp(int id) {
        composicoes[editIdComp] = new Stack(editIdComp);
        composicoes[editIdComp].push(locomotivas.get(id));
        nComposicoes++;
    }

    /*Edita composicao selecionada*/
    public static void editComp(int idComp, int tipo, int id){

        Carro currCarro;

        if(tipo == 0) {
            currCarro = locomotivas.get(id);
        } else {
            currCarro = vagoes.get(id);
        }

        composicoes[idComp].push(currCarro);
        
    }

    /*Remove composicao selecionada e libera os carros*/
    private static void removeComp(int idComp) {
        for(int i = 0; i < composicoes[idComp].getLen(); i++) {
            composicoes[idComp].pop();
        }
        nComposicoes--;
        composicoes[idComp] = null;

        //menu();
    }

    /*Cria garagens com classe generica*/
    private static void initGaragem() {
        ArrayList<String> aux = new ArrayList<String>();
        aux = Leitor.readFile(aux, "Garagem.txt");
        if(aux == null) {
            System.out.println("Erro ao ler arquivo! (Garagem)");
            return;
        }

        for(int i = 0; i < aux.size(); i+=3) {
            int tipo = Integer.parseInt(aux.get(i));
            int id = Integer.parseInt(aux.get(i+1));
            double carga = Double.parseDouble(aux.get(i+2));

            if(tipo == 1) {
                locomotivas.push(new Locomotiva(id, carga));
            } else {
                vagoes.push(new Vagao(id, carga));
            }
        }
    }

    /*Cria composicoes baseadas no arquivo de texto*/
    private static void initComposicoes() {
        ArrayList<String> data = new ArrayList<String>();
        data = Leitor.readFile(data, "Composicoes.txt");
        int comp = -1;
        int index = 0;

        for(int i = 0; i < data.size(); i+=3) {
            int currIdComp = Integer.parseInt(data.get(i));
            if(currIdComp != comp) {
                nComposicoes++;
                comp = currIdComp;
                index = firstFree();
                composicoes[index] = new Stack(index);
            }

            int tipo = Integer.parseInt(data.get(i+1));
            int currId = Integer.parseInt(data.get(i+2));

            if(tipo == 1) {
                composicoes[index].push(locomotivas.get(currId));
            } else {
                composicoes[index].push(vagoes.get(currId));
            }

        }

    }
}

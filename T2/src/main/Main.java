package main;

import java.util.ArrayList;
import java.util.Scanner;

import auxi.Leitor;
import auxi.Stack;

public class Main {

    /*Declaracao de variaveis*/
        // Scanner
        private static Scanner in = new Scanner(System.in);

        // Variaveis de controle das composicoes
        private static Stack[] composicoes;
        private static int nComposicoes = 0;

        // Garagens
        private static Garagem<Locomotiva> locomotivas;
        private static Garagem<Vagao> vagoes;

    /*Main*/
    public static void main(String[] args) {
        composicoes = new Stack[10];
        locomotivas = new Garagem<Locomotiva>();
        vagoes = new Garagem<Vagao>();
        initGaragem();
        initComposicoes();

        menu();
    }

    /*Metodo menu*/
    public static void menu() {

        // Limpa o console e mostra opcoes ao usuario
        limpa();
        System.out.println("[1]Criar novo trem\n[2]Listar trens existentes\n[3]Encerrar");
        int x = in.nextInt();
        int y;
        int index;

        switch(x) {
            case 1: // Criar nova composicao
                index = firstFree();
                composicoes[index] = new Stack(index);
                limpa();
                System.out.println("Escolha uma locomotiva livre para iniciar a nova combinação:");
                printLocomotivas();
                y = in.nextInt();
                composicoes[index].push(locomotivas.get(y));
                nComposicoes++;
                editComp(index);
                break;

            case 2: // Ver e modificar combinacoes ja existentes
                limpa();
                printComposicoes();

                System.out.println("\nSelecione uma composição para edita-la (-1 para retornar ao menu):");
                y = in.nextInt();
                index = y;

                if(y == -1) {
                    menu();
                } else {
                    System.out.println(composicoes[y].toString());
                    System.out.println("\n[1]Editar composição\n[2]Desfazer composição\n[3]Retornar ao menu");
                    y = in.nextInt();

                    switch(y) {
                        case 1:
                            editComp(index);
                            break;

                        case 2:
                            removeComp(index);
                            break;

                        case 3:
                            menu();
                    }
                }
                break;

            case 3:
                System.exit(1);
            
            default: menu();
        }
    }
    
    /*Metodo para limpar o console*/
    public static void limpa() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("=====|Sistema Ferroviario|=====");
    }


    /*Display info*/
    public static void printLocomotivas() {
        for(int i = 0; i < locomotivas.size(); i++) {
            System.out.println(locomotivas.get(i).toString());
        }
    }

    public static void printVagoes() {
        for(int i = 0; i < vagoes.size(); i++) {
            System.out.println(vagoes.get(i).toString());
        }
    }

    public static void printComposicoes() {
        if(nComposicoes > 0) {
            for(int i = 0; i < nComposicoes; i++) {
                if(composicoes[i] == null)
                    continue;
                System.out.println(composicoes[i].toString());
            }
        } else {
            System.out.println("Nenhuma composição listada");
            System.out.print("Retornando ao menu em ");
            int count = 3;
            while(count > 0) {
                try {
                    System.out.print(count);
                    Thread.sleep(333);
                    System.out.print(".");
                    Thread.sleep(333);
                    System.out.print(".");
                    Thread.sleep(333);
                    System.out.print(".");
                }
                catch(Exception e) {menu();}
                count -= 1;
            }
            menu();
        }
    }
    /***/

    /*Retorna a primeira posicao livre na lista de composicoes*/
    private static int firstFree(){
        for(int i = 0; i < composicoes.length; i++) {
            if(composicoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /*Edita composicao selecionada*/
    private static void editComp(int idComp){

        int index = idComp;

        while(true) {
            limpa();
            System.out.println("Composição atual:");
            System.out.println(composicoes[index].toString());
            System.out.println("\n[1]Adicionar Locomotiva\n[2]Adicionar Vagão\n[3]Retornar ao menu");
            int x = in.nextInt();
            int y;
            
            switch(x) {
                case 1:
                    System.out.println("\nSelecione a locomotiva:");
                    printLocomotivas();
                    y = in.nextInt();
                    composicoes[index].push(locomotivas.get(y));
                    break;

                case 2:
                    System.out.println("\nSelecione o vagão:");
                    printVagoes();
                    y = in.nextInt();
                    composicoes[index].push(vagoes.get(y));
                    break;

                case 3:
                    menu();
            }
        }
    }

    /*Remove composicao selecionada e libera os carros*/
    private static void removeComp(int idComp) {
        for(int i = 0; i < composicoes[idComp].getLen(); i++) {
            composicoes[idComp].pop();
        }
        nComposicoes--;
        composicoes[idComp] = null;

        menu();
    }

    /*Cria garagens com classe generica*/
    private static void initGaragem() {
        ArrayList<String> aux = new ArrayList<String>();
        Leitor.readFile(aux, "Garagem.txt");

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
        Leitor.readFile(data, "Composicoes.txt");
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

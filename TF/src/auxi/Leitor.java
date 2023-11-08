package auxi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Leitor { // Classe dedicada a realizar a leitura de arquivos de texto

    /*Declaracao de variaveis*/
        private static Scanner file;
        private static String[] aux;

    /*Metodo responsavel por ler arquivos*/
    public static ArrayList<String> readFile(ArrayList<String> lista, String path) { // Le informacoes de um arquivo e adiciona na lista passada como parametro

        try {
            file = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while(file.hasNextLine()) {
            String line = file.nextLine();
            aux = line.split(";");
            lista.add(aux[0]);
            lista.add(aux[1]);

            try {
                if(aux[2] != null) {
                lista.add(aux[2]);
            }
            } catch(Exception e) {}
        }

        return lista;
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas(200);
        GaragemVagoes garagemVagoes = new GaragemVagoes(1000);
        GaragemTrem garagemTrem = new GaragemTrem();
    }
}































/* 
        for(int i=0; i<100 ; i++){
            Locomotivas locomotivas = new Locomotivas(i+1, 100);
            garagemLocomotivas.addLocomotiva(locomotivas);
            System.out.println("\n"+ garagemLocomotivas.toString());
        }

        for(Locomotivas locomotiva : garagemLocomotivas.garagemLocomotivas){
            if(locomotiva !=null){
                System.out.println("\n" +"\n"+ locomotiva.toString());
            
            }
        }

 
        for(Locomotivas locomotivas : garagemLocomotivas.garagemLocomotivas){
            if(locomotivas!= null){
                System.out.println("\n"+"\n"+locomotivas.toString());
            }
        }


        for(int i=0; i<900; i++){
            Vagoes vagoes = new Vagoes(i+1, 200);
            garagemVagoes.addVagão(vagoes);
        }

for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n " + "\n" + vagao.toString());
            }
        }


        for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println(vagao.toString());
            }
        }
     
        for(int i=0; i<=0; i++ ){
            Composicao trem = new Composicao(i+1);
            for(int j=0; j<3; j++){
                trem.addLocomotiva(garagemLocomotivas.removerLocomotivas());
            }

            for(int j=0; j<80; j++){
                trem.addVagoes(garagemVagoes.removerVagao());
            }

            garagemTrem.addTrem(trem);
        }


        
        System.out.println("\n" + "\n" + "Funcionando"+ garagemTrem.listarComposicaos());
        System.out.println("FIM");
             

         

        

         System.out.println("\n"+"\n" + trem.toString());
        System.out.println("\n" + trem.getQtdVagoes());

         for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n"+"\n"+vagao.toString());
            }
        }


        for (int i=0; i<20; i++){

            garagemVagoes.addVagão(trem.rVagoes());
        }



       

      for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n"+"\n"+vagao.toString());
            }
        }
      











 */ 
    



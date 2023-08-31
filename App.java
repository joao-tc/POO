public class App {
    public static void main(String[] args) {
        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas(5);
        GaragemVagoes garagemVagoes = new GaragemVagoes(90);

        for(int i=0; i<5 ; i++){
            Locomotivas locomotivas = new Locomotivas(i+1, 100);
            garagemLocomotivas.addLocomotiva(locomotivas);
        }

/* 
        for(Locomotivas locomotivas : garagemLocomotivas.garagemLocomotivas){
            if(locomotivas!= null){
                System.out.println("\n"+"\n"+locomotivas.toString());
            }
        }
*/

        for(int i=0; i<90; i++){
            Vagoes vagoes = new Vagoes(i+1, 200);
            garagemVagoes.addVagão(vagoes);
        }

for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n " + "\n" + vagao.toString());
            }
        }

/* 
        for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println(vagao.toString());
            }
        }
*/        
        Composicao trem = new Composicao(1);
        for(int i=0; i<=1; i++){
            trem.addLocomotiva(garagemLocomotivas.removerLocomotivas());
        }     

        System.out.println(trem.getQtdLocomotivas());

        for(int i=0; i<80; i++){
            
            trem.addVagoes(garagemVagoes.removerVagao());
        }


        System.out.println("\n"+"\n" + trem.toString());
        System.out.println("\n" + trem.getQtdVagoes());

      for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println(vagao.toString());
            }
        }
      













        // Criar um objeto Vagoes usando o construtor
        //Vagoes vagao = new Vagoes(1, 1500.0);

        // Imprimir informações do vagão usando o método toString()
       // System.out.println(vagao.toString());

        // Ou você pode usar apenas o nome do objeto para imprimir, já que o método toString() é chamado automaticamente
        //System.out.println(vagao);
    
    }
}


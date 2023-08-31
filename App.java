public class App {
    public static void main(String[] args) {
        // Criar um objeto Vagoes usando o construtor
        Vagoes vagao = new Vagoes(1, 1500.0);

        // Imprimir informações do vagão usando o método toString()
       // System.out.println(vagao.toString());

        // Ou você pode usar apenas o nome do objeto para imprimir, já que o método toString() é chamado automaticamente
        System.out.println(vagao);
    }
}


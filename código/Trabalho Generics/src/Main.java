public class Main {
    public static void main(String[] args) {
        Deposito depositoDeEletronicos = new Deposito();

        depositoDeEletronicos.adicionarItem(new Eletronico("Smartphone"));
        depositoDeEletronicos.adicionarItem(new Eletronico("Notebook"));

        // O erro acontece aqui! Um alimento foi adicionado por engano.
        depositoDeEletronicos.adicionarItem(new Alimento("Maçã"));

        // O erro só será descoberto em tempo de execução, ao tentar usar o item.
        Eletronico primeiroItem = (Eletronico) depositoDeEletronicos.obterItem(0); // OK
        System.out.println("Item recuperado: " + primeiroItem);

        // Isso vai quebrar o programa! (java.lang.ClassCastException)
        Eletronico itemProblematico = (Eletronico) depositoDeEletronicos.obterItem(2);
        System.out.println("Item recuperado: " + itemProblematico);
    }
}

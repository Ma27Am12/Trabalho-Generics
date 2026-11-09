public class Main {
    public static void main(String[] args) {
        Deposito<Eletronico> depositoDeEletronicos = new Deposito<>();

        depositoDeEletronicos.adicionarItem(new Eletronico("Smartphone"));
        depositoDeEletronicos.adicionarItem(new Eletronico("Notebook"));

        // O erro acontece aqui! Um alimento foi adicionado por engano.
        Deposito<Alimento> depositoDeAlimentos = new Deposito<>();
        depositoDeAlimentos.adicionarItem(new Alimento("Maçã"));

        /* -- codigo incorreto, ignorar --
        // O erro só será descoberto em tempo de execução, ao tentar usar o item.
        //Eletronico primeiroItem = (Eletronico) depositoDeEletronicos.obterItem(0); // OK
        //System.out.println("Item recuperado: " + primeiroItem);
        */

        depositoDeEletronicos.obterItem(0).ifPresent(
                item -> System.out.println("Item recuperado: " + item));

        /* -- incorreto, ignorar --
        // Isso vai quebrar o programa! (java.lang.ClassCastException)
        //Eletronico itemProblematico = (Eletronico) depositoDeEletronicos.obterItem(2);
        //System.out.println("Item recuperado: " + itemProblematico);
        */

        try {
            Eletronico item = depositoDeEletronicos.obterItem(2)
                    .orElseThrow(() -> new IllegalArgumentException("Nenhum item encontrado."));
            System.out.println("Item recuperado: " + item);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

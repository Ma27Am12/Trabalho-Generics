public class Main {

    public static void main(String[] args) {

        Deposito<Eletronico> depositoDeEletronicos = new Deposito<>();

        depositoDeEletronicos.adicionarItem(
                new Eletronico("Smartphone"));
        depositoDeEletronicos.adicionarItem(
                new Eletronico("Notebook"));


        Deposito<Alimento> depositoDeAlimentos =
                new Deposito<>();

        depositoDeAlimentos.adicionarItem(
                new Alimento("Maçã"));


        // Teste do Optional
        depositoDeEletronicos.obterItem(0).ifPresent(
                item -> System.out.println(
                        "Item recuperado: " + item));

        try {
            Eletronico item =
                    depositoDeEletronicos.obterItem(2)
                            .orElseThrow(() ->
                                    new IllegalArgumentException(
                                            "Nenhum item encontrado."));

            System.out.println(
                    "Item recuperado: " + item);

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Erro: " + e.getMessage());
        }

        depositoDeEletronicos
                .buscarPorNome("Notebook")
                .ifPresent(item ->
                        System.out.println(
                                "Item encontrado: "
                                        + item));


        System.out.println("\nConteúdo do depósito de eletrônicos:");
        GerenciadorDeposito.listarConteudo(
                depositoDeEletronicos);

        System.out.println("\nConteúdo do depósito de alimentos:");
        GerenciadorDeposito.listarConteudo(
                depositoDeAlimentos);

        
        Deposito<Produto> depositoGeral =
                new Deposito<>();

        GerenciadorDeposito.transferir(
                depositoDeEletronicos,
                depositoGeral);

        System.out.println(
                "\nConteúdo do depósito geral após transferência:");

        GerenciadorDeposito.listarConteudo(
                depositoGeral);
    }
}
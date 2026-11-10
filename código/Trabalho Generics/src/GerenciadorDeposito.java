public class GerenciadorDeposito {
    public static <T extends Produto> void transferir(Deposito<? extends T> origem, Deposito<? super  T> destino) {
        for (T item : origem.getItens()) {
            destino.adicionarItem(item);
        }
    }
    public static void listarConteudo(Deposito<?> deposito) {
        for (Object item: deposito.getItens()) {
            System.out.println(item);
        }
    }
}

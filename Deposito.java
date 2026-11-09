import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Deposito <T extends Produto> {
    private List<T> itens = new ArrayList(); // Usa List sem tipo!

    public void adicionarItem(T item) {
        itens.add(item);
    }

    public Optional<T> obterItem(int index) {
        if (index < 0 || index >=itens.size()) {
            return Optional.empty();
        }

        return Optional.of(itens.get(index));
    }

    public List<T> getItens() {
        return itens;
    }
}

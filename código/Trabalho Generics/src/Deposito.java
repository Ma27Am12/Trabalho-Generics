import java.util.ArrayList;
import java.util.List;

public class Deposito {
    private List itens = new ArrayList(); // Usa List sem tipo!

    public void adicionarItem(Object item) {
        this.itens.add(item);
    }

    public Object obterItem(int index) {
        return this.itens.get(index);
    }
}

import java.util.List;

public class InsertionSort implements AlgoritmoOrdenacao {

    @Override
    public void ordenar(List<Produto> produtos, String criterio) {
        for (int i = 1; i < produtos.size(); i++) {
            Produto x = produtos.get(i);
            int j = i - 1;

            while (j >= 0 && compara(produtos.get(j), x, criterio) > 0) {
                produtos.set(j + 1, produtos.get(j));
                j--;
            }

            produtos.set(j + 1, x);
        }
    }

    private int compara(Produto p1, Produto p2, String criterio) {
        if (criterio.equals(GeradorDeRelatorios.CRIT_DESC_CRESC)) {
            return p1.getDescricao().compareToIgnoreCase(p2.getDescricao());
        } else if (criterio.equals(GeradorDeRelatorios.CRIT_PRECO_CRESC)) {
            return Double.compare(p1.getPreco(), p2.getPreco());
        } else if (criterio.equals(GeradorDeRelatorios.CRIT_ESTOQUE_CRESC)) {
            return Integer.compare(p1.getQtdEstoque(), p2.getQtdEstoque());
        } else {
            throw new RuntimeException("Criterio inválido!");
        }
    }
}

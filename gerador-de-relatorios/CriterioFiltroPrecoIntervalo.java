public class CriterioFiltroPrecoIntervalo implements CriterioFiltragem {
    private double precoMinimo;
    private double precoMaximo;

    public CriterioFiltroPrecoIntervalo(double precoMinimo, double precoMaximo) {
        this.precoMinimo = precoMinimo;
        this.precoMaximo = precoMaximo;
    }

    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        double precoProduto = produto.getPreco();
        return precoProduto >= precoMinimo && precoProduto <= precoMaximo;
    }
}

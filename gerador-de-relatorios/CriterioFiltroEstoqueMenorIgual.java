
// Estratégia para o critério de filtragem "estoque_menor_igual"
class CriterioFiltroEstoqueMenorIgual implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return produto.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}
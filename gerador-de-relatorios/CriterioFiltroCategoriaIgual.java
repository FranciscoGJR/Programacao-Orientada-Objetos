
// Estratégia para o critério de filtragem "categoria_igual"
class CriterioFiltroCategoriaIgual implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return produto.getCategoria().equalsIgnoreCase(argFiltro);
    }
}
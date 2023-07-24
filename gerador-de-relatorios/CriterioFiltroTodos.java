
// Estratégia para o critério de filtragem "todos"
class CriterioFiltroTodos implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return true;
    }
}
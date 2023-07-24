
// Interface para o padrão Strategy - Critério de Filtragem
interface CriterioFiltragem {
    boolean selecionado(Produto produto, String argFiltro);
}
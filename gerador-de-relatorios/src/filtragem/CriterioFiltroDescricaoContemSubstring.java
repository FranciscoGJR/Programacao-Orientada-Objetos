package src.filtragem;
import src.model.Produto;

public class CriterioFiltroDescricaoContemSubstring implements CriterioFiltragem {
    private String substring;

    public CriterioFiltroDescricaoContemSubstring(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        String descricaoProduto = produto.getDescricao().toLowerCase();
        return descricaoProduto.contains(substring.toLowerCase());
    }
}

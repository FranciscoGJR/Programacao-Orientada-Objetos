package src.filtragem;

import src.model.Produto;

public class CriterioFiltroEstoqueMenorIgual implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return produto.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}
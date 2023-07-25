package src.filtragem;

import src.model.Produto;

public class CriterioFiltroCategoriaIgual implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return produto.getCategoria().equalsIgnoreCase(argFiltro);
    }
}
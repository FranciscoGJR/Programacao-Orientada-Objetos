package src.filtragem;

import src.model.Produto;

public class CriterioFiltroTodos implements CriterioFiltragem {
    @Override
    public boolean selecionado(Produto produto, String argFiltro) {
        return true;
    }
}
package src.filtragem;

// Interface para o padrão Strategy - Critério de Filtragem

import src.model.Produto;

public interface CriterioFiltragem {
    boolean selecionado(Produto produto, String argFiltro);
}
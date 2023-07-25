package src.algoritmo;

import java.util.List;

import src.model.Produto;

public interface AlgoritmoOrdenacao {
    void ordenar(List<Produto> produtos, String criterio);
}

/**
 * Classe usada para definição de estrutura de posições e movimentos do jogo
 */
public class Position {
    private int row;
    private int column;
    
    /**
     * Construtor que define o valor da Linha e da Coluna da posição, baseado no plano cartesiano
     * @param row Linha
     * @param column Coluna
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Método que devolve o valor do eixo X da posição
     * @return Um valor int representando o eixo X
     */
    public int getRow() {
        return row;
    }

    /**
     * Método que devolve o valor do eixo Y da posição
     * @return Um valor int representando o eixo Y
     */
    public int getCol() {
        return column;
    }
}

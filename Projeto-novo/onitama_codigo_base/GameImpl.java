public class GameImpl implements Game {

    private Color[][] board;
    private Piece[][] pieces;
    private Card tableCard;
    private Player redPlayer;
    private Player bluePlayer;

    public GameImpl() {
        // Inicialize o tabuleiro, as peças e outros componentes do jogo aqui
        

    }


    /**
     * Método que devolve a cor da posição do tabuleiro. Se possui uma cor, significa que é um templo. Caso contrário, é um espaço normal
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */
    @Override
    public Color getSpotColor(Position position) {

        return board[position.getRow()][position.getCol()];
    }


    /**
     * Método que devolve a peça que está na posição do tabuleiro
     * @param position Posição do tabuleiro
     * @return Um objeto Piece que representa a peça na posição indicada. Se não tiver peça, devolve null
     */
    @Override
    public Piece getPiece(Position position) {
        
        return pieces[position.getRow()][position.getCol()];
    }


    /**
     * Método que devolve a carta que está na mesa, que será substituída após a próxima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    @Override
    public Card getTableCard() {
        // Implemente a lógica para retornar a carta na mesa aqui
        return tableCard;
    }

    /**
     * Método que devolve a carta que está na mesa, que será substituída após a próxima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    @Override
    public Player getRedPlayer() {
        // Implemente a lógica para retornar o jogador vermelho aqui
        return redPlayer;
    }

    @Override
    public Player getBluePlayer() {
        // Implemente a lógica para retornar o jogador azul aqui
        return bluePlayer;
    }

    @Override
    public void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException {
        // Implemente a lógica para fazer um movimento aqui
    }

    @Override
    public boolean checkVictory(Color color) {
        // Implemente a lógica para verificar a vitória de um jogador aqui
        return false;
    }

    @Override
    public void printBoard() {
        // Implemente a lógica para imprimir o tabuleiro aqui
    }
}

public class GameImpl implements Game {

    private final static int sizeBoard = 5;
    
    public Spot[][] board;
    public Card[] deckGame;
    public Card tableCard;

    private Player redPlayer;
    private Player bluePlayer;
    private Player currentPlayer;
    private Player playerWinner;


    /**
   * Construtor padrão, sem parâmetro.
   * Inicia o tabuleiro e cria os players Red e Blue
   */
    public GameImpl() {

        // Inicializando o tabuleiro, as peças e outros componentes do jogo aqui
        this.board = new Spot[sizeBoard][sizeBoard]; 
        creadBoard();
        
        // Inicializando deck
        this.deckGame = Card.createCards();

        // Inicializando jogadores
        this.redPlayer = new Player("RED Player", Color.RED, deckGame[0], deckGame[1]);
        this.bluePlayer = new Player("BLUE Player", Color.BLUE, deckGame[2], deckGame[3]);
        this.tableCard = deckGame[4];
        this.playerWinner = null;
        
        // current Player
        if(tableCard.getColor() == Color.BLUE){
            currentPlayer = bluePlayer;
        } else{
            currentPlayer = redPlayer;
        }
    }


    /**
   * Um construtor que recebe duas Strings como parâmetro, representando os nomes dos
   * jogadores de Peças Vermelhas e Azuis, respectivamente
   */
    public GameImpl(String playerRED, String playerBLUE) {

        // Inicializando o tabuleiro, as peças e outros componentes do jogo aqui
        this.board = new Spot[sizeBoard][sizeBoard]; 
        creadBoard();
        
        // Inicializando deck
        this.deckGame = Card.createCards();

        // Inicializando jogadores
        this.redPlayer = new Player(playerRED, Color.RED, deckGame[0], deckGame[1]);
        this.bluePlayer = new Player(playerBLUE, Color.BLUE, deckGame[2], deckGame[3]);
        this.tableCard = deckGame[4];
        this.playerWinner = null;

        // current Player
        if(tableCard.getColor() == Color.BLUE){
            currentPlayer = bluePlayer;
        } else{
            currentPlayer = redPlayer;
        }
    }


    /**
   * Um construtor que recebe duas Strings como parâmetro, representando os nomes do
    *jogador de Peças Vermelhas e Azuis, respectivamente. Adicionalmente, o construtor
    * deve receber também um Array de Cards. Este Array de Cards terá um Deck totalmente
    * novo, com cartas que não estão nesse enunciado. Sua implementação deve selecionar 5
    * cartas aleatórias desse novo deck passado como parâmetro do construtor, ao invés de
    * usar o deck criado no método createCards().
   *
   * @param redPlayerName  O nome do jogador de peças vermelhas.
   * @param bluePlayerName O nome do jogador de peças azuis.
   * @param customDeck     O cartas personalizadas
   */
  public GameImpl(String redPlayerName, String bluePlayerName, Card[] customDeck) {
        // Inicializando o tabuleiro, as peças e outros componentes do jogo aqui
    this.board = new Spot[sizeBoard][sizeBoard]; 
    creadBoard();
    
    this.deckGame = Card.pickGameCards(customDeck);
    this.redPlayer = new Player(redPlayerName, Color.RED, deckGame[0], deckGame[1]);
    this.bluePlayer = new Player(bluePlayerName, Color.BLUE, deckGame[2], deckGame[3]);
    this.tableCard = deckGame[4];
    this.playerWinner = null;

        // current Player
    if(tableCard.getColor() == Color.BLUE){
        currentPlayer = bluePlayer;
    } else{
        currentPlayer = redPlayer;
    }

    this.playerWinner = null;
  }
        

    /**
     * Método que devolve a cor da posição do tabuleiro. Se possui uma cor, significa que é um templo. Caso contrário, é um espaço normal
     * @param position Posição do tabuleiro
     * @return O enum Color que representa a cor da posição
     */
    @Override
    public Color getSpotColor(Position position) {

        return board[position.getRow()][position.getCol()].getColor();
    }


    /**
     * Método que devolve a peça que está na posição do tabuleiro
     * @param position Posição do tabuleiro
     * @return Um objeto Piece que representa a peça na posição indicada. Se não tiver peça, devolve null
     */
    @Override
    public Piece getPiece(Position position) {
        
        return board[position.getRow()][position.getCol()].getPiece();
    }


    /**
     * Método que devolve a carta que está na mesa, que será substituída após a próxima jogada
     * @return Um objeto Card que representa a carta na mesa
     */
    @Override
    public Card getTableCard() {
        // Implemente a lógica para retornar a carta na mesa aqui
        return null;
    }

      private Spot getSpot(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        if (row >= 0 && row < 5 && col >= 0 && col < 5) {
        return board[row][col];
        }
        return null;
    }


   /**
   * Determina a carta que está na mesa
   * @param tableCard Carta da mesa
   */
  public void setTableCard(Card tableCard) {
    this.tableCard = tableCard;
  }


    /**
     * Método que devolve as informações sobre o jogador com as peças vermelhas
     * @return Um objeto Player que representa o jogador vermelho
     */
    @Override
    public Player getRedPlayer() {

        return redPlayer;
    }


    /**
     * Método que devolve as informações sobre o jogador com as peças azuis
     * @return Um objeto Player que representa o jogador azul
     */
    @Override
    public Player getBluePlayer() {
        
        return bluePlayer;
    }

    /**
     * Método que devolve o jogador atual
     * @return Um objeto Player que representa o jogador azul
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    /**
     * Método que move uma peça
     * @param card A carta de movimento que será usada
     * @param cardMove A posição da carta para onde a peça irá se mover
     * @param currentPos Posição atual da peça
     * @exception IncorrectTurnOrderException Caso não seja a vez de um jogador fazer um movimento
     * @exception IllegalMovementException Caso uma peça seja movida para fora do tabuleiro ou para uma posição onde já tem uma peça da mesma cor
     * @exception InvalidCardException Caso uma carta que não está na mão do jogador seja usada
     * @exception InvalidPieceException Caso uma peça que não está no tabuleiro seja usada
     */
    @Override
    public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
        
        Piece piece = getPiece(currentPos);
        Player currentPlayer = getCurrentPlayer();
        if (piece == null) {
        throw new InvalidPieceException("The selected position does not contain a piece.");
        }

        if (currentPlayer.getPieceColor() != piece.getColor()) {
        throw new IncorrectTurnOrderException("It is not the turn of player " + piece.getColor() + " to make a move.");
        }

        Position destinationPos = new Position(currentPos.getRow() + cardMove.getRow(),
        currentPos.getCol() + cardMove.getCol());
        Spot destinationSpot = getSpot(destinationPos);
        if (destinationSpot == null) 
          throw new IllegalMovementException("The destination position is outside the board.");
    

        // Mover peça para o local de destino
        Spot currentSpot = board[currentPos.getRow()][currentPos.getCol()];
        destinationSpot.occupySpot(piece);
        currentSpot.releaseSpot();

        // trocar as cartas do jogador
        currentPlayer.swapCard(card, tableCard);
        setTableCard(card);
            
    }


    /**
     * Método que confere se um jogador de uma determinada cor venceu o jogo. Critérios de vitória:
     * — Derrotou a peça de mestre adversária
     * — Posicionou o seu mestre na posição da base adversária
     * @param color Cor das peças do jogador que confere a condição de vitória
     * @return Um booleano true para caso esteja em condições de vencer e false caso contrário
     
    @Override
    public boolean checkVictory(Color color) {
        // caso 1: Derrotou a peça de mestre adversária
        // caso 2: Posicionou o seu mestre na posição da base adversária

        Piece aux = board[0][2].getPiece();

        // mestre RED no templo BLUE
        if(aux.isMaster && aux.getColor() == Color.RED)
            return true;
            
        aux = board[4][2].getPiece();

        // mestre BLUE no templo RED
        if(aux.isMaster && aux.getColor() == Color.BLUE)
            return true;


        
        }
*/

    @Override
    public void printBoard() {
        // Implemente a lógica para imprimir o tabuleiro aqui
    }


    private void creadBoard(){

    /*
                 

    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){

            //definindo spot vazio
            board[i][j] = new Spot(new Position(i, j));

            // definindo time BLUE
            if(i == 0)
                board[i][j] = new Spot(new Piece(Color.BLUE, false), new Position(i, j));

            // definindo time RED
            if(i == 4)
                board[i][j] = new Spot(new Piece(Color.RED, false), new Position(i, j));

        }
    }
    
    //definindo mestres
    board[0][2] = new Spot(new Piece(Color.BLUE, true), new Position(0, 2), Color.BLUE);
    board[4][2] = new Spot(new Piece(Color.RED, true), new Position(4, 2), Color.RED);

    */

    }


    @Override
    public boolean checkVictory(Color color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkVictory'");
    }   

}
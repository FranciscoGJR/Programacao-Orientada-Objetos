public class main{

    public static void main(String[] args) {
        
        // teste classe Positionn
        Position position = new Position(1, 1);

        System.out.println("Posicao col: " + position.getCol());
        System.out.println("Posicao row: " + position.getRow());
        

        // teste classe Piece
        Piece piece = new Piece(Color.RED, false);

        System.out.println(piece.getColor());
        System.out.println(piece.isMaster());
        System.out.println(piece.isAlive());

        // teste classe Card
        Position[] positions = new Position[3];

        positions[0] = new Position(0, 0);
        positions[1] = new Position(1, 2);
        positions[2] = new Position(2, 1);
        
        Card card = new Card("Carta a", Color.BLUE, positions);
        System.out.println(card.getColor());
        System.out.println(card.getName());
        System.out.println(card.getPositions());

        
        // teste classe Player
        Player player = new Player("Carlos", Color.BLUE, null);
        System.out.println(player.getName());
        System.out.println(player.getPieceColor());
        System.out.println(player.getCards());

        // teste classe Color
        Color color = Color.RED;
        System.out.println(color);

        // teste classe Spot
        Spot spot = new Spot(position);
        System.out.println(spot.getColor());
        System.out.println(spot.getPiece());
        System.out.println(spot.getPosition());

        // teste classe GameImpl
        GameImpl game = new Game
        
        
    }
        
}
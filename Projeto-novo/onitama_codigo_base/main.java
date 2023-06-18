public class main{

    public static void main(String[] args) {
        System.out.println("INICIO DO JOGO");
        
        // GameImpl
        GameImpl game = new GameImpl();
        
        System.out.println(game.getPiece(new Position(0, 2)));

        System.out.println("FIM DO JOGO");

    }
        
}
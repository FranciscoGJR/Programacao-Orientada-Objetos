public class main{

    public static void main(String[] args) {
        System.out.println("INICIO DO JOGO");
        
        // GameImpl
        GameImpl game = new GameImpl();
        System.out.println(game.board[0][1].piece.getColor());
        System.out.println("FIM DO JOGO");

    }
        
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Classe que contém informações das cartas
 */
public class Card {

    private String name;
    private Color color;
    private Position[] positions;

    /**
     * Construtor que define os principais atributos de uma carta
     * @param name Nome da carta
     * @param color Cor da carta
     * @param positions Todas as posições relativas de movimento
     */
    public Card(String name, Color color, Position[] positions) {
        this.name = name;
        this.color = color;
        this.positions = positions;

    }

    /**
     * Método que devolve o nome da carta
     * @return String que contém o nome da carta
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devolve a cor da carta
     * @return Enum Color que contém a cor da carta
     */
    public Color getColor() {
        return color;
    }

    /**
     * Método que devolve todas as possíveis posições relativas de movimento.
     * A posição atual da peça é o ponto de origem (0,0). Uma carta possui as possíveis posições de movimento em relação ao ponto de origem.
     * @return Um array de Position contendo todas as possíveis posições de movimento em relação ao ponto de origem
     */
    public Position[] getPositions() {
        return positions;
    }

    /**
     * Método que cria todas as cartas do jogo, embaralha-as e devolve as 5 que serão utilizadas na partida.
     * @return Vetor de cartas com todas as cartas do jogo
     */
    public static Card[] createCards() {

        Card[] allCardsGame = createAllCards();
        shuffleCards(allCardsGame);

        Card[] cardsGame = {
            allCardsGame[0],
            allCardsGame[1],
            allCardsGame[2],
            allCardsGame[3],
            allCardsGame[4]
        };

        return cardsGame;
    }

    public static Card[] pickGameCards(Card[] deck) {
        Random random = new Random();
        Card[] selectedCards = new Card[5];

        for (int i = 0; i < 5; i++) {
        int randomIndex = random.nextInt(deck.length);
        selectedCards[i] = deck[randomIndex];
        }

        return selectedCards;
  }
    

    /**
     * Método que cria todas as cartas do jogo
     * @return Vetor de cartas com todas as cartas do jogo
     */ 
    private static Card[] createAllCards(){
        Card[] cardsGame = new Card[8];

        // position Tiger
        Position[] positionTiger = {
            new Position(1, 0),
            new Position(-2, 0)
        };
        
        // Card Tiger
        Card cardTiger = new Card("Tiger", Color.BLUE, positionTiger);
        cardsGame[0] = cardTiger;
        

        // position Dragon
        Position[] positionDragon = {
            new Position(-1, -2),
            new Position(-1, 2),
            new Position(1, -1),
            new Position(1, 1)   
        };
        
        // Card Dragon
        Card cardDragon = new Card("Dragon", Color.RED, positionDragon);
        cardsGame[1] = cardDragon;


        // position Frog
        Position[] positionFrog = {
            new Position(0, -2),
            new Position(-1, -1),
            new Position(1, 1)
        };
        
        // Card Frog
        Card cardFrog = new Card("Frog", Color.RED, positionFrog);
        cardsGame[2] = cardFrog;


        // position Rabbit
        Position[] positionRabbit = {
            new Position(1, -1),
            new Position(-1, 1),
            new Position(0, 2)
        };
        
        // Card Rabbit
        Card cardRabbit = new Card("Rabbit", Color.BLUE, positionRabbit);
        cardsGame[3] = cardRabbit;


        // position Crab
        Position[] positionCrab = {
            new Position(0, -2),
            new Position(0, 2),
            new Position(-1, 0)
        };
        
        // Card Crab
        Card cardCrab = new Card("Crab", Color.BLUE, positionCrab);
        cardsGame[4] = cardCrab;        

    
        // position Elephant
        Position[] positionElephant = {
            new Position(0, -1),
            new Position(-1, -1),
            new Position(0, 1),
            new Position(1, 1)
        };
        
        // Card Elephant
        Card cardElephant = new Card("Elephant", Color.RED, positionElephant);
        cardsGame[5] = cardElephant;


        // position Goose
        Position[] positionGoose = {
            new Position(1, -1),
            new Position(0, -1),
            new Position(0, 1),
            new Position(1, 1)
        };
        
        // Card Goose
        Card cardGoose = new Card("Goose", Color.BLUE, positionGoose);
        cardsGame[6] = cardGoose;


        // position Rooster
        Position[] positionRooster = {
            new Position(1, -1),
            new Position(0, -1),
            new Position(0, 1),
            new Position(1, 1)
        };
        
        // Card Rooster
        Card cardRooster = new Card("Rooster", Color.RED, positionRooster);
        cardsGame[7] = cardRooster;

        return cardsGame;
    }


    /**
     * Método que embaralha as cartas do jogo
     * @param cardsGames Todas as cartas do jogo
     * @return Vetor de cartas com todas as cartas do jogo embaralhadas
     */
    public static Card[] shuffleCards(Card[] cardsGame) {
        // Converter o array em uma lista
        List<Card> cardList = new ArrayList<>(Arrays.asList(cardsGame));
        
        // Embaralhar a lista
        Collections.shuffle(cardList);
        
        // Converter a lista de volta para um array
        Card[] shuffledCards = cardList.toArray(new Card[cardList.size()]);
        
        return shuffledCards;
    }

}

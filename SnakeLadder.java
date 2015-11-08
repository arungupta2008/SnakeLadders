package SnakeLadders;

import SnakeLadders.exceptions.BoardSizeExceedsException;
import SnakeLadders.exceptions.EntityTypeNotFoundException;
import SnakeLadders.service.BoardServiceImpl;
import SnakeLadders.service.Entity;
import SnakeLadders.service.EntityService;
import SnakeLadders.service.Player;
import java.util.Scanner;

/**
 * Created by arun.gupta on 21/08/15.
 */
public class SnakeLadder {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter the Board size(M*N): ");
        final BoardServiceImpl boardService = new BoardServiceImpl();

        boardService.createBoard(scanner.nextInt(), scanner.nextInt());
        System.out.println(" Please enter the Count of entities are you adding : ");

        Integer entityCount = scanner.nextInt();

        int i = 0;
        try {
            while (i < entityCount) {
                System.out.println(" Entity " + (i + 1) + "\n" +
                        "1 for Snake\n" +
                        "2 for Ladder");
                EntityService entityService = new EntityService();
                try {
                    boardService.addEntityInBoard(entityService.createEntity(Entity.getEntityType(scanner.nextInt()), scanner.nextInt(), scanner.nextInt()));
                } catch (EntityTypeNotFoundException e) {
                    System.out.println(e.getMessage());
                    --i;
                } catch (BoardSizeExceedsException e) {
                    --i;
                    System.out.println(e.getMessage());
                }
                ++i;
            }

            String response = boardService.validateEntities();
            if (response == null) {
                System.out.println("Validation SuccessFul");
            } else {
                System.out.printf(response);
                System.exit(0);
            }

            System.out.print("How many Players You want to Play with :");

            boardService.createPlayers(scanner.nextInt());

            Player currentPlayer = boardService.getFirstPlayer();

            boolean shouldGoAheadWithNextPlayer = false;

            do {
                if (shouldGoAheadWithNextPlayer) {
                    currentPlayer = boardService.getNextPlayer(currentPlayer);
                }
                System.out.printf("Player " + (currentPlayer.getPlayerId() + 1) + "'s Chance, Last Location (" + currentPlayer.getPlayerLocation() + ")Please enter valid dice Value:");
                Integer diceValue = scanner.nextInt();
                if (boardService.isValidDiceValue(diceValue)) {
                    Integer location;
                    try {
                        location = boardService.updatePlayerLocation(currentPlayer.getPlayerId(), diceValue);
                    } catch (BoardSizeExceedsException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                        location = currentPlayer.getPlayerLocation();
                    }

                    System.out.println("Updated Player's current Location Location: " + location + "\n");
                    shouldGoAheadWithNextPlayer = true;

                } else {
                    System.out.println("Invalid Dice Input");
                    shouldGoAheadWithNextPlayer = false;
                }
            } while (!boardService.ifPlayerNotWon(currentPlayer));
            System.out.println("Player " + (currentPlayer.getPlayerId() + 1) + " Won!!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.printf(e.getMessage());
        }


    }
}

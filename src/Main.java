import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            String playerA = "";
            while (!playerA.equalsIgnoreCase("R") && !playerA.equalsIgnoreCase("P") && !playerA.equalsIgnoreCase("S")) {
                System.out.print("Player A, enter your move (R/P/S): ");
                playerA = scanner.nextLine();
                if (!playerA.equalsIgnoreCase("R") && !playerA.equalsIgnoreCase("P") && !playerA.equalsIgnoreCase("S")) {
                    System.out.println("Invalid move! Please enter R, P, or S.");
                }
            }

            String playerB = "";
            while (!playerB.equalsIgnoreCase("R") && !playerB.equalsIgnoreCase("P") && !playerB.equalsIgnoreCase("S")) {
                System.out.print("Player B, enter your move (R/P/S): ");
                playerB = scanner.nextLine();
                if (!playerB.equalsIgnoreCase("R") && !playerB.equalsIgnoreCase("P") && !playerB.equalsIgnoreCase("S")) {
                    System.out.println("Invalid move! Please enter R, P, or S.");
                }
            }

            if (playerA.equalsIgnoreCase(playerB)) {
                System.out.println(getMoveName(playerA) + " vs " + getMoveName(playerB) + " it's a Tie!");
            } else if ((playerA.equalsIgnoreCase("R") && playerB.equalsIgnoreCase("S")) ||
                    (playerA.equalsIgnoreCase("P") && playerB.equalsIgnoreCase("R")) ||
                    (playerA.equalsIgnoreCase("S") && playerB.equalsIgnoreCase("P"))) {
                System.out.println(getResultPhrase(playerA, playerB));
                System.out.println("Player A wins!");
            } else {
                System.out.println(getResultPhrase(playerB, playerA));
                System.out.println("Player B wins!");
            }

            System.out.print("Do you want to play again? (Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getMoveName(String move) {
        if (move.equalsIgnoreCase("R")) {
            return "Rock";
        } else if (move.equalsIgnoreCase("P")) {
            return "Paper";
        } else if (move.equalsIgnoreCase("S")) {
            return "Scissors";
        }
        return "";
    }

    private static String getResultPhrase(String winningMove, String losingMove) {
        if (winningMove.equalsIgnoreCase("R") && losingMove.equalsIgnoreCase("S")) {
            return "Rock breaks Scissors";
        } else if (winningMove.equalsIgnoreCase("P") && losingMove.equalsIgnoreCase("R")) {
            return "Paper covers Rock";
        } else if (winningMove.equalsIgnoreCase("S") && losingMove.equalsIgnoreCase("P")) {
            return "Scissors cuts Paper";
        }
        return "";
    }
}
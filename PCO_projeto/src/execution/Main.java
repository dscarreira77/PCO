package execution;
import java.util.Scanner;
import types.Table;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type 'play' to start the game:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("play")) {
			System.out.println("Welcome to the game!");
			System.out.println("Choose your Theme.");
			System.out.println("1 - animals");
			System.out.println("2 - emojis");
			System.out.println("3 - balls");
			int theme = scanner.nextInt();
			if (theme == 1) {
				System.out.println("You chose animals.");
				System.out.println("Choose THe number of bottles.");
				System.out.println("From 3 to how many you would like to play with.");
				int dificulty = scanner.nextInt();
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					System.out.println("Choose a final score.");
					int finalScore = scanner.nextInt();
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else if (mode == 2) {
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else {
					System.out.println("Invalid mode. Please choose a valid mode.");
				}
			}
			else if (theme == 2) {
				System.out.println("You chose emojis.");
				System.out.println("Choose THe number of bottles.");
				System.out.println("From 3 to how many you would like to play with.");
				int dificulty = scanner.nextInt();
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					System.out.println("Choose a final score.");
					int finalScore = scanner.nextInt();
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else if (mode == 2) {
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else {
					System.out.println("Invalid mode. Please choose a valid mode.");
				}
			}
			else if (theme == 3) {
				System.out.println("You chose balls.");
				System.out.println("Choose THe number of bottles.");
				System.out.println("From 3 to how many you would like to play with.");
				int dificulty = scanner.nextInt();
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					System.out.println("Choose a final score.");
					int finalScore = scanner.nextInt();
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else if (mode == 2) {
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose a number of plays.");
					int maxPlays = scanner.nextInt();
					Table table = new Table(dificulty);
					while (table.nrMoves < maxPlays) {
						table.addBootle(table.getNewBottle());
					}
					System.out.println(table.toString());
				}
				else {
					System.out.println("Invalid mode. Please choose a valid mode.");
				}
			}
			else {
				System.out.println("Invalid theme. Please choose a valid theme.");
			}
			

            
        } else {
            System.out.println("Invalid input. Please type 'play' to start the game.");
        }

        scanner.close();
    }
}
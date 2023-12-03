package execution;
import java.util.Scanner;

import java.util.Random;
import types.Filling;
import types.FinalScoringFillingGame;
import types.Animals;
import types.BettingFillingGame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		Random random = new Random();

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
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					FinalScoringFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					game = new FinalScoringFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
				}
				else if (mode == 2) {
					BettingFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					int score = 0;
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose the max number of plays.");
					int maxPlays = scanner.nextInt();
					game = new BettingFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize, score, bet, maxPlays);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
				}
				else {
					System.out.println("Invalid mode. Please choose a valid mode.");
				}
			}
			else if (theme == 2) {
				System.out.println("You chose emojis.");
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					FinalScoringFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					game = new FinalScoringFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
				}
				else if (mode == 2) {
					BettingFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					int score = 0;
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose the max number of plays.");
					int maxPlays = scanner.nextInt();
					game = new BettingFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize, score, bet, maxPlays);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
				}
				else {
					System.out.println("Invalid mode. Please choose a valid mode.");
				}
			}
			else if (theme == 3) {
				System.out.println("You chose balls.");
				System.out.println("Choose a mode.");
				System.out.println("1 - Final Score Mode");
				System.out.println("2 - Betting Mode");
				int mode = scanner.nextInt();
				if (mode == 1) {
					FinalScoringFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					game = new FinalScoringFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
				}
				else if (mode == 2) {
					BettingFillingGame game;
					Filling[] symbols = Animals.values();
					int numberOfUsedSymbols = 3;
					System.out.println("Choose a seed.");
					int seedUser = scanner.nextInt();
					int seed = random.nextInt(seedUser)+1;
					System.out.println("Choose a bottle size. 5 will be used by default.");
					int bootleSize = scanner.nextInt();
					if(bootleSize == 0) {
						bootleSize = 5;
					}
					int score = 0;
					System.out.println("Choose a bet.");
					int bet = scanner.nextInt();
					System.out.println("Choose the max number of plays.");
					int maxPlays = scanner.nextInt();
					game = new BettingFillingGame(symbols, numberOfUsedSymbols, seed, bootleSize, score, bet, maxPlays);
					while(!game.isRoundFinished()) {
						System.out.println("Insert the number of the bottle you want to pour from.");
						int bottlePourNumber = scanner.nextInt();
						System.out.println("Insert the number of the bottle you want to fill.");
						int bottleFillNumber = scanner.nextInt();
						game.play(bottlePourNumber, bottleFillNumber);
						System.out.println(game.toString());
					}
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

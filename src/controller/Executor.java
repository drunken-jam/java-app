package controller;
import java.util.HashMap;
import java.util.Random;
import model.Game;


public class Executor {

	private static final Integer FIRST_INTEGER = 1;
	private static final Integer LAST_INTEGER = 8;

	private Integer lastGame = 0;

	private static final HashMap<Integer, String> gameIndex;
	static {
		gameIndex = new HashMap<Integer, String>();
		gameIndex.put(1, "pares");
		gameIndex.put(2, "nones");
		gameIndex.put(3, "todos");
		gameIndex.put(4, "nariz");
		gameIndex.put(5, "uno");
		gameIndex.put(6, "dos");
		gameIndex.put(7, "tres");
		gameIndex.put(8, "factorX");
		gameIndex.put(9, "hidalgo");
	}

	private static final HashMap<Integer, Double> gameFrecuency;
	static {
		gameFrecuency = new HashMap<Integer, Double>();
		gameFrecuency.put(1, 1.0);
		gameFrecuency.put(2, 1.0);
		gameFrecuency.put(3, 1.0);
		gameFrecuency.put(4, 1.0);
		gameFrecuency.put(5, 0.5);
		gameFrecuency.put(6, 0.5);
		gameFrecuency.put(7, 0.5);
		gameFrecuency.put(8, 0.2);
	}

	public Game giveMeGame() {
		String audio = gameIndex.get(nextGame());
		return new Game(audio);
	}

	private Integer nextGame() {
		boolean found = false;
		Integer i = null;
		while (!found) {
			i = nextGame(FIRST_INTEGER, LAST_INTEGER);
			if (isValid(i)) {
				found = true;
			}
		}
		lastGame = i;
		return i;
	}

	private boolean isValid(Integer i) {
		double random = Math.random();
		double frec = gameFrecuency.get(i);
		if (random <= frec) {
			if (!i.equals(lastGame)) {
				return true;
			}
		}
		return false;
	}

	// stackoverflow: 363681
	private static Integer nextGame(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}

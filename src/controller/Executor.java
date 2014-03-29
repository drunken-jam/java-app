package controller;
import java.util.HashMap;
import java.util.Random;
import model.Game;


public class Executor {

	private static final HashMap<Integer, String> gameIndex;
	static {
		gameIndex = new HashMap<Integer, String>();
		gameIndex.put(1, "one");
		gameIndex.put(2, "two");
	}

	public Game giveMeGame() {
		String audio = gameIndex.get(nextGame());
		return new Game(audio);
	}

	private static Integer nextGame() {
		return nextGame(1, 2);
	}

	// stackoverflow: 363681
	private static Integer nextGame(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}

package controller;

import reproductor.Musica;
import model.Game;
import view.MainView;


public class Drunken {
	private static final long INITIAL_SECONDS = 5;
	private Chronos chrono;
	private MainView view;

	// al pulsar start en la ventana se llama a go()
	public void go() {
		chrono = new Chronos(INITIAL_SECONDS, this);
		chrono.ponerAlarmaGames();
	}

	public static void main(String[] args) {
		//new Drunken().start();
		new Musica().startMusica("FearNotThisNight");
	}

	public void start() {
		view = new MainView(this);
	}

	public void newGame(Game game) {
		view.setGameOnScreen(game.getAudio());
	}
}

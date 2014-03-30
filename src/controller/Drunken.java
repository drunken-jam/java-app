package controller;

import model.Game;
import reproductor.Musica;
import view.MainView;


public class Drunken {
	private static final long INITIAL_SECONDS = 20;
	private static final long INITIAL_MINUTES = 90;
	private Chronos chrono;
	private MainView view;
	private Musica player;

	// al pulsar start en la ventana se llama a go()
	public void go() {
		chrono = new Chronos(INITIAL_SECONDS,INITIAL_MINUTES, this);
		chrono.init();
	}

	public static void main(String[] args) {
		new Drunken().start();
	}

	public void start() {
		view = new MainView(this);
		player = new Musica();
	}

	public void stop(){
		chrono.stop();
	}

	public void gameEvent(Game game) {
		player.startMusica(game.getAudio());
		view.setGameOnScreen(game.getAudio());
		view.disable();
	}

	public void endEvent() {
		view.putInitial();
		view.enable();
	}
}

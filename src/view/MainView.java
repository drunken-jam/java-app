package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Drunken;

public class MainView extends JFrame {

	private static final String initial = "Ready for action";
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WEIGHT = 600;
	private static final int FRAME_HEIGHT = 480;

	protected Drunken drunken;
	private JPanel mainPanel;
	private JButton startButton;
	private JLabel currentGame;

	public MainView(Drunken drunken) {
		this.drunken = drunken;
		setProperties();
		this.setContentPane(getMainPane());
	}

	private void setProperties() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, FRAME_WEIGHT, FRAME_HEIGHT);
		setResizable(false);
	}

	private JPanel getMainPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		startButton = new JButton("Start");

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		currentGame = new JLabel(initial);

		mainPanel.add(startButton);
		mainPanel.add(currentGame);
		return mainPanel;
	}

	public void setGameOnScreen(String text) {
		this.currentGame.setText(text);
	}
	
	public void disable(){
		startButton.setEnabled(false);
	}
	
	public void enable(){
		startButton.setEnabled(true);
	}
	
	public void putInitial(){
		currentGame.setText(initial);
	}

	private void start() {
		drunken.go();
		this.repaint();
	}

}

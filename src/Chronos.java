import java.util.Timer;
import java.util.TimerTask;


public class Chronos extends Thread{
	
	private long period;  // segundos
	private static Timer tiempo = null;
	private static Executor ejecutor;
	
	public Chronos(long p){
		this.period = p;
		ejecutor = new Executor();
	}
	
	private class Task extends TimerTask{
		public void run(){
			System.out.println("sunea alarma");
			ponerAlarma();
		}
	}
	
	public void ponerAlarma(){
		if(tiempo == null) {
			tiempo = new Timer();
		}
		tiempo.schedule(new Task(), period*1000);
	}



}

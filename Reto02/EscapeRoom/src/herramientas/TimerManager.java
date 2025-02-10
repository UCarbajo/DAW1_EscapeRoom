package herramientas;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class TimerManager {

	    private static TimerManager instance;
	    private Timer timer;
	    private int segundos = 0;
	    private int minutos = 60;
	    private int horas = 0;
	    private JLabel lblTiempo;
	    private boolean isRunning = false;

	    private TimerManager() {
	        timer = new Timer();
	        iniciarTimer();
	    }

	    public static TimerManager getInstance() {
	        if (instance == null) {
	            instance = new TimerManager();
	        }
	        return instance;
	    }

	    private void iniciarTimer() {
	        TimerTask task = new TimerTask() {
	            @Override
	            public void run() {
	                if (segundos == 0 && minutos == 0 && horas == 0) {
	                    timer.cancel();
	                } else {
	                    if (segundos == 0) {
	                        minutos--;
	                        segundos = 59;
	                    } else {
	                        segundos--;
	                    }

	                    if (minutos < 0) {
	                        horas--;
	                        minutos = 59;
	                    }

	                    if (lblTiempo != null) {
	                        lblTiempo.setText(horas + ":" + minutos + ":" + segundos);
	                    }
	                }
	            }
	        };

	        timer.scheduleAtFixedRate(task, 0, 1000);
	    }

	    public void setLblTiempo(JLabel lblTiempo) {
	        this.lblTiempo = lblTiempo;
	    }

	    public void stopTimer() {
	        if (timer != null) {
	            timer.cancel();
	            isRunning = false;
	        }
	    }

	    public String getTime() {
	        return horas + ":" + minutos + ":" + segundos;
	    }

	    public boolean isRunning() {
	        return isRunning;
	    }
	}

package herramientas;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {

    private static TimerManager instance;
    private Timer timer;
    private int segundos = 0;
    private int minutos = 60;
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
                if (segundos == 0 && minutos == 0) {
                    timer.cancel();
                } else {
                    if (segundos == 0) {
                        minutos--;
                        segundos = 59;
                    } else {
                        segundos--;
                    }

                    if (lblTiempo != null) {
                        lblTiempo.setText(String.format("%02d:%02d", minutos, segundos));
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
        return String.format("%02d:%02d", minutos, segundos);
    }

    public boolean isRunning() {
        return isRunning;
    }
}

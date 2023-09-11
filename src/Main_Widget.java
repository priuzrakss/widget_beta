import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalTime;

public class Main_Widget {

    JFrame widget = new JFrame("");
    JLabel Time = new JLabel();


    int hours = LocalTime.now().getHour();
    int minutes = LocalTime.now().getMinute();
    int seconds = LocalTime.now().getSecond();
    float opacyti = 0;


    Font time_font = new Font("Jura Light", Font.BOLD, 125);
    Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();

    int screen_height = sSize.height;
    int screen_width = sSize.width;
    int anim_time = 0;
    int now_time = 0;

    int currX = 0;
    int currY = 0;
    boolean is_anim = false;

    Main_Widget() {
        Timer tm = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        widget.setType(Window.Type.UTILITY);
        widget.setUndecorated(true);
        widget.setShape(new RoundRectangle2D.Double(0, 0, 400, 200, 25, 25));
        widget.setSize(400, 200);
        widget.setFocusable(false);
        widget.setLocation(screen_width / 2 - 200, screen_height / 2 - 100);
        widget.getContentPane().setBackground(new Color(0, 0, 0, 255));
        widget.setFocusableWindowState(false);
        widget.getRootPane().setBackground(new Color(0, 0, 0, 0));
        Time.setBounds(200, 100, 400, 200);
        Time.setForeground(Color.white);
        if (minutes < 10 && hours> 9) {
            Time.setText(String.valueOf((hours) + " : 0" + String.valueOf(minutes)));
        }
        else if (hours < 10 && minutes < 10){
            Time.setText('0' + String.valueOf((hours) + " : 0" + String.valueOf(minutes)));

        }
        else if (hours < 10 && minutes >9){
            Time.setText('0' + String.valueOf((hours) + " : " + String.valueOf(minutes)));
        }
        else{
            Time.setText(String.valueOf((hours) + " : " + String.valueOf(minutes)));
        }
        Time.setFont(time_font);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds == 60) {
                    minutes++;
                    seconds = 0;
                    if (minutes == 60) {
                        hours++;
                        minutes = 0;
                        if (hours == 24) {
                            hours = 0;
                        }
                    }
                }
                if (minutes < 10 && hours> 9) {
                    Time.setText(String.valueOf((hours) + " : 0" + String.valueOf(minutes)));
                }
                else if (hours < 10 && minutes < 10){
                    Time.setText('0' + String.valueOf((hours) + " : 0" + String.valueOf(minutes)));

                }
                else if (hours < 10 && minutes >9){
                    Time.setText('0' + String.valueOf((hours) + " : " + String.valueOf(minutes)));
                }
                else{
                    Time.setText(String.valueOf((hours) + " : " + String.valueOf(minutes)));
                }
                Time.setFont(time_font);
            }
        });
        Timer anim_Time = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //animtaion

                if (opacyti <= 0.5f){
                    widget.setOpacity(opacyti);
                    opacyti += 0.01f;
                    }
                else {
                    opacyti = 0.5f;
                }

                now_time++;
                if (now_time == 200 && !is_anim){
                    is_anim = true;
                    now_time = 0;
                    currY = 1;
                    System.out.println("Start anim");

                }
                if(is_anim && currY != 0 ){
                    currY++;
                    Time.setBounds(currX,currY,400,200);
                    if (currY == 210){
                        currY = -210;
                    }
                }
                else if (is_anim && currY == 0){
                    is_anim = false;
                    now_time = 0;
                }

            }

        });
        anim_Time.start();
        timer.start();
        widget.add(Time);

        Time.setLocation(200, 100);

        widget.setVisible(true);
        widget.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Widget_beta {

    JFrame main_win;
    private int startX;
    private int startY;
    JPanel main_panel = new JPanel();
    JPanel menu_bar = new JPanel();
    JPanel btns = new JPanel();

    JButton close_btn;
    JButton minim_btn;
    ImageIcon close_icon = new ImageIcon("./imgs/close_icon.png");
    ImageIcon minim_icon = new ImageIcon("./imgs/minim_icon.png");

    Widget_beta() {
        close_btn = new JButton("");
        minim_btn = new JButton("");

        close_btn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        minim_btn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));

        main_win = new JFrame();
        main_win.setSize(800, 600);
        main_win.setUndecorated(true);
        main_win.setShape(new RoundRectangle2D.Double(0, 0, 800, 600, 25, 25));

        menu_bar.setSize(800, 35);
        menu_bar.setBounds(0, 0, 800, 35);
        menu_bar.setBackground(new Color(40, 40, 59));

        main_panel.setBackground(new Color(45, 45, 60));

        btns.setBounds(730, 0, 70, 35);
        btns.setLayout(new GridLayout(1, 2));

        close_btn.setBounds(730, 0, 25, 25);
        minim_btn.setBounds(765, 0, 35, 35);

        btns.add(minim_btn);
        btns.add(close_btn);

        minim_btn.setIcon(minim_icon);
        close_btn.setIcon(close_icon);

        main_win.add(btns);
        main_win.add(menu_bar);
        main_win.add(main_panel);

        close_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        minim_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_win.setState(Frame.ICONIFIED);
            }
        });










        main_win.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                startX = me.getX();
                startY = me.getY();
            }
        });

        main_win.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent de) {
                int tempX = 0;
                int tempY = 0;
                if (startX != tempX && startY != tempY) {
                    int dX = de.getX() - startX;
                    int dY = de.getY() - startY;
                    main_win.setLocation(main_win.getX() + dX, main_win.getY() + dY);
                    tempX = startX;
                    tempY = startY;
                }else {
                    startX = de.getX();
                    startY = de.getY();
                }
            }
        });


        main_win.setVisible(true);

    }


}

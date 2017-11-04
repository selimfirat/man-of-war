package com.manofwar.logic;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuickTimeEvent extends JFrame implements KeyListener{
    private static final long serialVersionUID = 1L;
    static int []pressed;
    static int[] keys;
    static int i = 0;
    static boolean bol = true;
    static int x = 0;
    String str1 = "";
    static QuickTimeEvent frame = new QuickTimeEvent();
    QuickTimeEvent(){
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent e) {
        if(i == 7) {
            bol = check();
            str1 = "";
            thumb3.setText(str1);
            return;
        }
        i++;
        if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
            //System.out.print("RIGHT ");
            str1 = str1 + " RIGHT";
            thumb3.setText(str1);
            repaint();
            pressed[i] = 39;
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT) {
            //System.out.print("LEFT ");
            str1 = str1 + " LEFT";
            thumb3.setText(str1);
            repaint();
            pressed[i] = 37;
        }
        if(e.getKeyCode()== KeyEvent.VK_UP) {
            //System.out.print("UP ");
            str1 = str1 + " UP";
            thumb3.setText(str1);
            repaint();
            pressed[i] = 38;
        }
        if(e.getKeyCode()== KeyEvent.VK_DOWN) {
            //System.out.print("DOWN ");
            str1 = str1 + " DOWN";
            thumb3.setText(str1);
            repaint();
            pressed[i] = 40;
        }
    }


    public static boolean check() {

        boolean checks = true;
        for(int a = 0; a < 7; a++) {
            if(keys[a] != pressed[a+1]) {
                System.out.println("ops. mistake");
                frame.dispose();
                i = 0;
                return false;
            }
            else
                i = 0;
        }
        frame.dispose();

        long out = System.currentTimeMillis();
        out = out % 100000;
        //System.out.println(out - in);
        if( (out - in) > 7000 ) {
            frame.dispose();
            checks = false;
            System.out.println("You waited so much...");
        }
        System.out.println(checks);
        return checks;
    }

    static JLabel thumb = new JLabel("center label");
    static JLabel thumb2 = new JLabel("center label");
    static JLabel thumb3 = new JLabel("south label");
    static long in;

    public static void attack() {
        System.out.println();
        keys = new int[8];
        random(keys);
        pressed = new int[8];
        frame.setSize(350,300);
        frame.setMinimumSize(new Dimension(350,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        //frame.setResizable(true);
        //frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.add(thumb,BorderLayout.NORTH);
        frame.add(thumb2,BorderLayout.CENTER);
        frame.add(thumb3,BorderLayout.SOUTH);

        in = System.currentTimeMillis();
        in = in % 100000;
    }


    public static void random(int [] keys) {
        for(int i = 0; i<8; i++){
            int range = (40 - 37)+ 1;
            int a = (int)(Math.random() * range) + 37;
            keys[i] = a;
        }
        String s = "";
        for(int i = 0; i<8; i++){
            if(keys[i] == 37) {
                s = s + " LEFT";
            }
            else if(keys[i] == 38) {
                s = s + " UP";
            }
            else if(keys[i] == 39) {
                s = s + " RIGHT";
            }
            else if(keys[i] == 40) {
                s = s + " DOWN";
            }
        }
        thumb2.setText(s);
    }

    public static void main(String[]args) {
        attack();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

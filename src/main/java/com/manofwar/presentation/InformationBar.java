package com.manofwar.presentation;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationBar extends JPanel {


    /**
     * constructor for information bar
     * creates information bar and label shows information about games move keys and difficulty
     */
    public InformationBar() {
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        JLabel lab1 = new JLabel("Left: "+ Settings.getInstance().getNames().get(0)+"   Up: "
                + Settings.getInstance().getNames().get(1)+ "   Right: "
                + Settings.getInstance().getNames().get(2) +"   Down: "
                + Settings.getInstance().getNames().get(3)+"                            Difficulty:   "+Settings.getInstance().getDifficultyName()
        );
        this.setBounds(0, 600, 800, 20);
        lab1.setBounds(0, 600, 800, 20);
        //this.setBackground(Color.blue);
        this.add(lab1,BorderLayout.CENTER);
    }

}

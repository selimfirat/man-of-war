package com.manofwar.logic.entities;

import javax.swing.*;

/**
 * Health bar which is on the character
 */
public class HealthBar extends JLabel {

    /**
     * Empty constructor for healthbar
     */
    public HealthBar() {
        super();
    }


    /**
     * Simply, constructor
     * @param icon the image of the icon
     */
    public HealthBar(ImageIcon icon) {
        super();
        this.setIcon(icon);
    }
}

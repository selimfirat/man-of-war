package com.manofwar.utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * InputManager is responsible for tracking user inputs and stores them.
 */
public class InputManager implements KeyListener {

    private Map<Integer, Boolean> keys = new HashMap<>();

    /**
     * Returns the statuses of keys (whether pressed or not pressed)
     * @return the statuses of keys (whether pressed or not pressed)
     */
    public Map<Integer, Boolean> getKeys() {
        return keys;
    }

    /**
     * Returns whether the given key is pressed.
     * @param keyEvent awt.event.KeyEvent member. For example, KeyEvent.VK_UP for UP key.
     * @return whether the given key is pressed.
     */
    public boolean isPressed(int keyEvent){
        return keys.getOrDefault(keyEvent, false);
    }

    /**
     * Unused method but implemented due to the KeyListener interface.
     */
    @Override
    public void keyTyped(KeyEvent e) { }

    /**
     * Invoked when a key has been pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(e.getKeyCode(), true);
    }

    /**
     * Invoked when a key has been released.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(e.getKeyCode(), false);
    }
}

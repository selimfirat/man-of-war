package com.manofwar.logic.door;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.character.Character;

public class DoorPhysicsComponent {

    private Door door;

    /**
     * Simply, constructor
     * @param door Door instance to be composited with this component
     */
    public DoorPhysicsComponent(Door door) {
        this.door = door;
    }

    public void update(GameStateManager gameStateManager) {
        Character character = gameStateManager.getCharacter();
        if (character.getBoundingBox().intersects(door.getBoundingBox())) {
            System.out.println(door.getTargetLevelNum());
            gameStateManager.initLevel(door.getTargetLevelNum());
        }
    }
}

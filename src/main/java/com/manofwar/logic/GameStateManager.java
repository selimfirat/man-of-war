package com.manofwar.logic;

import com.manofwar.logic.block.Block;
import com.manofwar.logic.bullet.Bullet;
import com.manofwar.logic.door.Door;
import com.manofwar.logic.entities.Difficulty;
import com.manofwar.logic.item.Item;
import com.manofwar.logic.character.Character;
import com.manofwar.logic.mob.Mob;
import com.manofwar.logic.squeezer.Squeezer;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;
import com.manofwar.utilities.InputManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GameStateManager is to control the game state and contains all its game objects.
 * Manages coherence between utility managers and game objects.
 * Contains all managers and game objects but interferes with them as little as possible.
 */
public class GameStateManager {

    private FileManager fileManager;
    private GraphicsManager graphicsManager;
    private InputManager inputManager;

    private LevelFactory levelFactory;

    private double totalPassedSeconds = 0.0;
    private double passedSeconds = 0.0;

    private Character character;
    private List<Mob> mobs;
    private List<Block> blocks;
    private List<Item> nonTakenItems;
    private List<Door> doors;
    private List<Bullet> bullets;
    private List<Squeezer> squeezers;

    private int levelNum = -1;

    /**
     * Simply, constructor.
     * @param fileManager FileManager instance
     * @param graphicsManager GraphicsManager instance
     * @param inputManager InputManager instance
     */
    public GameStateManager(FileManager fileManager, GraphicsManager graphicsManager, InputManager inputManager) {
        this.fileManager = fileManager;
        this.graphicsManager = graphicsManager;
        this.inputManager = inputManager;

        levelFactory = new LevelFactory();
    }

    /**
     * Inits level and shows it on screen. Does all the job.
     * @param levelNum target level number to be changed
     */
    public void initLevel(int levelNum) {

        mobs = new ArrayList<>(Arrays.asList(levelFactory.createMobs(levelNum)));
        blocks = new ArrayList<>(Arrays.asList(levelFactory.createBlocks(levelNum)));
        doors = new ArrayList<>(Arrays.asList(levelFactory.createDoors(levelNum)));
        nonTakenItems = new ArrayList<>(Arrays.asList(levelFactory.createNonTakenItems(levelNum)));
        squeezers = new ArrayList<>(Arrays.asList(levelFactory.createSqueezers(levelNum)));
        bullets = new ArrayList<>();

        character = levelFactory.createCharacter(levelNum);
        this.levelNum = levelNum;
    }

    /**
     * Starts the game with level 1
     */
    public void startGame(int level) {
        initLevel(level);
    }

    /**
     *
     * Executes game objects' update methods.
     * @param passedSeconds passed seconds until last iteration of the game loop
     */
    public void update(double passedSeconds) {
        totalPassedSeconds += passedSeconds;
        this.passedSeconds = passedSeconds;

        graphicsManager.resetFullImage();
        graphicsManager.draw(fileManager.getImage(getClass().getClassLoader().getResource("level" + levelNum + ".jpg")), new Rectangle(0, 0, 800, 600));

        for (Mob mob : mobs)
            mob.update(this);

        for (Block block : blocks)
            block.update(this);

        for (Item item : nonTakenItems)
            item.update(this);

        for (Door door : doors)
            door.update(this);

        for (Bullet bullet : bullets)
            bullet.update(this);

        for (Squeezer squeezer: squeezers)
            squeezer.update(this);

        character.update(this);
    }

    /**
     * Returns the non-taken items on the map
     * @return non-taken items on the map
     */
    public List<Item> getNonTakenItems() {
        return nonTakenItems;
    }

    /**
     * Returns the character
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Returns the mobs in the game
     * @return the mobs in the game
     */
    public List<Mob> getMobs() {
        return mobs;
    }

    /**
     * Returns the blocks in the game
     * @return the blocks in the game
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Returns the doors in the game
     * @return the doors in the game
     */
    public List<Door> getDoors() {
        return doors;
    }

    /**
     * Returns the composited FileManager instance
     * @return the composited FileManager instance
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Returns the composited GraphicsManager instance
     * @return the composited GraphicsManager instance
     */
    public GraphicsManager getGraphicsManager() {
        return graphicsManager;
    }

    /**
     * Returns the composited InputManager instance
     * @return the composited InputManager instance
     */
    public InputManager getInputManager() {
        return inputManager;
    }

    /**
     * Returns the passed seconds since the beginning of the game
     * @return the passed seconds since the beginning of the game
     */
    public double getTotalPassedSeconds() {
        return totalPassedSeconds;
    }

    /**
     * Returns the passed seconds since the last iteration
     * @return the passed seconds since the last iteration
     */
    public double getPassedSeconds() {
        return passedSeconds;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public void restartLevel() {
        initLevel(levelNum);
    }
}
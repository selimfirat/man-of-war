package com.manofwar.logic;

import com.manofwar.logic.character.Character;
import com.manofwar.logic.block.Block;
import com.manofwar.logic.door.Door;
import com.manofwar.logic.item.Item;
import com.manofwar.logic.item.ItemType;
import com.manofwar.logic.entities.Inventory;
import com.manofwar.logic.entities.Velocity;
import com.manofwar.logic.mob.Mob;
import com.manofwar.logic.mob.MobType;
import com.manofwar.logic.squeezer.Squeezer;
import com.manofwar.presentation.Settings;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LevelFactory class is a helper class using Factory design pattern for GameStateManager. Creates the game objects and returns them to this manager.
 */
public class LevelFactory {

    private List<String> getLines(String path) {

        System.out.println(path + " is loading...");
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(in));

        ArrayList<String> list = new ArrayList<String>();
        try {
            String str;
            while((str = txtReader.readLine()) != null){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Mob[] createMobs(int levelNum) {

        List<String> blueList = getLines("level_" + levelNum + "/mobs_green.txt");
        List<String> redList = getLines("level_" + levelNum + "/bosses_brown.txt");


        Mob[] mobsArray = new Mob[redList.size() + blueList.size()];
        for(int i = 0; i<blueList.size(); i++) {
            String[] splited = blueList.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            mobsArray[i] = new Mob(new Rectangle(a, b, Config.TILE_WIDTH, Config.TILE_HEIGHT), MobType.MOB_GREEN,3,  100, 100, new Inventory(), new Velocity());
        }


        for(int i = 0; i<redList.size(); i++) {
            String[] splited = redList.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            int maxHealth = (int) ( 100 * Settings.getInstance().getDifficultyMultiplier());
            mobsArray[blueList.size() + i] = new Mob(new Rectangle(a, b, Config.TILE_WIDTH, Config.TILE_HEIGHT), MobType.BOSS_BROWN,6,  maxHealth, maxHealth, new Inventory(), new Velocity());
        }
        return mobsArray;
    }

    public Block[] createBlocks(int levelNum) {

        List<String> list = getLines("level_" + levelNum + "/blocks.txt");

        Block[] blocksArray = new Block[list.size()];
        for(int i = 0; i<list.size(); i++) {
            String[] splited = list.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            blocksArray[i] = new Block(new Rectangle(a, b, Config.TILE_WIDTH, Config.TILE_HEIGHT));
        }

        return blocksArray;
    }

    public Item[] createNonTakenItems(int levelNum) {

        List<String> blueList = getLines("level_" + levelNum + "/blue_potions.txt");
        List<String> redList = getLines("level_" + levelNum + "/red_potions.txt");

        Item[] itemsArray = new Item[blueList.size() + redList.size()];

        for(int i = 0; i< blueList.size(); i++) {
            String[] splited = blueList.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            itemsArray[i] = new Item(new Rectangle(a, b, 50, 50), true, ItemType.BLUE_POTION, 10, 10, 0);
        }

        for(int i = 0; i < redList.size(); i++) {
            String[] splited = redList.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            itemsArray[blueList.size() + i] = new Item(new Rectangle(a, b, 50, 50), true, ItemType.RED_POTION, 10, 0, 10);
        }

        return itemsArray;
    }

    public Door[] createDoors(int levelNum) {

        List<String> list = getLines("level_" + levelNum + "/doors.txt");

        Door[] doorsArray = new Door[list.size()];
        for(int i = 0; i<list.size(); i++) {
            String[] splited = list.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            int c = Integer.parseInt(splited[2]);
            doorsArray[i] = new Door(new Rectangle(a, b, Config.TILE_WIDTH, Config.TILE_HEIGHT), c);
        }

        return doorsArray;
    }

    public Squeezer[] createSqueezers(int levelNum) {

        List<String> list = getLines("level_" + levelNum + "/squeezers.txt");


        Squeezer[] squeezersArray = new Squeezer[list.size()];

        for(int i = 0; i<list.size(); i++) {
            String[] splited = list.get(i).split("\\s+");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            String c = splited[2];
            squeezersArray[i] = new Squeezer(new Rectangle(a, b, Config.TILE_WIDTH, Config.TILE_HEIGHT), Direction.valueOf(c));
        }

        return squeezersArray;
    }

    public Character createCharacter(int levelNum) {
        List<String> list = getLines("level_" + levelNum + "/spawn_point.txt");

        String[] splited = list.get(0).split("\\s+");
        int a = Integer.parseInt(splited[0]);
        int b = Integer.parseInt(splited[1]);

        return new Character(new Rectangle(a, b, 40, 40),30, 100, 100, new Inventory(), new Velocity(0, 0));
    }
}
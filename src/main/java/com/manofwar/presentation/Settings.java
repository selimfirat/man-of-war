package com.manofwar.presentation;

        import java.util.ArrayList;

public class Settings {
    //37 left //38 up //39 right //40 down
    //74 //73 //76 //75
    //100 //104 //102 //101
    private static Settings instance = new Settings();
    
    /**
     * constructor for settings
     * default values of settings
     */
    private Settings(){
        difficulty = "easy";
        integers = new ArrayList<Integer>();
        strings = new ArrayList<String>();
        integers.add(37);integers.add(38);integers.add(39);integers.add(40);
        strings.add("leftArrow");strings.add("upArrow");strings.add("rightArrow");strings.add("downArrow");
    }
    private double difficultyMultiplier = 1.0;
    public static Settings getInstance(){
        return instance;
    }

    ArrayList<Integer> integers;
    ArrayList<String> strings;
    String difficulty;

    /**
     * @param i
     * @return arrayList that stores movement keys
     * Due to settings changes keys changes 
     */
    public ArrayList<Integer> changeKeys(int i) {
        if(i == 1) {
            integers = new ArrayList<Integer>();
            strings = new ArrayList<String>();
            integers.add(74);integers.add(73);integers.add(76);integers.add(75);
            strings.add("j");strings.add("i");strings.add("l");strings.add("k");
        }
        else if(i == 0) {
            integers = new ArrayList<Integer>();
            strings = new ArrayList<String>();
            integers.add(37);integers.add(38);integers.add(39);integers.add(40);
            strings.add("leftArrow");strings.add("upArrow");strings.add("rightArrow");strings.add("downArrow");
        }
        else if(i == 2) {
            integers = new ArrayList<Integer>();
            strings = new ArrayList<String>();
            integers.add(100);integers.add(104);integers.add(102);integers.add(101);
            strings.add("num4");strings.add("num8");strings.add("num6");strings.add("num5");
        }
        return integers;
    }
    /**
     * @return key arrayList
     */
    public ArrayList<Integer> getKeys(){
        return integers;
    }
    /**
     * @return keys names arraylist
     */
    public ArrayList<String> getNames(){
        return strings;
    }

    /**
     * @param i
     * it changes the level multiplier
     */
    public void changeDiffculty(int i){
        if(i == 0) {
            difficulty = "Easy";
            difficultyMultiplier = 1.0;
        }
        else if(i == 1) {
            difficulty = "Normal";
            difficultyMultiplier = 1.25;
        }
        else if(i == 2) {
            difficulty = "Hard";
            difficultyMultiplier = 1.5;
        }
    }

    /**
     * @return difficulty name
     */
    public String getDifficultyName(){
        return difficulty;
    }

    /**
     * @return difficultyMultiplier
     */
    public double getDifficultyMultiplier() {
        return difficultyMultiplier;
    }
}
//Main java file for game

import java.util.*;
public class TilesGame {
    
    public static Scanner in = new Scanner(System.in);
    public static Item[] allItems ={
        new Item("Sword", 5, 0, false),
        new Item("Axe", 10, 0, false),
        new Item("HP Potion", 0, 20, true)
    };
    public static Tiles[] allTiles = {
            new Tiles("This is A1 Tile", 0, -1,   1, 4,  -1),
            new Tiles("This is A2 Tile", 1, -1,   2, 5,   0),
            new Tiles("This is A3 Tile", 2, -1,   3, 6,   1),
            new Tiles("This is A4 Tile", 3, -1,  -1, 7,   2),
            new Tiles("This is B1 Tile", 4,  0,   5, 8,  -1),
            new Tiles("This is B2 Tile", 5,  1,   6, 9,   4),
            new Tiles("This is B3 Tile", 6,  2,   7, 10,  5),
            new Tiles("This is B4 Tile", 7,  3,  -1, 11,  6),
            new Tiles("This is C1 Tile", 8,  4,   9, 12, -1),
            new Tiles("This is C2 Tile", 9,  5,  10, 13,  8),
            new Tiles("This is C3 Tile", 10, 6,  11, 14,  9),
            new Tiles("This is C4 Tile", 11, 7,  -1, 15, 10),
            new Tiles("This is D1 Tile", 12, 8,  13, -1, -1),
            new Tiles("This is D2 Tile", 13, 9,  14, -1, 12),
            new Tiles("This is D3 Tile", 14, 10, 15, -1, 13),
            new Tiles("This is D4 Tile", 15, 11, -1, -1, 14)};
    public static Player me = new Player("Jordan", 100, 10);
    public static Player zombie = new Player("Zombie", 15, 5);
    
    public static void main(String[] args) {
        int i = 0;
        int newTile = 0;
        while(true){
            if (newTile != -1){
                wordWrap(allTiles[i].getDescription());
            }
            newTile = allTiles[i].findTile(direction());
            if (newTile != -1){
                i = newTile;
            }
            else{
                System.out.printf("You can't go that way!\n");
            }
            fightingAlg();
        }
    }  
    
    public static String direction(){
        System.out.printf("Which direction would you like to go?\n%3c\nW%4c\n%3c\n",'N', 'E', 'S' );
            String direction = in.next();
            return direction;
    }
    
    public static void wordWrap(String x){
        int i = 40;
        int counter = 0;
        if(x.length()<40){
            System.out.printf("%s\n", x);
        }
        while(i<x.length()){
            if(x.length()<i){
                System.out.printf("%s\n", x.substring(counter, x.length()));
            }
            String y = x.substring(counter, i);
            System.out.printf("%s\n", y);
            counter+=40;
            i+=40;
        }    
    }
    
    //String text = String.format("$d", 1);
    
    //fightChance
    public static boolean fight(){
        boolean fight = false;
        int x = (int)Math.ceil(Math.random()*100);
        if (x > 90){
            fight = true;
        }
        return fight;
    }
    
    //attacking and calculating remaining HP
    public static int combat(int att, int HP){
        int remainingHP = HP - att;
        if (remainingHP < 0){
            return 0;
        }
        return remainingHP;
    }
    
    //Random block chance
    public static boolean defend(){
        int x = (int)Math.ceil(Math.random()*100);
        if (x > 50){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Fighting method
    public static void fightingAlg(){
        boolean y = fight();
            while (y){
                System.out.println("There is an enemy nearby!");
                System.out.printf("A zombie has appeared!\nAttack: a\nDefend: b\n");
                char choice = in.next().charAt(0);
                if(choice == 'a'){
                    int afterHp = combat(me.getAtt(), zombie.getHP());
                    zombie.setHP(afterHp);

                    afterHp = combat(zombie.getAtt(), me.getAtt());
                    me.setHP(afterHp);

                    if(me.getHP() == 0){
                        System.out.println("You're dead!\n");
                        System.exit(0);
                    }
                    else if(zombie.getHP() == 0){
                        System.out.println("You killed the zomibe!");
                        y = false;
                    }
                }
                else if(choice == 'b'){
                    if(defend()){
                        System.out.printf("Block Sucessful!\n");
                    }
                    else{
                        System.out.printf("Failed to block!\n");
                        me.setHP(combat(zombie.getAtt(), me.getAtt()));
                    }
            }
        }
    }
    
    
}

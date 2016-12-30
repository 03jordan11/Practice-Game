//Class for item objects

public class Item {
    private final String name;
    private final int attMod;
    private final int healthGain;
    private final boolean potion;
    
    Item(String name, int attMod, int healthGain, boolean potion){
        this.name = name;
        this.attMod = attMod;
        this.healthGain = healthGain;
        this.potion = potion;
    }
    
    public int attMod(){
        return attMod;
    }
    
    public int potion(){
        if(potion){
            return healthGain;
        }
        return 0;
    }
}

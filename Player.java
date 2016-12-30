//Class for player objects

public class Player {
    private String name;
    private int HP;
    private int att;
    
    Player(String name, int HP, int att){
        this.name = name;
        this.HP = HP;
        this.att = att;
    }
    
    public void setHP(int newHP){
        this.HP = newHP;
    }
    public int getHP(){
        return HP;
    }
    
    public void setAtt(int newAtt){
        this.att = newAtt;
    }
    
    public int getAtt(){
        return att;
    }
}

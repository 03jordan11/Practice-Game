//Class for each object tile

public class Tiles {
    Tiles(String description, int tileNum, int N, int E, int S, int W){
        this.description = description;
        this.tileNum = tileNum;
        this.N = N;
        this.E = E;
        this.S = S;
        this.W = W;
    }
    Tiles(){}
    
    public String description;
    public int tileNum;
    public int N;
    public int E;
    public int S;
    public int W;
    
    public String getDescription(){
        return description;
    }
    
    public int findTile(String direction){
        String upper = direction.toUpperCase();
        char x = upper.charAt(0);
        if (x == 'N'){
            return N;
        }
        else if(x == 'E'){
            return E;
        }
        else if(x == 'S'){
            return S;
        }
        else if(x == 'W'){
            return W;
        }
        return -1;
    }
  
    
}

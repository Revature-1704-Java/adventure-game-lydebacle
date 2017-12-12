import java.util.Arrays;
import java.util.ArrayList;

public class Room{
    private String content;
    private String description;
    private ArrayList<String> exits = new ArrayList<String>();
    public Room(){}
    public Room(String roomIdentify){
        content = roomIdentify;

    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public String getContent(){
        return this.content;
    }
    public void addExit(String exit){
        this.exits.add(exit);   
    }
    public ArrayList<String> getExits(){
       return exits;
    }
}
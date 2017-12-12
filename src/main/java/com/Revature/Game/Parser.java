import java.util.Arrays;

public class Parser{
    private String[] exitArray = {"Angel's Bay","DoomsEnd Valley", "Catfished Attic"};
    private int sizeOfOtherExits = exitArray.length;
    public Parser(){}
    public void parseRoomCommand (String roomInputChosen, Room roomChosen){
        if(roomInputChosen.charAt(0) == 'a'){
            roomChosen.setDescription("Angel's Bay is full of angelic swords. As you proceed closer, you notice blood on the sheathe of one sword. ");
            
            
        }
        else if(roomInputChosen.charAt(0) == 'd'){
            roomChosen.setDescription("DoomsEnd Valley is deadly. As you proceed closer, you notice a feminine silhoutte prowling what appears to be a cascade of rocks spelling out Jess");
            
            
        }
        else if(roomInputChosen.charAt(0) == 'c'){
            roomChosen.setDescription("Catfished Attic seems eerie. As you proceed closer, you smell decaying urine and see a huge amount of flies...");
            
            
        }
        getOtherExits(roomChosen);
    }
    public void getOtherExits(Room roomChosen){
        for(int i =0; i< sizeOfOtherExits; i++){
            if(!roomChosen.getExits().contains(exitArray[i]) && !(exitArray[i].equals(roomChosen.getContent()))){
                roomChosen.addExit(exitArray[i]);
            }
        }
    }
    public void displayExits(Room roomChosen){
        System.out.println("What would you like to do next? Go to a different room or solve mystery.");
        for(int i =0; i<roomChosen.getExits().size(); i++){
            System.out.print(Character.toLowerCase(roomChosen.getExits().get(i).charAt(0))+": "+roomChosen.getExits().get(i)+" ");
        }
        System.out.println("s: Solve Mystery");
    }
}
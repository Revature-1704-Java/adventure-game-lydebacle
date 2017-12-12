
import java.util.Scanner;

public class Game{
    private Room roomChosen;
    private String inputChosen;
    private String solved;
    private Parser gameParser = new Parser();
    private boolean isSolved;
    private Scanner sc = new Scanner(System.in);
    private Room    angelBay = new Room("Angel's Bay");
    private Room    doomsEnd = new Room("DoomsEnd Valley");
    private Room    catfishedattic = new Room("Catfished Attic");

    public static void main(String[] args){
        Game game = new Game();
        game.runGameUntilComplete();
    }

    public void runGameUntilComplete(){
        introStory();
        investigating();
    }

    public void introStory(){
        System.out.println("Welcome to RevatureAdventure! You are a detective." +
        "In each room there are hints. Solve the murder mystery!");
        System.out.println("Pick a room to start investigating: ");
        System.out.println("a: Angel's Bay d: DoomsEnd Valley c: Catfished Attic"); 
        
    }   
    public void pickRoom(){
        
               
        inputChosen = sc.nextLine();
        if(inputChosen.isEmpty() || inputChosen.length() != 1){
            System.out.println("Please try again."); return;
        }
        switch (inputChosen.charAt(0)){
            case 'a': System.out.println("You are now in Angel's Bay");
                      this.roomChosen = angelBay;
                      break;
            case 'd': System.out.println("You are now in DoomsEnd Valley");
                      this.roomChosen = doomsEnd;
                      break;
            case 'c': System.out.println("You are now in Catfished Attic");
                      this.roomChosen = catfishedattic;
                      break;
            case 's': solveMystery();return;
            default: System.out.println("Please try again.");break;
                     
        }
        gameParser.parseRoomCommand(inputChosen, roomChosen);
        System.out.println(roomChosen.getDescription());
    }
    public void investigating()
    {
        while(!isSolved){
            
            if(roomChosen != null){
                gameParser.displayExits(roomChosen);
            }
            pickRoom();

        }
    }
    public void solveMystery(){
        isSolved = true;
        System.out.println("You have only one chance to solve this mystery!");
        System.out.println("Who did it?");
        solved = sc.nextLine();
        if(!solved.toUpperCase().equals("JESS")){System.out.println("Wrong. You Failed. Game Over."); return;}
        System.out.println("What was the murder weapon?");
        solved = sc.nextLine();
        if(!solved.toUpperCase().equals("SWORD")){System.out.println("Wrong. You Failed. Game Over.");return;}
        System.out.println("Where was the body?");
        solved = sc.nextLine();
        if(!solved.toUpperCase().equals("CATFISHED ATTIC")){System.out.println("Wrong. You Failed. Game Over.");return;}
        else{System.out.println("You solved the mystery. Game OVER!");}
    }

}
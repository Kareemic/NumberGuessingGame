import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Game {

    private int theNumber;
    private int highScore=0;

    public Game(){

        Random generator=new Random();
        int randomNumber= generator.nextInt(100);
        theNumber=randomNumber;

        System.out.println("Welcome to the number guessing game!");
        System.out.println("Im thinking of a number between 1 and 100");
        System.out.println("Please select the difficulty:");
        System.out.println("\t1.Easy (10 chances)");
        System.out.println("\t2.Medium (5 chances)");
        System.out.println("\t3.Hard (3 chances)");
        Scanner sc=new Scanner(System.in);
        int difficulty=0;
        int chances=10;
        do{
            try {
                System.out.print("Enter difficulty:");
                difficulty = sc.nextInt();
                if(difficulty >3 || difficulty<1){
                    difficulty=0;
                    System.out.println("You entered the wrong input, select one of the three difficulties.");

                }
            }
            catch(Exception e){
                System.out.println("You entered the wrong input, select one of the three difficulties.");
                sc.nextLine();
            }

        }while(difficulty==0);
        chances = switch (difficulty) {
            case 1 -> 10;
            case 2 -> 5;
            case 3 -> 3;
            default -> chances;
        };

        int playerGuess=-1;
        boolean next=true;

        System.out.println("Use \"help\" for a hint!");
        timer timer=new timer();
        timer.Start();

        while(chances!=0){
            do{
                try{
                    System.out.print("Enter your guess:");
                    playerGuess=sc.nextInt();
                    next=true;
                }
                catch(Exception e){
                    next=false;
                    String help=sc.nextLine();
                    if(help.equalsIgnoreCase("help")){
                    new Hint(theNumber);
                    }
                    else{ System.out.println("You entered the wrong input, enter a number.");
                    }
                }

            }while(!next);
            if(playerGuess==randomNumber) {
                timer.Stop();
                double timeInSec=(double)timer.Duration()/1000;
                System.out.println("You guessed the number!!!! It was "+ playerGuess + "\t Your time:"+ timeInSec+"s");
                if(chances>highScore)highScore=chances;
                break;
            }
            chances--;
            if(playerGuess>randomNumber) {System.out.println("Incorrect! The number is less than "+playerGuess +" \t chances left:"+chances);}
            else System.out.println("Incorrect! The number is more than "+playerGuess+" \t chances left:"+chances);


        }
        if(chances==0) {
            System.out.println("Ahh too bad you are out of chances. The number was " + randomNumber);
        }
        System.out.println("Do you want to try again?: Y/N \t Your Highscore: "+ highScore);

        String again=sc.next();

        if(again.equalsIgnoreCase("Y")) new Game();
        if(again.equalsIgnoreCase("N")) System.exit(0);

        try {
            System.out.println("Ill take that as a NO.");
            Thread.sleep(5000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.exit(0);


    }
}

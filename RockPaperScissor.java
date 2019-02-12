package rockpaperscissor;

// Libraries
import java.util.Random;  // To use the Random library.
import java.util.Scanner;  // To use the Scanner library.

public class RockPaperScissor {
   
    // Main function.
    public static void main(String[] args) {
        // Using a variable for the keyboard object.
        Scanner keyboard = new Scanner(System.in);
        
        // Initializing variables.
        int userChoice = 0;
        int pcChoice = 0;
        int result = 0;
        int winCounter = 0;
        int loseCounter = 0;
        int drawCounter = 0;
        char aChar = ' ';
        boolean userChoiceLoop = false;
        boolean userEndGameLoop = false;
        boolean endGame =  false;
        
        // Game Loop.
        do {
            // Getting the user decision.            
            do {            
               System.out.print("Enter your choice [1-Rock], [2-Paper], [3-Scissor]:");
               
                // If the user chose an integer number.
                if(keyboard.hasNextInt()) {
                    // Assign the value to variable.
                    userChoice = keyboard.nextInt();

                    // If the number is 1,2,3 get it, if not continue the loop.
                    if(userChoice == 1 || userChoice == 2 || userChoice == 3) {
                      // Finish the loop. 
                      userChoiceLoop = true;
                    }                   
                } else {  // It must be an invalid input. 
                   System.out.println("Invalid input. Please try again.");
                   keyboard.next(); // -->important
                   System.out.println();
                }                
            } while (!userChoiceLoop);            

            // Getting a random number from the method.
            pcChoice = generateRandomNumber();

            // Comparing choices sending them to the method.
            result = loseOrWin(userChoice, pcChoice);
            
            // If there was an error from the method notify it.
            if(result == -2) {
                System.out.println("There is an error from the method.Check your code");
                System.exit(0);
            }
            
            // If it was a DRAW count it, and repeat the loop.            
            if(result == -1) {
                drawCounter += 1;
                continue;
            }
            
            // If it was WIN or LOSE count it,and ask play again?
            if(result == 1 || result == 0) {
                if(result == 1) {
                    winCounter += 1;
                }
                if(result == 0) {
                    loseCounter += 1;
                }
                
                // Ask for play again and getting a char from user.                
                do {
                    System.out.print("Do you want to play again? [y]Yes or [n]No:");
                    aChar = keyboard.next().charAt(0); 

                    if(Character.toString(aChar).matches("y") || Character.toString(aChar).matches("n")) {
                        // If yes continue the game or loop.
                        if(aChar == 'y') {
                            userEndGameLoop = true;
                        } 
                        // If no end the loop or game.
                        if(aChar == 'n') {
                            userEndGameLoop = true;
                            endGame = true;
                        }
                    } else {
                        System.out.println("Invalid input. Please try again.\n");
                    }
                } while(!userEndGameLoop);
            }        
        } while(!endGame);
        
        // If user chose not to continue, display results.
        System.out.println("You have win: " + winCounter + " times.");
        System.out.println("You have lose: " + loseCounter + " times.");
        System.out.println("You have draw: " + drawCounter + " times.");                
    }
    
    // Method that return an integer random number.
    public static int generateRandomNumber() {
        // Calling object to use the random method.
        Random rand = new Random();
        
        // Initializing variables.
        int aNumber = 0;
        
        // Generating a random number between 1 and 3.
        aNumber = rand.nextInt(3) + 1;
        
        // Returning the random number.
        return aNumber;
    }
    
    // Method that return if you win or lose or draw.
    public static int loseOrWin(int userChoice, int pcChoice) {
       // 1 - Rock, 2 - Paper, 3 - Scissor.
       
       // If user: rock & PC: rock.
       if(userChoice == 1 && pcChoice == 1) {
           System.out.println("You chose \"Rock\" and PC chose \"Rock\".");
           System.out.println("DRAW.");
           System.out.println("Choose again.\n");
           return -1;
        }
       
       // If user: rock & PC: paper.
       if(userChoice == 1 && pcChoice == 2) {
           System.out.println("You chose \"Rock\" and PC chose \"Paper\".");
           System.out.println("YOU LOSE!!!.\n");
           return 0;
        }
       
       // If user: rock & PC: scissor.
       if(userChoice == 1 && pcChoice == 3) {
           System.out.println("You chose \"Rock\" and PC chose \"Scissor\".");
           System.out.println("YOU WIN!!!\n");
           return 1;           
        }
       
       // If user: paper & PC: rock.
       if(userChoice == 2 && pcChoice == 1) {
           System.out.println("You chose \"Paper\" and PC chose \"Rock\".");
           System.out.println("YOU WIN!!!\n");
           return 1; 
        }
       
       // If user: paper & PC: paper.
       if(userChoice == 2 && pcChoice == 2) {
           System.out.println("You chose \"Paper\" and PC chose \"Paper\".");
           System.out.println("DRAW");
           System.out.println("Choose again.\n");
           return -1;
        }
       
       // If user: paper & PC: scissor.
       if(userChoice == 2 && pcChoice == 3) {
           System.out.println("You chose \"Paper\" and PC chose \"Scissor\".");
           System.out.println("YOU LOSE!!!\n");
           return 0;
        }
       
       // If user: scissor & PC: rock.
       if(userChoice == 3 && pcChoice == 1) {
           System.out.println("You chose \"Scissor\" and PC chose \"Rock\".");
           System.out.println("YOU LOSE!!!\n");
           return 0;
        }
       
       // If user: scissor & PC: paper.
       if(userChoice == 3 && pcChoice == 2) {
           System.out.println("You chose \"Scissor\" and PC chose \"Paper\".");
           System.out.println("YOU WIN!!!\n");
           return 1;
        }
       
       // If user: scissor & PC: scissor.
       if(userChoice == 3 && pcChoice == 3) {
           System.out.println("You chose \"Scissor\" and PC chose \"Scissor\".");
           System.out.println("DRAW");
           System.out.println("Choose again.\n");
           return -1;
        }      
       
       // Return -2 in case of an error.
       return -2;
    }    
}
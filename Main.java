import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


            System.out.println("Enter the size of the grid where you want to play (greater than or equal to 2)");


            Scanner input = new Scanner(System.in);
            int size;
            while(true)
            {
                size = input.nextInt();
                if(size < 2)
                    System.out.println("The size should be greater than or equal to 2, please try again");
                else
                    break;
            }
            WhackAMole newGame = new WhackAMole(10,size); // creating a new game of Whack-A-Mole

            // ------------------------ placing the moles ---------------------------- //

            int counter = 0, x, y;
            Random numGenerator = new Random(); // to generate random coordinates
            boolean key;
            while (counter < size)
            {
                x = numGenerator.nextInt(size);
                y = numGenerator.nextInt(size);
                key = newGame.place(x,y);
                if (key)
                    counter++;
            }

        System.out.println("You have to WHACK " + newGame.getMolesLeft() + " moles");
            while (true)
            {
                System.out.println("\nEnter the co-ordinates where you want to whack (you have " + newGame.getAttemptsLeft() + " attempts) (Enter -1,-1 coordinate to exit): ");
                System.out.println("Enter y-coordinate(0-" + (newGame.getGridDimension() - 1) + "): ");
                x = input.nextInt();
                System.out.println("Enter x-coordinate(0-" + (newGame.getGridDimension() - 1) + "): ");
                y = input.nextInt();
                System.out.println();

                if((x == -1) && (y == -1)) // to exit
                {
                    System.out.println("You have left the game !\nHere is the solution gameboard\n");
                    newGame.printGrid();
                    break;
                }

                boolean isWhack = newGame.whack(x, y);

                if(isWhack) // checking if correct coordinates were entered
                {
                    System.out.println("Let's have a look at the game board");
                    newGame.printGridToUser();

                    if (newGame.getMolesLeft() == 0)
                    {
                        System.out.println("You WHACKED all the moles! Congratulations!!");
                        break;
                    }

                    else if (newGame.getAttemptsLeft() == 0)
                    {
                        System.out.println("You LOST all of your ATTEMPTS! Sorry!\nHere is the solution game board");
                        newGame.printGrid();
                        break;
                    }

                    else
                    {
                        System.out.println("There are still " + newGame.getMolesLeft() +" moles left. Please try again!");
                    }
                }
            }

            input.close();

        }


    }




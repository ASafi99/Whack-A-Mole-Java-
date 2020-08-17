public class WhackAMole {

    private int score;
    private int molesLeft ;
    private int attemptsLeft;
    private int gridDimension;

    public int getScore() {
        return score;
    }

    public int getMolesLeft() {
        return molesLeft;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public int getGridDimension() {
        return gridDimension;
    }

    private char[][] moleGrid;

    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];

        for (int i = 0; i < gridDimension; i++)
            for (int j = 0; j < gridDimension; j++)
                moleGrid[i][j] = '*';
    }

    public boolean place(int x, int y) {

        if ((x > gridDimension) || (y > gridDimension) || (moleGrid[x][y] == 'M'))
            return false;
        else {
            moleGrid[x][y] = 'M';
            molesLeft++;
            return true;

        }
    }

    public boolean whack(int x, int y) {

        if ((x >= gridDimension) || (y >= gridDimension) || (x < 0) || (y < 0)) {
            System.out.println("Invalid Co-ordinates, Please enter x and y between 0-" + gridDimension);
            return false;
        } else if ((moleGrid[x][y] == 'W')) {
            System.out.println("Already WHACKED, please enter a different Co-ordinate");
            return false;
        } else {
            if (moleGrid[x][y] == 'M') {
                System.out.println("You WHACKED a mole");
                moleGrid[x][y] = 'W';
                molesLeft--;
                score++;
            } else {
                System.out.println("You MISSED the mole");
                moleGrid[x][y] = 'W';

            }
            attemptsLeft--;
        }

        System.out.println("Your score is now: " + score + " and there are " + molesLeft + " left");
        System.out.println("you have " + attemptsLeft + " attempts left!");
        return true;
    }

    public void printGridToUser() {
        for (int i = 0; i < moleGrid[0].length; i++) {
            for (int j = 0; j < moleGrid[0].length; j++) {
                if (moleGrid[i][j] == 'M')
                    System.out.print("* ");
                else
                    System.out.print(moleGrid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Your SCORE is " + score);
    }

    public void printGrid() {

        for (int i = 0; i < moleGrid[0].length; i++) {
            for (int j = 0; j < moleGrid[0].length; j++)
                System.out.print(moleGrid[i][j] + " ");
            System.out.println();
        }
        System.out.println("Your FINAL SCORE is " + score);


    }
}


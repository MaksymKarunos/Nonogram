import java.java.util.*;
import java.util.Random;
public class Draft {
    public static void main(String[] args){

        boolean[][] grid;
        grid = createNewGrid();
        grid = initializeGrid(grid);
        print(grid);
        clueInRows(grid);
        //clueInRows(0, grid);
        clueInColumns(grid);
        //clueInColumns(0,grid);

    }

    // Two methods for intnialzing the grid
    public static boolean[][] createNewGrid(){
        boolean[][] grid = new boolean[10][10];
        return grid;
    }
    public static boolean[][] createnewGrid(int n){
        boolean[][] grid = new boolean[n][n];
        return grid;
    }
    
    // Method that fills out the grid with either X's or Spaces
    public static boolean[][] initializeGrid(boolean[][] grid ){
        Random myRandom = new Random(228);
        for ( int i = 0; i < grid.length; i++){
            for ( int j = 0; j < grid[0].length; j++){
                if ( myRandom.nextInt(1000)< 500 ){
                    for ( int f = 0; f < myRandom.nextInt(grid[0].length); f++){
                        grid[i][j] = true;
                    }
                }
                else{
                    grid[i][j] = false;
                }
            }
        }
        return grid;
    }
    
    //Outputs the grid on the screen
    
    public static void print(boolean[][] grid){
        String myGrid = "\n";
        for ( int i = 0; i < grid.length; i++){
            for ( int j = 0; j < grid[0].length; j++){
                if ( grid[i][j]){
                    myGrid += "  |";
                }
                else{
                    myGrid += " X|";
                }
                if ( j + 1 == grid[0].length){
                    myGrid += "\n";
                    for ( int f = 0; f < grid.length; f++){
                        myGrid += " - ";
                    }
                    myGrid += "\n";
                }
            }
        }
        System.out.println(myGrid);
    }

    private static void clueInRows(boolean grid[][]){
        System.out.println("All clues in rows");
        int[][] clues = new int[grid.length][25];
        int incrementRow = 0;
        int incrementClue = 0;
        int count = 0;
        for ( int row = 0; row < grid.length; row++){
            for ( int column = 0; column < grid[0].length; column++){
                if ( grid[row][column] ){
                    count++;
                }
                if ( count != 0 && (grid[row][column] == false) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
                if ( count != 0 && (column + 1 >= grid[0].length) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
            }
            incrementClue = 0;
            incrementRow++; 
        }
        // print all of it
        for ( int row = 0; row < clues.length; row++){
            System.out.println("Row: " + (row+1) + " ");
            for ( int clue = 0; clue < clues.length; clue++){
                if (clues[row][clue] != 0){
                    System.out.print(clues[row][clue] + " ");
                }
            }
            System.out.println("\n");
        }
    }
    // Row is a parameter
    private static String clueInRows(int row, boolean grid[][]){
        //FIXME
        int[][] clues = new int[25][25];
        int incrementRow = 0;
        int incrementClue = 0;
        int count = 0;
            for ( int column = 0; column < grid[0].length; column++){
                if ( grid[row][column] ){
                    count++;
                }
                if ( count != 0 && (grid[row][column] == false) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
                if ( count != 0 && (column + 1 >= grid[0].length) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
            }
            incrementClue = 0;
            incrementRow++; 
        
        // print all of it
        String returnMe = "";
            for ( int clue = 0; clue < clues.length; clue++){
                if (clues[row][clue] != 0){
                    returnMe = clues[row][clue] + " ";
            }
        }
        return returnMe;
    }
    private static void clueInColumns(boolean grid[][]){
         //FIXME
         int[][] clues = new int[grid.length][25];
         int incrementRow = 0;
         int incrementClue = 0;
         int count = 0;
         for ( int column = 0; column < grid.length; column++){
             for ( int row = 0; row < grid[0].length; row++){
                 if ( grid[row][column] ){
                     count++;
                 }
                 if ( count != 0 && (grid[row][column] == false) ){
                     clues[incrementRow][incrementClue] = count;
                     incrementClue++;
                     count = 0;
                 }
                 if ( count != 0 && (row + 1 >= grid[0].length) ){
                     clues[incrementRow][incrementClue] = count;
                     incrementClue++;
                     count = 0;
                 }
             }
             incrementClue = 0;
             incrementRow++; 
         }
         // print all of it
         for ( int column = 0; column < clues.length; column++){
            System.out.println("Column " + (column+1));
             for ( int clue = 0; clue < clues.length; clue++){
                 if (clues[column][clue] != 0){
                     System.out.print(clues[column][clue] + " ");
                 }
             }
             System.out.println("\n");
         }
    }
    private static void clueInColumns(int column, boolean grid[][]){
        //FIXME
        int[][] clues = new int[grid.length][25];
        int incrementRow = 0;
        int incrementClue = 0;
        int count = 0;
            for ( int row = 0; row < grid[0].length; row++){
                if ( grid[row][column] ){
                    count++;
                }
                if ( count != 0 && (grid[row][column] == false) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
                if ( count != 0 && (row + 1 >= grid[0].length) ){
                    clues[incrementRow][incrementClue] = count;
                    incrementClue++;
                    count = 0;
                }
            }
            incrementClue = 0;
            incrementRow++; 
        // print all of it
            for ( int clue = 0; clue < clues.length; clue++){
                if (clues[column][clue] != 0){
                    System.out.println(clues[column][clue] + " ");
                }
            }
   }
}
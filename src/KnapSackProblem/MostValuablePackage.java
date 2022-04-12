package KnapSackProblem;

import java.util.Arrays;

/*
There is one backpack which strength allows packing 10kg.
Find the best way to fill the backpack so that maximize value.
There are few items:
1. Iphone: weight = 3 kg, value = 1000 pln
2. Tablet: weight = 4 kg, value = 1200 pln
3. PowerBank: weight = 1 kg value = 200 pln
4. MacBook: weight = 7 kg value = 2300 pln
5. FlashLight: weight = 0,5 kg value = 180 pln


 */
public class MostValuablePackage {
    static int [] iValue = {0, 1000,1200, 200, 2300, 180 };
     static int [] iWeight = {0, 3, 4, 1, 7, 1};
     static String [] items = {"", "Iph", "Tab", "Pow", "Mac", "Fla"};


    public static void main(String[] args) {
        // i - row  j - column
        int [] [] grid = new int[6][11];
        String [][] itemsFilled = new String[6][11];


        printValueGrid(grid);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] =returnValue(grid,itemsFilled,i,j);
            }
            System.out.println();
        }

        printValueGrid(grid);
        printNameGrid(itemsFilled);

    }

    private static int returnValue (int[][] grid, String[] [] itemsFilled, int i, int j){
        int value =grid[i-1][j];

        int newValue = iValue[i] + grid[i-1][j - iWeight[i]];

        if (j < iWeight[i]){
            itemsFilled[i][j] = itemsFilled[i-1][j];
            return value;
        }

        if (newValue > value) {
            value = newValue;
            itemsFilled[i][j] = items [i];
            if (grid[i-1][j - iWeight[i]] >0)
                itemsFilled[i][j] += itemsFilled [i-1][j - iWeight[i]];
        } else
            itemsFilled[i][j] = itemsFilled[i-1][j];

        return value;
    }

    private static void printValueGrid(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] <10)
                    System.out.print(grid[i][j] +"    ");
                else if (grid[i][j] <100)
                    System.out.print(grid[i][j] +"   ");
                else if (grid[i][j] <1000)
                    System.out.print(grid[i][j] +"  ");
                else if (grid[i][j] <10000)
                    System.out.print(grid[i][j] +" ");
            }
            System.out.println();
        }

    }

    private static void printNameGrid(String[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

}

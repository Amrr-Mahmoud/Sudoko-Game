
package sudoku;

import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Numbers {
    
    int grid[][] = new int [9][9];
    
    public int[][] generateNumberGrid(){
        
        Random r = new Random();
        int k = r.nextInt(9);
        int n = r.nextInt(9);

        for(int i = 0; i < 9; i++) {
           k = n;
           if (i == 8) {
               int sum = 0;
               for (int x = 0; x < 9; x++) {
                   sum += grid[x][0];
               }
               k = 45 - sum;
           }
           for(int j=0;j<9;j++) {
               if(k <= 9){
                   grid[i][j] = k;
                   k++;
               } else {
                   k=1;
                   grid[i][j]=k;
                   k++;
               }
            }
           
            n = k + 3;
            
            if(k == 10)
                n = 4;
            
            if(n > 9)
                n = (n % 9) + 1;
        }  
        
        return grid;
    }
    
    public void removeCells () {
        
        for (int i = 0; i < 65; i++) {
            Random r = new Random();
            int x = r.nextInt(9);
            int y = r.nextInt(9);
            grid[x][y] = 0;
          
        }
    }
    
    public void checkCells () {
        
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                   Alert check = new Alert(AlertType.INFORMATION);
                   check.setTitle("Error");
                   check.setHeaderText(null);
                   check.setContentText("Some fields still empty");
                   check.showAndWait();
                   return;
                }
                
                if (grid[i][j] != 45) {
                    flag = false;
                }
            }
        }
        if (flag == false) {
            Alert check = new Alert(AlertType.INFORMATION);
            check.setTitle("Error");
            check.setHeaderText(null);
            check.setContentText("You Lose");
        
        } else {
            Alert check = new Alert(AlertType.INFORMATION);
            check.setTitle("Success");
            check.setHeaderText(null);
            check.setContentText("You Win");
        }
    }
}





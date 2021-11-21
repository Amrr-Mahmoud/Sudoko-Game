
package sudoku;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sudoku extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Numbers num = new Numbers();
        
        VBox menu = new VBox(40);
        menu.setPrefSize(500, 500);
        menu.setAlignment(Pos.CENTER);
        
        Scene mainMenu = new Scene(menu); 
        
        Button start = new Button();
        Button exit = new Button();
                
        start.setText("Start Game");
        start.setPrefSize(100, 29);
        start.setStyle("-fx-border-color: black;");
        
        exit.setOnAction(e -> Platform.exit());
        exit.setText("Exit");
        exit.setPrefSize(100, 29);
        exit.setStyle("-fx-border-color: black;");
       
        
        menu.getChildren().add(start);
        menu.getChildren().add(exit);
        
        int x [][] = num.generateNumberGrid();
        
        num.removeCells();
        
        GridPane board = new GridPane();

        for (int col = 0; col < 9; col++) {                       
            for (int row = 0; row < 9; row++) {
                
                GridPane box = new GridPane();
                box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 5, 2; -fx-padding: 5;");
                TextField cell = new TextField();
                cell.setText("" + x [row][col]);
                if (x [row][col] == 0) {
                    cell.setText("");
                }
                cell.setStyle("-fx-pref-width: 2em;");
                cell.setStyle("-fx-pref-height: 5em");
                cell.setAlignment(Pos.CENTER);
                cell.setFont(javafx.scene.text.Font.font(20));
                GridPane.setConstraints(cell, col, row);
                box.getChildren().add(cell);
                GridPane.setConstraints(box, col, row);
                board.getChildren().add(box);       
            }
        }

        board.setPadding(new Insets(10,20,20,25));
        
        Button check = new Button();
        check.setOnAction(e -> {
            num.checkCells();
  
        });
        
        check.setText("Check");
        check.setAlignment(Pos.BOTTOM_CENTER);
        check.setPrefWidth(100);
        board.add(check ,4,10);
        
        start.setOnAction(e -> {
            primaryStage.getScene().setRoot(board);
        });
        
        primaryStage.setResizable(true);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(mainMenu);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
}

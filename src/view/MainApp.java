package view;/**
 * Created by designAi on 16.10.2016.
 */

import exception.GameException;
import exception.GameOverException;
import game.*;
import games.Connect6;
import games.TicTacToe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class MainApp extends Application implements EventHandler<ActionEvent> {
    private Label label;
    private Stage primaryStage;
    private Connect6 game = new Connect6();
    private Button[][] buttons =new Button[15][15];
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Connect6");
        try {
            game.start();
        } catch (GameException e) {
            e.printStackTrace();
        }
        initRootLayout();
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout() {

        AnchorPane root = new AnchorPane();
        label = new Label("Игру выиграл: ");
        Button button = new Button("Отменить");
        button.setOnAction(this);
        GridPane layout = buildGameField();
        root.getChildren().addAll(layout, label, button);
        AnchorPane.setBottomAnchor(label, 5.0);
        AnchorPane.setLeftAnchor(label, 15.0);
        AnchorPane.setRightAnchor(button, 15.0);
        AnchorPane.setBottomAnchor(button, 15.0);

        AnchorPane.setRightAnchor(layout, 15.0);
        AnchorPane.setLeftAnchor(layout, 15.0);
        Scene scene = new Scene(root, 430,440);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private GridPane buildGameField() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);

        layout.setGridLinesVisible(true);

        for (int i = 0, lenI = 15; i < lenI; i++ ) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(20);
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(20);


            layout.getRowConstraints().add(i,rowConstraints);
            layout.getColumnConstraints().add(i,columnConstraints);

            for (int j = 0, lenJ = 15; j < lenJ; j++) {
                Button button = new Button();
                button.setText(" ");
                button.setMaxHeight(Double.MAX_VALUE);
                button.setMaxWidth(Double.MAX_VALUE);
                button.setOnAction(new Listener(i,j));
                buttons[i][j] = button;
                layout.add(button,i,j);
            }
        }
        return layout;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        List gameHistory = game.getHistory();
        int n = gameHistory.size();
        Step step =(Step) gameHistory.get(n-1);
        System.out.println(step);
        try {
            if(game.undoStep(1)){
                buttons[step.getX()][step.getY()].setText(" ");
            }
        }catch (GameOverException e){
            label.toString();
        }

    }


    public class Listener  extends Step implements EventHandler<ActionEvent> {

       public Listener(int x, int y) {
           super(x, y);
       }

       @Override
        public void handle(ActionEvent event) {
           Button button =(Button) event.getSource();
           Player player = game.getCurrentActivePlayer();
           String text;
           try {
               if(game.makeStep(new Step(getX(),getY()))){
                text =  game.definePlayer(player)? "X" : "O";
                button.setText(text);
               }
                getWinner();

           } catch (GameException ex){
                ex.printStackTrace();
           }

       }

    }

     public void getWinner() throws GameException {
            Player player = game.checkWinner();
            if(player != null){
                gameOver("Игру выиграл: "+player.getName());
                game.undoStep(game.getHistory().size());
                refresh();
                game.start();
            }
            if(game.isFileldFilled()){
                gameOver("Ничья");
                game.undoStep(game.getHistory().size());
                refresh();
                game.start();
            }
     }

    private void refresh() {
        for (int i = 0, lenI = 15; i < lenI; i++ ) {
            for (int j = 0, lenJ = 15; j < lenJ; j++) {
                buttons[i][j].setText(" ");
            }
        }
    }

    public void gameOver(String gameOver){
        System.out.println("");
        label.setText(gameOver);
    }

}

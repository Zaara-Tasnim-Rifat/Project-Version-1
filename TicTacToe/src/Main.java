/**
 * Created by Zaara Tasnim Rifat on 5/8/2016.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.image.*;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tic Tac Toe");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        //grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(2);

        Label heading = new Label("TIC TAC TOE");
        heading.setId("header");
        grid.setConstraints(heading, 42, 0);


        Label welcome = new Label("Welcome .....");
        welcome.setId("Welcome");
        GridPane.setConstraints(welcome, 35, 8);
        Label user = new Label();
        user.setId("user");
        grid.setConstraints(user, 50, 8);



        TextField username = new TextField("Player1");
        username.setMaxWidth(230);
        username.setMaxHeight(70);
        username.setPromptText("username");
       grid.setConstraints(username, 42, 17);


        /*HBox welcomeMessage = new HBox(welcome,user);
       // GridPane.setConstraints(welcomeMessage,25,10);
        //welcomeMessage.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(10, welcomeMessage, username);
        vBox.setAlignment(Pos.CENTER);*/

        user.textProperty().bind(username.textProperty());



        Label message = new Label("Enter Your Name :");
        message.setId("Welcome");
        grid.setConstraints(message, 42, 15);

        Button playbutton = new Button("Play Tic Tac Toe!!!");
        playbutton.setId("playbutton");
        grid.setConstraints(playbutton, 42, 25);

        //playbutton.setOnAction(e-> window.setScene(scene2));
        //mainmenu

        VBox mainmenu = new VBox(15);
        Label menu = new Label("  MAIN MENU  ");
        Button newgame = new Button(" Start a New Game ");
        Button savedgame = new Button ("I have a Saved One!");
        Button scoreboard = new Button("       Score Board      ");
        Button setting = new Button("          Settings          ");
        mainmenu.setAlignment(Pos.CENTER);


        //start a new game

        Label startgame = new Label("   Start a New Game   ");
        startgame.setId("Welcome");
        HBox numPlayers = new HBox(80);
        numPlayers.setAlignment(Pos.CENTER);

        Label p = new Label("Players: ");
        ChoiceBox<String> player = new ChoiceBox<> ();
        player.getItems().addAll("Single", "Multiple");
        player.setValue("Single");
        numPlayers.getChildren().addAll(p,player);
        player.setId("choice-box");

        HBox level = new HBox(80);
        Label l = new Label("Level: ");

        ChoiceBox<String> levelchoice = new ChoiceBox<> ();
        levelchoice.getItems().addAll("Easy", "Medium", "Hard");
        level.getChildren().addAll(l,levelchoice);
        levelchoice.setValue("Easy");
        levelchoice.setId("choice-box");
        level.setAlignment(Pos.CENTER);

        HBox network = new HBox(80);
        Label n = new Label("Network: ");

        ChoiceBox<String> netchoice = new ChoiceBox<> ();
        netchoice.getItems().addAll("Play Online", "Play Offline");
        netchoice.setValue("Play Offline");
        network.getChildren().addAll(n,netchoice);
        network.setAlignment(Pos.CENTER);
        netchoice.setId("choice-box");

        Button nextScene3 = new Button("Play!!");
        VBox startnewgame = new VBox(30);
        startnewgame.setAlignment(Pos.CENTER);

       // Image three = new Image("")
        ///
        /*GridPane gameboard = new GridPane();
        gameboard.setPadding(new Insets(10, 10, 10, 10));
        gameboard.setVgap(0);
        gameboard.setHgap(0);*/
        HBox Hboard1 = new HBox();
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        button1.setMinSize(130,130);
        button2.setMinSize(130,130);
        button3.setMinSize(130,130);
        Hboard1.setAlignment(Pos.CENTER);
        Hboard1.getChildren().addAll(button1,button2,button3);
        /*gameboard.add(button1,9,9);
        gameboard.add(button2,10,9);
        gameboard.add(button3,11,9);*/



        HBox Hboard2 = new HBox();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        button4.setMinSize(130,130);
        button5.setMinSize(130,130);
        button6.setMinSize(130,130);
        Hboard2.setAlignment(Pos.CENTER);
        Hboard2.getChildren().addAll(button4,button5,button6);
        /*gameboard.add(button4,9,10);
        gameboard.add(button5,10,10);
        gameboard.add(button6,11,10);*/

        HBox Hboard3 = new HBox();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        button7.setMinSize(130,130);
        button8.setMinSize(130,130);
        button9.setMinSize(130,130);
        Hboard3.setAlignment(Pos.CENTER);
        Hboard3.getChildren().addAll(button7,button8,button9);
        /*gameoard.add(button7,9,11);
        gameboard.add(button8,10,11);
        gameboard.add(button9,11,11);*/
        //Label name = new Label(user.getText());

        //gameboard.add(name,60,60);
        VBox Vboard = new VBox(0);
        //Vboard.getChildren().addAll(Hboard1,Hboard2,Hboard3);
        Label name = new Label(user.getText());
        System.out.println(user.getText());
        Vboard.getChildren().addAll(name,Hboard1,Hboard2,Hboard3);
        //board.getChildren().add(name);

        //gameboard.add(name,60,60);

        Vboard.setAlignment(Pos.CENTER);






        //scences
        Scene scene4 = new Scene(Vboard,800,700);
        scene4.getStylesheets().add("scene4.css");


        startnewgame.getChildren().addAll(startgame,numPlayers,level,network,nextScene3);
        Scene scene3 = new Scene(startnewgame,800,700);
        scene3.getStylesheets().add("scene3.css");


        mainmenu.getChildren().addAll(menu,newgame,savedgame,scoreboard,setting);
        Scene scene2 = new Scene(mainmenu,800,700);
        scene2.getStylesheets().add("scene2.css");
        // switch to scene

        playbutton.setOnAction(e-> window.setScene(scene2));
        newgame.setOnAction(e-> window.setScene(scene3));
        nextScene3.setOnAction(e-> window.setScene(scene4));

        grid.getChildren().addAll(heading,message,username,welcome,user,playbutton);
        Scene scene = new Scene(grid, 800, 700);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();
    }


}
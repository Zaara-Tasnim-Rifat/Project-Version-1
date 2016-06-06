/**
 * Created by Zaara Tasnim Rifat on 5/8/2016.
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import  javafx.scene.image.*;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {

    Stage window;
    String playerName = "Player1 ";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tic Tac Toe");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(2);

        Label heading = new Label("TIC TAC TOE");
        heading.setId("header");                    // import from css file how the style should be like
        grid.setConstraints(heading, 42, 0);


        Label welcome = new Label("Welcome .....");
        welcome.setId("Welcome");
        grid.setConstraints(welcome, 35, 8);
        Label user = new Label();
        user.setId("user");
        grid.setConstraints(user, 50, 8);
        Label warning= new Label("");
        grid.setConstraints(warning,42,18);
        //warning.setFont();



        TextField username = new TextField("Player1");
       // username.setMaxWidth(230);
        //username.setMaxHeight(70);
        username.setPromptText("username"); // it doesnt work
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
        ChoiceBox<String> player = new ChoiceBox<String> ();
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


        //building scene #4
        Medium step1 = new Medium(playerName);

        HBox [] Hboard = new HBox[3];
        for(int i=0 ; i<3 ; i++)
        {
            Hboard[i] = new HBox();
        }
        HBox winnerName = new HBox();
        winnerName.setAlignment(Pos.CENTER_RIGHT);
        winnerName.getChildren().add(step1.winner);

        for(int i=0 ; i<3 ;i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                Hboard[i].setAlignment(Pos.CENTER_LEFT);
                Hboard[i].getChildren().add(step1.buttons[i][j]);

            }



        }
        Hboard[0].getChildren().add(winnerName);

        HBox startFirst = new HBox(150);
        startFirst.setAlignment(Pos.BOTTOM_LEFT);
        startFirst.getChildren().addAll(step1.computerStart, step1.playerStart);

        HBox dummyBox = new HBox();
        Label dummyLabel = new Label("      ");
        dummyBox.getChildren().add(dummyLabel);


        VBox Vboard = new VBox(0);
        Vboard.setPadding(new Insets(20, 20, 20, 100));




        Label name = new Label(playerName);
        name.setId("Welcome");
        Vboard.getChildren().addAll(Hboard[0],Hboard[1],Hboard[2],dummyBox,startFirst);
        //Vboard.getChildren().add(name);

        Vboard.setAlignment(Pos.CENTER_LEFT);


        //building scene 5//
        Mid medium = new Mid();

        HBox [] Hboard2 = new HBox[3];
        for(int i=0 ; i<3 ; i++)
        {
            Hboard2[i] = new HBox();
        }
        HBox winnerName2 = new HBox();
        winnerName2.setAlignment(Pos.CENTER_RIGHT);
        winnerName2.getChildren().add(medium.winner);
        VBox score = new VBox(0);
        score.getChildren().addAll(medium.total,medium.won, medium.lost, medium.draw);
        medium.total.setId("score");
        medium.won.setId("score");
        medium.lost.setId("score");
        medium.draw.setId("score");
        score.setAlignment(Pos.CENTER_RIGHT);


        Hboard2[0].setAlignment(Pos.CENTER_LEFT);
        Hboard2[0].getChildren().addAll(medium.box[0],medium.box[1],medium.box[2], winnerName2);

        Hboard2[1].setAlignment(Pos.CENTER_LEFT);
        Hboard2[1].getChildren().addAll(medium.box[3],medium.box[4],medium.box[5],dummyBox,score);

        Hboard2[2].setAlignment(Pos.CENTER_LEFT);
        Hboard2[2].getChildren().addAll(medium.box[6],medium.box[7],medium.box[8]);


        //Hboard2[0].getChildren().add(winnerName);

        HBox backButton2 = new HBox(150);
        backButton2.setAlignment(Pos.BOTTOM_LEFT);
        backButton2.getChildren().addAll(medium.reload, medium.back);




        VBox Vboard2 = new VBox(0);
        Vboard2.setPadding(new Insets(20, 20, 20, 100));

        Label name2 = new Label(playerName);
        name.setId("Welcome");
        Vboard2.getChildren().addAll(Hboard2[0],Hboard2[1],Hboard2[2],dummyBox,backButton2 );
        //Vboard.getChildren().add(name);

        Vboard2.setAlignment(Pos.CENTER_LEFT);


        //building scene #6

        Online online = new Online();
        HBox [] Hboard3 = new HBox[3];
        for(int i=0 ; i<3 ; i++)
        {
            Hboard3[i] = new HBox();
        }
        HBox winnerName3 = new HBox();
        winnerName3.setAlignment(Pos.CENTER_RIGHT);
        winnerName3.getChildren().add(online.winner);
        VBox score1 = new VBox(0);
//        score1.getChildren().addAll(online.total,online.won, online.lost, online.draw);
//        online.total.setId("score");
     //   online.won.setId("score");
      //  online.lost.setId("score");
        //online.draw.setId("score");
        score1.setAlignment(Pos.CENTER_RIGHT);


        Hboard3[0].setAlignment(Pos.CENTER_LEFT);
        Hboard3[0].getChildren().addAll(online.buttons[0][0],online.buttons[0][1],online.buttons[0][2], winnerName2);

        Hboard3[1].setAlignment(Pos.CENTER_LEFT);
        Hboard3[1].getChildren().addAll(online.buttons[1][0],online.buttons[1][1],online.buttons[1][2],dummyBox,score);

        Hboard3[2].setAlignment(Pos.CENTER_LEFT);
        Hboard3[2].getChildren().addAll(online.buttons[2][0],online.buttons[2][1],online.buttons[2][2],online.reload);


        //Hboard2[0].getChildren().add(winnerName);

        HBox backButton3 = new HBox(150);
        backButton3.setAlignment(Pos.BOTTOM_LEFT);
       // backButton3.getChildren().addAll(online.reload, online.back);




        VBox Vboard3 = new VBox(0);
        Vboard3.setPadding(new Insets(20, 20, 20, 100));

        Label name3 = new Label(playerName);
        name3.setId("Welcome");
        Vboard3.getChildren().addAll(Hboard3[0],Hboard3[1],Hboard3[2],dummyBox,backButton3,online.O, online.X );
        //Vboard.getChildren().add(name);

        Vboard3.setAlignment(Pos.CENTER_LEFT);


















        //scences

        Scene scene6 = new Scene(Vboard3,1000,700);
        scene6.getStylesheets().add("scene4.css");


        Scene scene5 = new Scene(Vboard2,1000,700);
        scene5.getStylesheets().add("scene4.css");

        Scene scene4 = new Scene(Vboard,1000,700);
        scene4.getStylesheets().add("scene4.css");


        startnewgame.getChildren().addAll(startgame,numPlayers,level,network,nextScene3);
        Scene scene3 = new Scene(startnewgame,900,700);
        scene3.getStylesheets().add("scene3.css");


        mainmenu.getChildren().addAll(menu,newgame,savedgame,scoreboard,setting);
        Scene scene2 = new Scene(mainmenu,900,700);
        scene2.getStylesheets().add("scene2.css");

        grid.getChildren().addAll(heading,message,username,welcome,user,warning,playbutton);
        Scene scene = new Scene(grid, 900, 700);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        // switch to scene

        playbutton.setOnAction(e-> {
            playerName = username.getText();
            if(playerName.equals(""))
            {
                warning.setText("Playername is Required !");
            }
            else {
                window.setScene(scene2);
            }

            System.out.println(playerName);

        });


        newgame.setOnAction(e-> window.setScene(scene3));


        nextScene3.setOnAction(e-> {            //switching to scene4
            //window.setScene(scene4);
            String gameLevel =  levelchoice.getValue();
            String gameNetwork = netchoice.getValue();
            String gamePerson = player.getValue();

            if(gameNetwork.equals("Play Offline"))
            {
                if(gameLevel.equals("Easy")&& gamePerson.equals("Single"))
                {
                    window.setScene(scene4);
                    step1.playerStart.setOnAction(event-> step1.firstTurn = 'p');
                    step1.computerStart.setOnAction(event->step1.firstTurn = 'c');
                    step1.easy(playerName);
                }
                else if(gameLevel.equals("Medium")&& gamePerson.equals("Single"))
                {
                    //step1.medium(playerName);
                    window.setScene(scene5);
                    medium.mid(playerName);
                    medium.back.setOnAction(event-> window.setScene(scene));

                }
            }
            else{
                window.setScene(scene6);
                online.startOnline(playerName);
                online.online();

            }
            System.out.println(playerName);
            //step1.easy(playerName);
        });


        window.show();
    }


}
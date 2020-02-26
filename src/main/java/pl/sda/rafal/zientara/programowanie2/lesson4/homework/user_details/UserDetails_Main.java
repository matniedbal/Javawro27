package pl.sda.rafal.zientara.programowanie2.lesson4.homework.user_details;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserDetails_Main  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/UserData.fxml"));
        primaryStage.setTitle("User data");
        Scene scene = new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
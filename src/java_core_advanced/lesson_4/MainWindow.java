package java_core_advanced.lesson_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainWindow extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root,400,400);
        scene.getStylesheets().add(0, "java_core_advanced/lesson_4/styles/my.css");

        primaryStage.setTitle("FXML Test");
        primaryStage.getIcons().add(new Image("java_core_advanced/lesson_4/res/geek.png"));
        primaryStage.setWidth(400);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

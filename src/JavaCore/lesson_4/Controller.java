package JavaCore.lesson_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private boolean isSender;

    @FXML
    ScrollPane pane;

    @FXML
    TextField message;

    @FXML
    VBox vBox;


    public void sendMessage(ActionEvent actionEvent) {
        HBox hBox = new HBox();
        Label messageLabel = new Label();
        Label timeLabel = new Label();
        if (!message.getText().equals("")) {
            pane.vvalueProperty().bind(vBox.heightProperty());
            hBox.setPadding(new Insets(5, 20, 5, 20));
            hBox.setPrefWidth(400);
            messageLabel.setText(message.getText());
            messageLabel.setWrapText(true);
            messageLabel.setMaxWidth(250);
            if (isSender) {
                messageLabel.getStyleClass().add("my-label-right");
                hBox.getChildren().add(timeLabel);
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.getChildren().add(messageLabel);
                isSender = false;
            } else {
                messageLabel.getStyleClass().add("my-label-left");
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.getChildren().add(messageLabel);
                hBox.getChildren().add(timeLabel);
                isSender = true;
            }
            timeLabel.getStyleClass().add("my-label-time");
            SimpleDateFormat date = new SimpleDateFormat("HH:mm");
            timeLabel.setText(date.format(new Date()));
            vBox.getChildren().add(hBox);
            message.setText("");
        }
    }

    public void clearPane(ActionEvent actionEvent) {
        vBox.getChildren().clear();
    }
}

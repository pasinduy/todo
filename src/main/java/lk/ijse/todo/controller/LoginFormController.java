package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 12:14 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.todo.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private AnchorPane root;
    private User model = new User();

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException {
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        //after login success, system should navigate to the dashboard
        boolean isValid = User.check(username,password);
        if(isValid) {
            new Alert(Alert.AlertType.CONFIRMATION,"done").show();
            navigateToMainWindow();
        }else{
            new Alert(Alert.AlertType.ERROR,"Incorrect User name or Password !!!").show();
        }
    }

    private void navigateToMainWindow() throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/main_form.fxml"));
        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("ToDo");
    }

    @FXML
    void hyperSignUpOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signup_form.fxml"));

        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign Up");
    }
}

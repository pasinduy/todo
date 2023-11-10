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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.todo.dto.LoginDto;
import lk.ijse.todo.model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private AnchorPane root;
    private LoginModel model = new LoginModel();

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException {
        String userName = txtUserName.getText();
        String pw = txtPassword.getText();

        var dto = new LoginDto(userName, pw);
        LoginDto isLogin = model.login(dto);

        navigateToMainWindow();
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

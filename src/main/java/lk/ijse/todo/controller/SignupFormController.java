package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 12:18 AM   
*/


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.todo.dto.SignUpDto;
import lk.ijse.todo.model.SignUpModel;

import java.io.IOException;

public class SignupFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPw;

    @FXML
    private TextField txtUserName;

    private SignUpModel model = new SignUpModel();

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String email = txtEmail.getText();
        String username = txtUserName.getText();
        String password = txtPw.getText();

        var dto = new SignUpDto(email, username, password);
        try {
            boolean isSaved = model.registerUser(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearFields() {
        txtEmail.clear();
        txtUserName.clear();
        txtPw.clear();
    }

    @FXML
    void hyperLoginHereOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));

        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage primaryStage = (Stage) root.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
    }
}

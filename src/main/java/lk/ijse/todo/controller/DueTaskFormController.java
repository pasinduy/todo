package lk.ijse.todo.controller;

/*
    @author DanujaV
    @created 11/7/23 - 3:46 AM   
*/

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.todo.dto.tm.DueTm;
import lk.ijse.todo.model.Task;

import java.sql.SQLException;

public class DueTaskFormController {

    @FXML
    private TableColumn<?, ?> colComplete;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<DueTm> tblDue;
    private ObservableList<DueTm> obList;
    private Task model = new Task();

    public void initialize() throws SQLException {
        setCellValueFactory();
        loadDueTasks();
    }

    private void setCellValueFactory() {
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colComplete.setCellValueFactory(new PropertyValueFactory<>("btnComplete"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btnDelete"));
    }

    private ObservableList<DueTm> loadDueTasks() throws SQLException {
        ObservableList<DueTm> obList = FXCollections.observableArrayList();

        // reason for using a for loop here is to add event handlers to the buttons in the table
        for (int i = 0; i < obList.size(); i++) {
            obList.get(i).getBtnComplete().setOnAction(event -> {
                // here you need to write the code to mark the task as complete on database table
                System.out.println("Complete button clicked");
            });

            obList.get(i).getBtnDelete().setOnAction(event -> {
                // here you need to write the code to delete the task from FX table and database table as well.
                System.out.println("Delete button clicked");
            });
        }
        tblDue.setItems(obList);
        return obList;
    }

}

package lk.ijse.todo.dto;

import javafx.scene.control.ButtonBase;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String task_id;
    private String description;
    private String Due_date;

    public ButtonBase getBtnDelete() {
        ButtonBase btnDelete = null;
        return btnDelete;
    }

    public ButtonBase getBtnComplete() {
        ButtonBase btnComplete = null;
        return btnComplete;
    }
}

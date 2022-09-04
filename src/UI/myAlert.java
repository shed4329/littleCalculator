package UI;

import javafx.scene.control.Alert;

public class myAlert {

    public static void alertError(String errorText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("error");
        alert.setHeaderText(errorText);
        alert.showAndWait();
    }
}

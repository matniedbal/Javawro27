package pl.sda.rafal.zientara.programowanie2.lesson4.homework.user_details;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class UserDataController {

    @FXML
    public TextField nameTextField;
    @FXML
    public TextField ageTextField;
    @FXML
    public TextField mailTextField;
    @FXML
    public TextField phoneTextField;

    public UserDataController() {
    }

    @FXML
    private void initialize(){

    }

    @FXML
    public void loadAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(new Stage());
        String path = file.getAbsolutePath();
        if(file != null) {
            insertDataOnScreen(path);
        }
    }

    private void insertDataOnScreen(String path) {
        Converter getData = new Converter(path);
        nameTextField.setText(getData.userDetails().getName());
        ageTextField.setText(getData.userDetails().getAge());
        mailTextField.setText(getData.userDetails().getMail());
        phoneTextField.setText(getData.userDetails().getPhone());
    }
}

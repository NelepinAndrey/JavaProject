package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField login_field;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {

        loginSignUpButton.setOnAction(event -> {

            signUpNewUser();

        });
    
    }

    private void signUpNewUser() {
        loginSignUpButton.getScene().getWindow().hide();
        DatabaseHandler dbHandler = new DatabaseHandler();

        String first_name = signUpName.getText();
        String last_name = signUpLastName.getText();
        String login = login_field.getText();
        String password = password_field.getText();

        User user = new User(first_name, last_name, login, password);

        dbHandler.signUpUser(user);
    }
}

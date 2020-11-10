/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tis_fx.UserDAOImpl;

/**
 *
 * @author HP
 */
public class SignUpController {

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button btnSignUp;

    @FXML
    private CheckBox studentCheckBox;

    @FXML
    void addUser(ActionEvent event) {
        boolean studentStatus = false;
        UserDAOImpl dAOImpl = new UserDAOImpl();
        List<User> userList = dAOImpl.getAllUsers();
        boolean isMatched = false;

        if (studentCheckBox.isSelected()) {
            studentStatus = true;
        }

        for (User user : userList) {
            if (user.getName().equals(signUpName.getText())) {
                isMatched = true;
            }
        }
        if (!isMatched) {
            User user = new User(signUpName.getText(), signUpPassword.getText(), studentStatus);
            dAOImpl.insertUser(user);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/Event_Screen.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("New Window");
                stage.setScene(scene);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        } else {
            showErrorMessage("This username has already taken, please write another username and password!");
            signUpName.setText("");
            signUpPassword.setText("");
        }

    }

    private void showErrorMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }

}

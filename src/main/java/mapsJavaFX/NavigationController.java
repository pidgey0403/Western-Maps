package mapsJavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;

public class NavigationController {

  public void goToProfile(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SignupController.class.getResource("/profile.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    changeScene(scene, event);
  }

  public void goToHelp(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SignupController.class.getResource("/help.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    changeScene(scene, event);
  }

  public void goBack(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SignupController.class.getResource("/mainView.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    changeScene(scene, event);
  }

  public void logout(ActionEvent event) throws IOException {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Logout");
    alert.setHeaderText("You're about to log out");
    alert.setContentText("Are you sure?");

    if (alert.showAndWait().get() == ButtonType.OK){
      FXMLLoader fxmlLoader = new FXMLLoader(SignupController.class.getResource("/login.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      changeScene(scene, event);
    }
  }

  //  public void goToLogin(ActionEvent event) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(SignupController.class.getResource("/login.fxml"));
//    Scene scene = new Scene(fxmlLoader.load());
//    changeScene(scene, event);
//  }

  private void changeScene(Scene scene, ActionEvent event) {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    stage.centerOnScreen();
  }
}

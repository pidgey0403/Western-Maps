package mapsJavaFX;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import maps.*;
import java.lang.String;

import java.io.IOException;
import java.util.List;

public class editBuildingController {
    static Stage stage;
    static Application app;
    private Tab selectedTab;
    @FXML
    private Text currBuildingName;
    @FXML
    private TextField newBldName;
    @FXML
    private Button conEditBuild;
    @FXML
    private Button cancEditBuild;
    private Building selectedBuilding;

  /**
   * Called to set up the app
   * @param newApp referring to the map application
   */
  public static void setApp(Application newApp) {
    app = newApp;
  }

  
 
  /**
   * Sets stage of application
   * @param newStage stage to be set
   */
  public static void setStage(Stage newStage) {
    stage = newStage;
  }

  /**
   * @return current application stage
   */
  public static Stage getStage() {
    return stage;
  }

  @FXML
  public void initialize() {
    selectedTab = ControllerMediator.getInstance().getBuildingTabObject();
    List<Building> allBuildings = ControllerMediator.getInstance().getApplication().getBuildings();
    for (Building building : allBuildings) {
      if (building.getName().equals(selectedTab.getText())) {
        selectedBuilding = building;
        break;
      }
    }
    currBuildingName.setText(selectedBuilding.getName());
  }

  /**
   * Pressing [Save Changes] button takes user to input.
   */
  public void onSaveBldEdit() {
    List<Building> allBuildings = ControllerMediator.getInstance().getApplication().getBuildings();
    String newName = newBldName.getText();
    if(!(newName.equals(""))){
      // String prevName = selectedBuilding.getName();
      for (Building building : allBuildings) {
        if (building.getName().equals(newName)) {
          return;
        }
      }
      selectedBuilding.setName(newName);
      selectedTab.setText(newName);

    }
  }


}

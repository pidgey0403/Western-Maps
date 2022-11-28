package maps;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import javafx.scene.image.Image;

/**
 * Stores information regarding a floor
 */
public class Floor {
  final int level;
  final String name;
  String imagePath;
  Image image;

  /**
   * Each index corresponds to a POIType, for example: pois[POIType.classroom] is all the pois with
   * type POIType.classroom.
   */
  final List<POI>[] pois;

  /**
   * Constructor without an image path
   * 
   * @param level integer corresponding to the floor's level
   * @param name the name of the floor
   */
  @SuppressWarnings("unchecked")
  Floor(int level, String name) {
    this.level = level;
    this.name = name;
    this.imagePath = "";
    this.image = null;
    this.pois = (ArrayList<POI>[]) new ArrayList[POIType.values().length];
    for (int i = 0; i < POIType.values().length; ++i) {
      this.pois[i] = new ArrayList<>();
    }
  }

  /**
   * Constructor with an image path. Loads the image and stores it in memory
   * 
   * @param level integer corresponding to the floor's level
   * @param name the name of the floor
   * @param imagePath absolute path to the image of this floor
   */
  Floor(int level, String name, String imagePath) {
    this(level, name);
    this.imagePath = imagePath;
    this.image = new Image(new File(Util.getRootPath() + imagePath).toURI().toString());
  }

  public String toString() {
    StringBuilder str = new StringBuilder(this.name);
    for (List<POI> poiList : this.pois) {
      for (POI poi : poiList) {
        str.append("\n\t\tPOIRoomNum: ").append(poi.toString());
      }
    }
    return str.toString();
  }

  public void addPOI(POI poi) {
    this.pois[poi.type.ordinal()].add(poi);
  }

  /**
   * @return a json object representation of this floor
   */
  public JSONObject toJSON() {
    JSONObject jsonFloor = new JSONObject();
    jsonFloor.put("map", this.imagePath);
    jsonFloor.put("levelName", this.name);
    jsonFloor.put("level", this.level);
    JSONArray jsonPOIs = new JSONArray();
    for (List<POI> poiList : this.pois) {
      for (POI poi : poiList) {
        jsonPOIs.put(poi.toJSON());
      }
    }
    jsonFloor.put("pois", jsonPOIs);
    return jsonFloor;
  }

  /**
   * @return name of the floor
   */
  public String getName() {
    return name;
  }

  /**
   * @return image of the floor
   */
  public Image getImage() {
    return image;
  }
}

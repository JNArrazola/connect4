package connect4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileManagement {
    private final static String appDataStr = new File("").getAbsolutePath() + "/appData";
    private final static String gameFolder = appDataStr + "/games";
    private final static String scoreFolder = appDataStr + "/scores";
    private final static String scoresPvP = scoreFolder + "/pvp";
    private final static String scoresPvPc = scoreFolder + "/pvpc";

    public static void initialConfig(){
        File appData = new File(appDataStr);

        if(!appData.exists()){
            appData.mkdir();
            new File(scoreFolder).mkdir();
            new File(gameFolder).mkdir();
            new File(scoresPvP).mkdir();
            new File(scoresPvPc).mkdir();
        }
    }

    public static void save(Save save){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fw = new FileWriter(gameFolder + "/board.json")) {
            gson.toJson(save, fw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Save load() {
        Gson gson = new Gson();
    
        File file = new File(gameFolder + "/board.json");
        if (!file.exists()) {
            return null; 
        }
    
        try (FileReader fr = new FileReader(file)) {
            return gson.fromJson(fr, Save.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
}

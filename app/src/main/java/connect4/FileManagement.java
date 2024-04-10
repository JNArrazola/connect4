package connect4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;

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

    /**
     * Serialize PvP games
      */
    public static void serializePvP(ArrayList<Register> scores) {
        try (FileWriter writer = new FileWriter(scoresPvP + "/times.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(scores, writer);
        } catch (Exception e) {
        }
    }

    public static void serializePlayerVsPc(ArrayList<Register> scores) {
        try (FileWriter writer = new FileWriter(scoresPvPc + "/times.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(scores, writer);
        } catch (Exception e) {
        }
    }

    public static ArrayList<Register> deserializePvP() {
        ArrayList<Register> deserializedList = new ArrayList<>();
        try (FileReader reader = new FileReader(scoresPvP + "/times.json")) {
            Gson gson = new Gson();
            Type typeList = new TypeToken<ArrayList<Register>>(){}.getType();
            deserializedList = gson.fromJson(reader, typeList);
            if(deserializedList==null)
                deserializedList = new ArrayList<>();
        } catch (IOException e) { }
        return deserializedList;
    }
    
    public static ArrayList<Register> deserializePvsPc() {
        ArrayList<Register> deserializedList = new ArrayList<>();
        try (FileReader reader = new FileReader(scoresPvPc + "/times.json")) {
            Gson gson = new Gson();
            Type typeList = new TypeToken<ArrayList<Register>>(){}.getType();
            deserializedList = gson.fromJson(reader, typeList);
            if(deserializedList==null)
                deserializedList = new ArrayList<>();
        } catch (IOException e) { }
        return deserializedList;
    }
}

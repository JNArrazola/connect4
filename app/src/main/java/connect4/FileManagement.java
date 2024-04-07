package connect4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileManagement {
    private static String gameFolder = new File("").getAbsolutePath()+"/games";

    public static void initialConfig(){
        File folder = new File(gameFolder); 
        
        if(!(folder.exists()))
            folder.mkdir();
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

package adam.mashadani;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson; // För att skapa en gson objekt att läsa in
import com.google.gson.GsonBuilder; // Skapa Gson med mer lättläst output
import com.google.gson.reflect.TypeToken; // Skapa TypeToken
import java.nio.file.Files; // Filhantering
import java.nio.file.Paths; // Filhantering
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type; // För att Spara Typen från TypeToken
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try {
            String besökande_json = Files.readString(Paths.get("besökande.json"));
            String avstäString_json = Files.readString(Paths.get("Avstängda.json"));
            String fhjälpen_json = Files.readString(Paths.get("f_hjälpen.json"));
            String medlemmar_json = Files.readString(Paths.get("medlemmar.json"));

            // Typen string för listan
            Type stringListType = new TypeToken<ArrayList<String>>(){}.getType(); 
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
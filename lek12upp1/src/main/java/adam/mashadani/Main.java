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
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String besökande_json = Files.readString(Paths.get("besökande.json"));
            String avstängda_json = Files.readString(Paths.get("Avstängda.json"));
            String fhjälpen_json = Files.readString(Paths.get("f_hjälpen.json"));
            String medlemmar_json = Files.readString(Paths.get("medlemmar.json"));

            // Typen string för listan
            Type personListType = new TypeToken<ArrayList<Person>>() {
            }.getType();

            ArrayList<Person> besökande = gson.fromJson(besökande_json, personListType);
            ArrayList<Person> avstängda = gson.fromJson(avstängda_json, personListType);
            ArrayList<Person> fhjälpen = gson.fromJson(fhjälpen_json, personListType);
            ArrayList<Person> medlemmar = gson.fromJson(medlemmar_json, personListType);

            //Uppgift A

            HashSet<Person> medlemmar_set = new HashSet<>(medlemmar);
            HashSet<Person> fhjälpen_set = new HashSet<>(fhjälpen);

            medlemmar_set.retainAll(fhjälpen_set);

            ArrayList<Person> besökandeFhjälpen = new ArrayList<>(medlemmar_set);

            System.out.println(besökandeFhjälpen.size() + " medlemmar har första hjälpen:");
            for (Person i : besökandeFhjälpen) {
                System.out.println(i.namn);
            }

            //Uppgift B

            HashSet<Person> besökare_set = new HashSet<Person>(besökande);
            HashSet<Person> avstängda_set = new HashSet<Person>(avstängda);

            besökare_set.removeAll(avstängda_set);

            ArrayList<Person> icke_avstängda_besökare = new ArrayList<>(besökare_set);

            System.out.println(icke_avstängda_besökare.size() + " ska delta:");

            for (Person i : icke_avstängda_besökare) {
                System.out.println(i.namn);
            }

            String deltagare_json = gson.toJson(icke_avstängda_besökare);

            Files.writeString(Paths.get("deltagare.json"), deltagare_json);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
package Repositorios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ParqueClases.Parque;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParqueRepositorio {

    private static final String FILE_PATH = "parques.json";
    private Gson gson = new Gson();

    public void guardarParques(List<Parque> parques) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(parques, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Parque> cargarParques() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Parque>>(){}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

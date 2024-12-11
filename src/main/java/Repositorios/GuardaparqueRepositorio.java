package Repositorios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ParqueClases.Guardaparque;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GuardaparqueRepositorio {

    private static final String FILE_PATH = "guardaparques.json";
    private Gson gson = new Gson();

    public void guardarGuardaparques(List<Guardaparque> guardaparques) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(guardaparques, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Guardaparque> cargarGuardaparques() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Guardaparque>>(){}.getType());
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

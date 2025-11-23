package com.aks.core.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final Path dataPath = Paths.get("data", "data.json");
    private final File dataFile = dataPath.toFile();
    private final List<DataEntry> data = new ArrayList<>();
    private final JsonMapper jsonMapper = new JsonMapper();
    public DataManager(){

        try{
            Files.createDirectories(dataPath.getParent());
            Files.createFile(dataPath);
        }
        catch(FileAlreadyExistsException ignore){
            try {
                // otherwise all previous data will get deleted after calling the save method
                data.addAll(jsonMapper.readValue(dataFile, new TypeReference<List<DataEntry>>() {}));
            } catch (IOException e) {
                System.err.println("No content to map");
            }
        }
        catch (IOException e){
            throw new RuntimeException("Cannot initialize data file", e);
        }
    }

    public boolean dataFileExists(){
        System.out.println(dataFile.getAbsolutePath());
        return dataFile.exists();
    }

    public void addData(DataEntry dataEntry){
        data.add(dataEntry);
        save();
    }
    public void save(){
        try{
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(dataFile, data);
        }catch(IOException e){
            System.err.println("something went wrong while saving to " + dataFile.getName());
        }
    }
    public List<DataEntry> getData() {
        return data;
    }
}

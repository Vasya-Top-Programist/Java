package lab2.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO<T> implements IO<T> {

    private Class<T> classType;


    public JsonIO(Class<T> type) {
        this.classType = type;
    }

    @Override
    public void setClassType(Class<T> type) {
        classType = type;
    }

    @Override
    public Class<T> getClassType() {
        return classType;
    }

    @Override
    public void toFile(T object, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.writeValue(file, object);
            System.out.println(objectMapper.writeValueAsString(object));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T fromFile(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, classType);
    }

    public List<T> listFromFile(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<ArrayList<T>>() {
        });
    }
}

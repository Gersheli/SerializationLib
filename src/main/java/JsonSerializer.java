import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;
    private Class aClass;

    public JsonSerializer(String source) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(source);
        FileInputStream fileInputStream = new FileInputStream(source);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public void serialize(Serializable object) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        objectOutputStream.writeObject(json);
        aClass = object.getClass();
    }

    public Serializable deserialize() throws IOException, ClassNotFoundException {
        Gson gson = new Gson();
        String json = (String)objectInputStream.readObject();
        return gson.fromJson(json, aClass.getClass());
    }

    public void closeStream() throws IOException {
        objectOutputStream.close();
        objectInputStream.close();
    }
}

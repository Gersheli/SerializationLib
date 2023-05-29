import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public JsonSerializer(String source) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(source);
        FileInputStream fileInputStream = new FileInputStream(source);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public void Serialize(Serializable object) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        objectOutputStream.writeObject(json);
    }

    public Serializable Deserialize() throws IOException, ClassNotFoundException {
        Gson gson = new Gson();
        String json = (String)objectInputStream.readObject();
        return gson.fromJson(json, MyClass.class);
    }

    public void closeStream() throws IOException {
        objectOutputStream.close();
    }
}

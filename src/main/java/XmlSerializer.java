import java.io.*;

public class XmlSerializer {
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private final String source = "file.txt";

    public XmlSerializer() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(source);
        FileInputStream fileInputStream = new FileInputStream(source);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public void serialize(Serializable object) throws IOException {
        objectOutputStream.writeObject(object);
        objectOutputStream.close(); // добавляем закрытие потока
    }

    public Serializable deserialize() throws IOException, ClassNotFoundException {
        Serializable object = (Serializable) objectInputStream.readObject();
        objectInputStream.close(); // закрываем поток перед чтением данных из файла
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        objectInputStream = new ObjectInputStream(fileInputStream); // открываем поток для чтения данных из файла
        return object;
    }

    public void closeStreams() throws IOException {
        objectOutputStream.close();
        objectInputStream.close();
    }
}
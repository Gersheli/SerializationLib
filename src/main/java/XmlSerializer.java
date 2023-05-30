import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlSerializer {
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    public XmlSerializer(String source) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(source);
        FileInputStream fileInputStream = new FileInputStream(source);
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public void serialize(Serializable object) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(object, stringWriter);
        String xml = stringWriter.toString();
        objectOutputStream.writeObject(xml);
    }

    public Serializable deserialize(Class<?> aClass) throws IOException, ClassNotFoundException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(aClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String xml = (String) objectInputStream.readObject();
        StringReader stringReader = new StringReader(xml);
        return (Serializable) unmarshaller.unmarshal(stringReader);
    }

    public void closeStreams() throws IOException {
        objectOutputStream.close();
        objectInputStream.close();
    }
}

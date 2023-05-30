import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException {
        XmlSerializer xmlSerializer = new XmlSerializer("file.txt");
        MyClass myClass = new MyClass(19, "string");
        xmlSerializer.serialize(myClass);
    }
}

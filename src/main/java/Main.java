import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JAXBException, ClassNotFoundException {
        XmlSerializer xmlSerializer = new XmlSerializer();
        MyClass myClass = new MyClass(19, "string");
        xmlSerializer.serialize(myClass);
        MyClass myClass1 = (MyClass) xmlSerializer.deserialize();
        System.out.println(myClass1.getMyString());
        System.out.println(myClass1.getMyInt());
    }
}

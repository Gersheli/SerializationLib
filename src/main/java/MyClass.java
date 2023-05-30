import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class MyClass implements Serializable {
    private int myInt;
    private String myString;

    public MyClass() {

    }

    public MyClass(int myInt, String myString) {
        this.myInt = myInt;
        this.myString = myString;
    }

    public int getMyInt() {
        return myInt;
    }

    public String getMyString() {
        return myString;
    }

    @Override
    public String toString() {
        return myString + myInt;
    }
}
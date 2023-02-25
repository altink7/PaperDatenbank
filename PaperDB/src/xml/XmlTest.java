package xml;

import javax.xml.bind.JAXBException;

public class XmlTest {
    public static void main(String[] args) {
        try {
            PaperFile.createXmlTestData();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}

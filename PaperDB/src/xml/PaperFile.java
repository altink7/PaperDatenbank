package xml;

import at.altin.PaperDB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;

public class PaperFile {
        public static void createXmlTestData() throws JAXBException {
            XmlPaper XmlPaper1 = new XmlPaper("Jane Doe", "The Science of XML", "2022-01-01", 10, null);
            XmlPaper XmlPaper2 = new XmlPaper("John Smith", "The Art of Programming", "2022-02-01", 20, null);

            LinkedList<XmlPaper> referenzen = new LinkedList<>();
            referenzen.add(XmlPaper1);
            referenzen.add(XmlPaper2);

            XmlPaper XmlPaper = new XmlPaper("Alice Johnson", "The Future of Software Engineering", "2022-03-01", referenzen);

            JAXBContext context = JAXBContext.newInstance(XmlPaper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(XmlPaper, new File("XmlPaper.xml"));

            marshaller.marshal(XmlPaper, System.out);
        }

        public void createXml(PaperDB paper){
            XmlPaper XmlPaper = new XmlPaper(paper.getAutor(), paper.getTitel(), paper.getDatum().toString(), paper.getSeitenAnzahl(), paper.getReferenzen());
            try {
                JAXBContext context = JAXBContext.newInstance(XmlPaper.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(XmlPaper, new File("XmlPaper.xml"));
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
}

package xml;

import at.altin.ReferenceArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class XmlPaper {
    private String autor;
    private String titel;
    private String datum;
    private int seitenAnzahl;
    private List<XmlPaper> referenzen;

    public XmlPaper() {}

    public XmlPaper(String autor, String titel, String datum, int seitenAnzahl, ReferenceArrayList referenzen) {
        this.autor = autor;
        this.titel = titel;
        this.datum = datum;
        this.seitenAnzahl = seitenAnzahl;
        if(referenzen == null)
            this.referenzen = Collections.emptyList();
        else
            this.referenzen = Collections.unmodifiableList((List<XmlPaper>) referenzen);
    }
    public XmlPaper(String autor, String titel, String datum, LinkedList<XmlPaper> referenzen) {
        this.autor = autor;
        this.titel = titel;
        this.seitenAnzahl = 987654321;
        this.datum = datum;
        this.seitenAnzahl = seitenAnzahl;
        this.referenzen = referenzen;
    }


    public String getAutor() {
        return autor;
    }

    @XmlElement
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitel() {
        return titel;
    }

    @XmlElement
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDatum() {
        return datum;
    }

    @XmlElement
    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getSeitenAnzahl() {
        return seitenAnzahl;
    }

    @XmlElement
    public void setSeitenAnzahl(int seitenAnzahl) {
        this.seitenAnzahl = seitenAnzahl;
    }

    public List<XmlPaper> getReferenzen() {
        return referenzen;
    }

    @XmlElement
    public void setReferenzen(List<XmlPaper> referenzen) {
        this.referenzen = referenzen;
    }
}

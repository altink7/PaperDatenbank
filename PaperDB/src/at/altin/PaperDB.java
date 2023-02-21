package at.altin;
import java.util.Objects;

/***
 * This class is used to create a paper object.
 * It contains the author, title, date, number of pages and references.
 * @author Altin
 * @version 1.0
 */

class PaperList {
    Node head;
    int size=0;
}
class Node {
    PaperDB data;
    Node next;
}
public class PaperDB {
    String Autor;
    String Titel;
    Date Datum;
    int SeitenAnzahl;
    ReferenceArrayList Referenzen;

    public static PaperDB create(String Autor, String Titel, Date Datum, int SeitenAnzahl){
        PaperDB p =new PaperDB();
        p.Autor=Autor;
        p.Titel=Titel;
        p.Datum=Datum;
        p.SeitenAnzahl=SeitenAnzahl;
        return p;
    }//Hier kann man neue Einträge erstellen
}
class PaperDBLogik{//Hier sind verschiedene Algorithmen drinnen, auf eine logische Basis
    static void add(PaperList list, PaperDB paper){
        Node neu = new Node();
        neu.data = paper;
        list.size++;

        if(list.head == null){
            list.head = neu;
        }
        else{
            Node current = list.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = neu;
        }
    }//Hier addet man Einträge
    static Node get(PaperList list, int idx) {
        Node neu = list.head;
        for(int i=0; i < idx; i++){
            neu = neu.next;
        }
        return neu;
    }//Hier ruft man bestimmte Einträge auf
    public static void printLine(PaperList list){
        printUnderline(124);
        System.out.printf("%2s|%23s |%49s| %16s| %12s| %10s\n","No", "      Autor        ", "Titel                      ", "Erscheinungsdatum ", "Seitenanzahl","Referenzen");
        printUnderline(124);

        for (int i = 0; i < list.size; i++) {

            PaperDB paper = Objects.requireNonNull(get(list, i)).data;
            if(Objects.requireNonNull(get(list, i)).data.Referenzen==null){
                System.out.printf("%2d| %-23s| %-48s| %02d.%02d.%4s%6s  | %-5s%6s |%3d\n",
                        i, paper.Autor, paper.Titel,paper.Datum.day, paper.Datum.month, paper.Datum.year, "", paper.SeitenAnzahl, "", 0);
            }else {
                    System.out.printf("%2d| %-23s| %-48s| %02d.%02d.%4s%6s  | %-5s%6s |%3d\n",
                        i, paper.Autor, paper.Titel,paper.Datum.day, paper.Datum.month, paper.Datum.year, "", paper.SeitenAnzahl, "", get(list, i).data.Referenzen.size);

            }
        }
        System.out.println();
        printUnderline(124);

        System.out.printf("%d Element(e).",list.size);
        System.out.println();

        printUnderline(124);
    }// Line-Anzeige
    public static void printShort(PaperList list){
        printUnderline(75);
        System.out.printf("%2s|%24s| %50s\n","No", "     Autor         ", "Titel                        ");
        printUnderline(75);

        for (int i = 0; i < list.size; i++) {
                PaperDB paper = (Objects.requireNonNull(get(list, i))).data;
                System.out.printf("%2d| %-23s| %-48s\n", i, paper.Autor, paper.Titel);
        }
        System.out.println();

        printUnderline(75);
        System.out.printf("%d Element(e).",list.size);
        System.out.println();
        printUnderline(75);
    }//Short-Anzeige
    public static void printDetail(PaperList list) {

        for (int i = 0; i < list.size; i++) {
            int counter = 0;

            printUnderline(75);
                PaperDB paper = Objects.requireNonNull(get(list, i)).data;
                System.out.printf("Autor:%-24s\n", paper.Autor);
                System.out.printf("Titel:%-48s\n", paper.Titel);
                System.out.printf("%02d.%02d.%4s\n", paper.Datum.day, paper.Datum.month, paper.Datum.year);
                System.out.printf("Seitenanzahl:%-5s\n", paper.SeitenAnzahl);
                if(Objects.requireNonNull(get(list, i)).data.Referenzen==null) {
                    System.out.printf("Referenzen:%-3d\n", 0);
                }else {
                    System.out.printf("Referenzen:%-3d\n", Objects.requireNonNull(get(list, i)).data.Referenzen.data.length);

                    for (int y = 0; y < Objects.requireNonNull(get(list, i)).data.Referenzen.data.length; y++) {
                        if (Objects.requireNonNull(get(list, i)).data.Referenzen.data == null) {
                                return;
                        } else {
                            System.out.printf("[%-3d] %-25s  %-50s \n", counter, Objects.requireNonNull(PaperDBLogik.get(list, i)).data.Referenzen.data[y].reference_ID.Autor, Objects.requireNonNull(get(list, i)).data.Referenzen.data[y].reference_ID.Datum.year);
                            counter++;
                        }
                    }
                }
        }
            System.out.println();
            printUnderline(75);
            System.out.printf("%d Element(e).",list.size);
            System.out.println();
            printUnderline(75);
    }//Detail-Anzeige
    public static void printDetailSingle(PaperList list, int idx){
            int counter = 0;

            printUnderline(75);
            System.out.println();
            if (list == null) {
                System.out.print("");
            } else {
                PaperDB paper = Objects.requireNonNull(get(list, idx)).data;
                System.out.printf("Autor:%-24s\n", paper.Autor);
                System.out.printf("Titel:%-48s\n", paper.Titel);
                System.out.printf("%02d.%02d.%4s\n", paper.Datum.day, paper.Datum.month, paper.Datum.year);
                System.out.printf("Seitenanzahl:%-5s\n", paper.SeitenAnzahl);
                if(Objects.requireNonNull(get(list, idx)).data.Referenzen==null) {
                    System.out.printf("Referenzen:%-3d\n", 0);
                }else {
                    System.out.printf("Referenzen:%-3d\n", Objects.requireNonNull(get(list, idx)).data.Referenzen.data.length);

                    for (int y = 0; y < Objects.requireNonNull(get(list, idx)).data.Referenzen.data.length; y++) {
                        if (Objects.requireNonNull(get(list, idx)).data.Referenzen.data == null) {
                            return;
                        } else {
                            System.out.printf("[%-3d] %-25s  %-50s \n", counter, Objects.requireNonNull(PaperDBLogik.get(list, idx)).data.Referenzen.data[y].reference_ID.Autor,
                                    Objects.requireNonNull(get(list, idx)).data.Referenzen.data[y].reference_ID.Datum.year);
                            counter++;
                        }
                    }
                }
            }
        System.out.println();
        printUnderline(75);
        System.out.printf("%d Element.",1);
        System.out.println();
        printUnderline(75);
    }// Detail-Anzeige
    static void deletePaper(PaperList list, String idx) {
        Node p = get(list,Integer.parseInt(idx)-1);// vorherige wird mal gespeichert

        if(Integer.parseInt(idx)==0){
            list.head = list.head.next;
        }
        else {
            Objects.requireNonNull(p).next = get(list, Integer.parseInt(idx)+1);//der nächste vom vorherigen greift auf den nächsten wert und überspringt den aktuellen Wert
        }
        list.size--;
    }//Hier kann man Einträge löschen
    public static void printUnderline(int n){
        char filler = '_';
        for(int j=0;j<n;j++){
            System.out.print(filler);
        }
        System.out.println();
    }//underline ausgeben
}

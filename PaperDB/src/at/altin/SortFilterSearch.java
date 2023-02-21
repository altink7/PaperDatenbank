package at.altin;
import java.util.Objects;

/***
 * This class is used to sort, filter and search the paper database.
 * It contains the methods for sorting, filtering and searching.
 * @author Altin
 * @version 1.0
 */

public class SortFilterSearch {

    public static Node sortedInsertAutor(Node head, Node newnode) {
        Node current;

        if (head == null || ((head).data.Autor.toUpperCase().charAt(0) >= newnode.data.Autor.toUpperCase().charAt(0))) {
            newnode.next = head;
            head = newnode;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.Autor.toUpperCase().charAt(0) < newnode.data.Autor.toUpperCase().charAt(0)) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return head;
    }//nach Autor sortieren (ASCII-Tabelle)
    public static Node sortedInsertTitel(Node head, Node newnode) {
        Node current;

        if (head == null || (head.data.Titel.toUpperCase().charAt(0) >= newnode.data.Titel.toUpperCase().charAt(0))) {
            newnode.next = head;
            head = newnode;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.Titel.toUpperCase().charAt(0) < newnode.data.Titel.toUpperCase().charAt(0)) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return head;
    }//nach Titel sortieren (ASCII-Tabelle)
    public static Node sortedInsertDatum(Node head, Node newnode) {
        Node current;

        if (head == null || head.data.Datum.year*10000+head.data.Datum.month*100+head.data.Datum.day >= newnode.data.Datum.year*10000+newnode.data.Datum.month*100+newnode.data.Datum.day) {
            newnode.next = head;
            head = newnode;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.Datum.year*10000+current.next.data.Datum.month*100+current.next.data.Datum.day < newnode.data.Datum.year*10000+newnode.data.Datum.month*100+newnode.data.Datum.day) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return head;
    }//nach Jahr sortieren (Mathematisch)
    public static Node sortedInsertPages(Node head, Node newnode) {
        Node current;

        if (head == null || (head).data.SeitenAnzahl >= newnode.data.SeitenAnzahl) {
            newnode.next = head;
            head = newnode;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.SeitenAnzahl < newnode.data.SeitenAnzahl) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return head;
    }//nach Seitenanzahl sortieren (Mathematisch)
    public static Node insertionSortLL(PaperList paperListe,int sortValue) {
        Node sorted = null;
        Node current= paperListe.head;

        while (current != null){
            Node next = current.next;
            if(sortValue==1) {
                sorted = sortedInsertAutor(sorted, current);
            } else if(sortValue==2){
                sorted = sortedInsertTitel(sorted, current);
            }else if(sortValue==3){
                sorted = sortedInsertDatum(sorted, current);
            }else if(sortValue==4){
                sorted = sortedInsertPages(sorted, current);
            }
            current = next;
        }
        return sorted;
    }//EinfügeSortierAlgorithm für LinkedList


    public static void Statistik(PaperList list){
        float sumSeitenAnzahl=0;
        float sumReferenzen=0;
        int mostRefs=0;
        int mostRefsIdx=0;

        PaperDBLogik.printUnderline(118);
        System.out.printf("Anzahl an Publikationen: %-5d", list.size);
        System.out.println();
        PaperDBLogik.printUnderline(118);
        for (int i = 0; i < list.size; i++) {
            PaperDB paper = (Objects.requireNonNull(PaperDBLogik.get(list, i))).data;
            sumSeitenAnzahl+=paper.SeitenAnzahl;
            if(paper.Referenzen==null){
                System.out.print("");
            }else {
                sumReferenzen += paper.Referenzen.data.length;
                if(paper.Referenzen.data.length>mostRefs){
                    mostRefsIdx=i;
                }
                mostRefs= Math.max(mostRefs,paper.Referenzen.data.length);
            }
        }
        System.out.printf("Durchschnittliche Seitenzahl der Publikationen:  %-5.2f",list.size==0?0:sumSeitenAnzahl/list.size);
        System.out.println();
        PaperDBLogik.printUnderline(118);

        System.out.printf("Durchschnittliche Anzahl an Referenzen:  %-5.2f",list.size==0?0:sumReferenzen/list.size);
        System.out.println();
        PaperDBLogik.printUnderline(118);

        System.out.printf("Höchstmögliche Anzahl an Referenzen:  %-5d",list.size==0?0:(list.size-1)*list.size);
        System.out.println();
        PaperDBLogik.printUnderline(118);
        System.out.println();

        if(PaperDBLogik.get(list, mostRefsIdx)==null
        || Objects.requireNonNull(PaperDBLogik.get(list, mostRefsIdx)).data==null||Objects.requireNonNull(PaperDBLogik.get(list, mostRefsIdx)).data.Referenzen==null){
            System.out.print("Keine Referenzen vorhanden!\n");
        }else {
            PaperDB paper = (Objects.requireNonNull(PaperDBLogik.get(list, mostRefsIdx))).data;
            System.out.printf("%48sMeist zitiertes Paper\n", " ");
            PaperDBLogik.printUnderline(118);

            System.out.printf("%2s| %-23s| %-44s| %16s| %11s| %10s\n","X.", "       Autor       ", "Titel                      ", "Erscheinungsdatum", "Seitenanzahl", "Referenzen");
            PaperDBLogik.printUnderline(118);

            System.out.printf("%2s| %-23s| %-44s| %2s.%2s.%4s%7s| %-5s%7s|%3d\n", "->", paper.Autor, paper.Titel,
                    paper.Datum.day, paper.Datum.month, paper.Datum.year, "", paper.SeitenAnzahl, "", Objects.requireNonNull(PaperDBLogik.get(list, mostRefsIdx)).data.Referenzen.size);
        }
    }//Hier sind Statistiken gespeichert
    public static PaperList filterList(PaperList list,String filterString){
        PaperList filter = new PaperList();

        for (int i = 0; i<list.size;i++) {
            PaperDB paper = Objects.requireNonNull(PaperDBLogik.get(list, i)).data;

            if (paper.Autor.contains(filterString) || paper.Titel.contains(filterString)
                    || String.valueOf(paper.Datum.day).contains(filterString) || String.valueOf(paper.Datum.month).contains(filterString)
                    || String.valueOf(paper.Datum.year).contains(filterString) || String.valueOf(paper.SeitenAnzahl).contains(filterString)) {//filtert diese Werte
                PaperDBLogik.add(filter, Objects.requireNonNull(PaperDBLogik.get(list, i)).data);
            }
        }
        return filter;
    }//Filter-Methode
}








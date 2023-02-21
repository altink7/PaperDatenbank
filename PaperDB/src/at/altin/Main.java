package at.altin;
import java.util.Scanner;

/***
 * This is the main class of the PaperDB.
 * It contains the main method and the user interface.
 * @author Altin
 * @version 1.0
 */
public class Main {
//Hier werden Eingaben validiert+ UI / Import von Testdaten
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        PaperList paperListe = new PaperList();
        int switchcase;
        int duplikat = 0;
        String auswahl;
        int MenuPoint;

        System.out.print("_______________________________\n");
        System.out.print("Willkommen beim Paper Manager!\n");
        System.out.print("_______________________________\n   \n");
        System.out.println("Bitte wählen Sie einen Menüpunkt!");

        System.out.print("""

                0.Paper Manager beenden
                1.Paper erfassen
                2.Paper anzeigen
                3.Paper löschen
                4.Referenzen hinzufügen
                5.Sortieren
                6.Filtern/Suchen
                7.Zitationsgraph anzeigen
                8.DB mit Testdaten ausfüllen
                9.Hauptmenü anzeigen
                10.PaperDB bereinigen
                11.Statistik/Analysen zeigen
                """);
        System.out.print("Input:");
        auswahl = sc.nextLine();
        while (true) {
            switchcase = 0;//mit dieser Variable kann ein Menüpunkt wiederholt werden
            MenuPoint = 0;//Hilfsvariable zur verriegelung
            if (auswahl.equals("0")) {
                break;
            }
            else if (auswahl.equals("1")) {
                System.out.print("____________________________________\n");
                System.out.print("Hier können Sie neue Papers erfassen\n");
                System.out.print("____________________________________\n   \n");

                String autorName;
                System.out.print("Input:");
                autorName = sc.nextLine();
                while (!autorName.matches("\\D*")||autorName.matches("")) {
                    System.out.print("Bitte geben Sie einen gültigen Namen ein!\n");
                    System.out.print("Input:");
                    autorName = sc.nextLine();
                }

                System.out.print("Bitte Titel vom Paper eingeben\n");
                String paperTitel;
                System.out.print("Input:");
                paperTitel = sc.nextLine();

                System.out.print("Bitte Erscheinungstag vom Paper eingeben\n");
                System.out.print("Input:");
                String paperDay = sc.nextLine();
                while (true) {
                    if (paperDay.matches("[0-9]{1,2}")) {
                        if (Integer.parseInt(paperDay) > 31 || Integer.parseInt(paperDay) < 1) {
                            System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            paperDay = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        paperDay = sc.nextLine();
                    }
                }
                System.out.print("Bitte Erscheinungsmonat vom Paper eingeben\n");
                String paperMonth;
                System.out.print("Input:");
                paperMonth = sc.nextLine();
                while (true) {
                    if (paperMonth.matches("[0-9]{1,2}")) {
                        if (Integer.parseInt(paperMonth) > 12 || Integer.parseInt(paperMonth) < 1) {
                            System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            paperMonth = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        paperMonth = sc.nextLine();
                    }
                }
                System.out.print("Bitte Erscheinungsjahr vom Paper eingeben\n");
                String paperYear;
                System.out.print("Input:");
                paperYear = sc.nextLine();
                while (true) {
                    if (paperYear.matches("[0-9]{4}")) {
                        if (Integer.parseInt(paperYear) > 2200 || Integer.parseInt(paperYear) < 1600) {
                            System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            paperYear = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        paperYear = sc.nextLine();
                    }
                }

                System.out.print("Bitte die Seitenanzahl vom Paper eingeben\n");
                String paperSeitenAnzahl;
                System.out.print("Input:");
                paperSeitenAnzahl = sc.nextLine();
                while (true) {
                    if (paperSeitenAnzahl.matches("[0-9]{1,4}")) {
                        break;
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        paperSeitenAnzahl = sc.nextLine();
                    }
                }
                PaperDBLogik.add(paperListe, PaperDB.create(autorName, paperTitel, Date.create(Integer.parseInt(paperYear), Integer.parseInt(paperMonth), Integer.parseInt(paperDay)), Integer.parseInt(paperSeitenAnzahl)));
                PaperDBLogik.printLine(paperListe);
                System.out.print("""

                        Paper wurde erfasst!

                        0.Zurück zum Hauptmenü
                        1.Einen weiteren Eintrag erfassen
                        """);
                System.out.print("Input:");
                String erfassung = sc.nextLine();
                while (true) {
                    if (erfassung.equals("0")) {
                        auswahl = "9";
                        break;
                    } else if (erfassung.equals("1")) {
                        switchcase = 1;
                        break;
                    } else {
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        erfassung = sc.nextLine();
                    }
                }
            }//Paper erfassen
            else if (auswahl.equals("2")) {
                System.out.print("__________________________________________\n");
                System.out.print("Hier können Sie die Papers anzeigen lassen\n");
                System.out.print("__________________________________________\n   \n");
                System.out.print("Bitte wählen Sie die Anzeigeart!\n");
                System.out.print("""

                        0.Zurück zum Hauptmenü
                        1.Line-Format Anzeige
                        2.Short-Format Anzeige
                        3.Detail-Format Anzeige
                        4.Ausgabe eines Papers
                        """);

                System.out.print("Input:");
                String anzeige = sc.nextLine();
                label1:
                while (true) {
                    switch (anzeige) {
                        case "0":
                            auswahl = "9";
                            break label1;
                        case "1":
                            System.out.print("line-format\n");
                            PaperDBLogik.printLine(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Anzeigeart wählen
                                    """);
                            System.out.print("Input:");
                            anzeige = sc.nextLine();
                            while (true) {
                                if (anzeige.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (anzeige.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                                    System.out.print("Input:");
                                    anzeige = sc.nextLine();
                                }
                            }
                            break label1;
                        case "2":
                            System.out.print("short-format\n");
                            PaperDBLogik.printShort(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Anzeigeart wählen
                                    """);
                            System.out.print("Input:");
                            anzeige = sc.nextLine();
                            while (true) {
                                if (anzeige.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (anzeige.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                                    System.out.print("Input:");
                                    anzeige = sc.nextLine();
                                }
                            }
                            break label1;
                        case "3":
                            System.out.print("detail-format\n");
                            PaperDBLogik.printDetail(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Anzeigeart wählen
                                    """);
                            System.out.print("Input:");
                            anzeige = sc.nextLine();
                            while (true) {
                                if (anzeige.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (anzeige.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                                    System.out.print("Input:");
                                    anzeige = sc.nextLine();
                                }
                            }
                            break label1;
                        case "4":
                            System.out.print("Welches Paper wollen Sie anzeigen lassen\n");
                            System.out.print("Input:");
                            String PaperIdx = sc.nextLine();
                            if (paperListe.size == 0) {
                                System.out.print("\nListe ist leer!\n\n");
                                System.out.print("Input:\n");
                            } else if (Integer.parseInt(PaperIdx) < 0 || Integer.parseInt(PaperIdx) > paperListe.size - 1) {
                                System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                                System.out.print("Input:\n");
                                PaperIdx = sc.nextLine();
                            }
                            System.out.print("detail-format\n");
                            if (paperListe.size != 0) {
                                PaperDBLogik.printDetailSingle(paperListe, Integer.parseInt(PaperIdx));
                            }
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Anzeigeart wählen
                                    """);
                            System.out.print("Input:");
                            anzeige = sc.nextLine();
                            while (true) {
                                if (anzeige.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (anzeige.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                                    System.out.print("Input:");
                                    anzeige = sc.nextLine();
                                }
                            }
                            break label1;
                        default:
                            System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            anzeige = sc.nextLine();
                            break;
                    }
                }


            }//Paper anzeigen
            else if (auswahl.equals("3")) {
                System.out.print("______________________________\n");
                System.out.print("Hier können Sie Papers löschen\n");
                System.out.print("______________________________\n   \n");
                if (paperListe.head == null) {
                    System.out.println("Es können keine Einträge gelöscht werden,Liste ist leer!");
                } else {
                    System.out.println("Bitte wählen Sie den Eintrag, den Sie löschen möchten.");
                    PaperDBLogik.printLine(paperListe);
                    System.out.print("\nInput:");
                    String deleteIndex = sc.nextLine();
                    while (true) {
                        if (Integer.parseInt(deleteIndex) >= paperListe.size || Integer.parseInt(deleteIndex) < 0) {
                            System.out.println("Dieser Eintrag kann nicht gelöscht werden, bitte geben sie eine gültige Zahl\n");
                            System.out.print("Input:");
                            deleteIndex = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    PaperDBLogik.deletePaper(paperListe, deleteIndex);
                    System.out.print("\nPaper wurde gelöscht!\n");

                }

                System.out.print("""

                        0.Zurück zum Hauptmenü
                        """);
                if (paperListe.head != null) {
                    System.out.print("1.Einen weiteren Eintrag löschen\n");
                }
                System.out.print("Input:");
                String delete = sc.nextLine();
                while (true) {
                    if (delete.equals("0")) {
                        auswahl = "9";
                        break;
                    } else if (paperListe.head != null&&delete.equals("1")) {
                        switchcase = 1;
                        break;
                    } else {
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        delete = sc.nextLine();
                    }
                }

            }//Paper löschen
            else if (auswahl.equals("4")) {
                System.out.print("_____________________________________\n");
                System.out.print("Hier können Sie Referenzen hinzufügen\n");
                System.out.print("_____________________________________\n   \n");
                if (paperListe.size < 2) {
                    System.out.println("Sie könne leider keine Referenzen hinzufügen!");
                } else {

                    System.out.println("Bitte wählen Sie das Paper, welchem die Referenz hinzugefügt werden soll!");
                    PaperDBLogik.printLine(paperListe);
                    System.out.print("\nInput:");
                    String RefIdx = sc.nextLine();
                    while (true) {
                        if(!RefIdx.matches("[0-9]{1,99}")){
                            System.out.println("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            RefIdx = sc.nextLine();
                        }else {
                            if (Integer.parseInt(RefIdx) < 0 || Integer.parseInt(RefIdx) > paperListe.size - 1) {
                                System.out.println("Bitte geben Sie eine gültige Zahl ein!\n");
                                System.out.print("Input:");
                                RefIdx = sc.nextLine();
                            } else {
                                break;
                            }
                        }
                    }
                    System.out.println("Bitte wählen Sie die Referenz!\n");
                    System.out.print("Input:");
                    String Ref = sc.nextLine();
                    while(true) {
                        if(!Ref.matches("[0-9]{1,99}")){
                            System.out.println("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            Ref = sc.nextLine();
                        }else {
                            if (Integer.parseInt(Ref) < 0 || Integer.parseInt(Ref) > paperListe.size - 1 || Integer.parseInt(Ref) == Integer.parseInt(RefIdx) ||
                                    Paper.compare(paperListe, Integer.parseInt(RefIdx), Integer.parseInt(Ref))) {
                                System.out.println("Bitte geben Sie eine gültige Zahl ein!\n");
                                System.out.print("Input:");
                                Ref = sc.nextLine();
                            } else {
                                break;
                            }
                        }
                    }
                        Paper.addReference(paperListe,Integer.parseInt(RefIdx),Integer.parseInt(Ref));
                        Paper.RefPrint(paperListe);

                        System.out.print("\nReferenz wurde hinzugefügt!\n\n");

                }
                System.out.print("""

                        0.Zurück zum Hauptmenü
                        1.Eine weitere Referenz hinzufügen
                        """);

                System.out.print("Input:");
                String refmenu = sc.nextLine();
                while(true) {
                    if (refmenu.equals("0")) {
                        auswahl = "9";
                        break;
                    } else if(refmenu.equals("1")){
                        switchcase = 1;
                        break;
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        refmenu = sc.nextLine();
                    }
                }

            }//Referenzen adden
            else if (auswahl.equals("5")) {
                System.out.print("______________________________________\n");
                System.out.print("Hier können Sie die Einträge sortieren \n");
                System.out.print("______________________________________\n   \n");
                System.out.print("Bitte wählen Sie eine Sortieroption!\n");
                System.out.print("""

                        0.Zurück zum Hauptmenü
                        1.Sortieren nach Autor
                        2.Sortieren nach Titel
                        3.Sortieren nach Erscheinungsdatum
                        4.Sortieren nach Seitenanzahl
                        """);
                System.out.print("Input:");
                String sortVal = sc.nextLine();
                label:
                while(true){
                    switch (sortVal) {
                        case "0":
                            auswahl = "9";
                            break label;
                        case "1":
                            paperListe.head = SortFilterSearch.insertionSortLL(paperListe, 1);
                            PaperDBLogik.printLine(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Sortieroption wählen
                                    """);
                            System.out.print("Input:");
                            sortVal = sc.nextLine();
                            while (true) {
                                if (sortVal.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (sortVal.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                                    System.out.print("Input:");
                                    sortVal = sc.nextLine();
                                }
                            }
                            break label;
                        case "2":
                            paperListe.head = SortFilterSearch.insertionSortLL(paperListe, 2);
                            PaperDBLogik.printLine(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Sortieroption wählen
                                    """);
                            System.out.print("Input:");
                            sortVal = sc.nextLine();
                            while (true) {
                                if (sortVal.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (sortVal.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                                    System.out.print("Input:");
                                    sortVal = sc.nextLine();
                                }
                            }
                            break label;
                        case "3":
                            paperListe.head = SortFilterSearch.insertionSortLL(paperListe, 3);
                            PaperDBLogik.printLine(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Sortieroption wählen
                                    """);
                            System.out.print("Input:");
                            sortVal = sc.nextLine();
                            while (true) {
                                if (sortVal.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (sortVal.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                                    System.out.print("Input:");
                                    sortVal = sc.nextLine();
                                }
                            }
                            break label;
                        case "4":
                            paperListe.head = SortFilterSearch.insertionSortLL(paperListe, 4);
                            PaperDBLogik.printLine(paperListe);
                            System.out.print("""

                                    0.Zurück zum Hauptmenü
                                    1.Andere Sortieroption wählen
                                    """);
                            System.out.print("Input:");
                            sortVal = sc.nextLine();
                            while (true) {
                                if (sortVal.equals("0")) {
                                    auswahl = "9";
                                    break;
                                } else if (sortVal.equals("1")) {
                                    switchcase = 1;
                                    break;
                                } else {
                                    System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                                    System.out.print("Input:");
                                    sortVal = sc.nextLine();
                                }
                            }
                            break label;
                        default:
                            System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                            System.out.print("Input:");
                            sortVal = sc.nextLine();
                            break;
                    }


                }
            }//Sortieren
            else if (auswahl.equals("6")) {
                System.out.print("______________________________________\n");
                System.out.print("Hier können Sie die Einträge filtern \n");
                System.out.print("______________________________________\n   \n");
                System.out.print("Wonach möchten Sie die Einträge filtern!\n");
                System.out.print("*Bitte beachten Sie Leerzeichen*\n");
                String filterString= sc.nextLine();
                PaperDBLogik.printLine(SortFilterSearch.filterList(paperListe,filterString));

                System.out.print("""

                        0.Zurück zum Hauptmenü
                        1.Weitere Einträge filtern
                        """);

                System.out.print("Input:");
                String SearchVal = sc.nextLine();
                while (true) {
                    if (SearchVal.equals("0")) {
                        auswahl = "9";
                        break;
                    } else if (SearchVal.equals("1")){
                        switchcase = 1;
                        break;
                    } else {
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!");
                        System.out.print("Input:");
                        SearchVal = sc.nextLine();
                    }
                }
            }//Filtern
            else if (auswahl.equals("7")) {
                System.out.print("___________________________________________________\n");
                System.out.print("Hier können Sie den Zitationgraphen anzeigen lassen!\n");
                System.out.print("___________________________________________________\n   \n");
                Paper.RefPrint(paperListe);
                System.out.print("""

                        0.Zurück zum Hauptmenü
                        """);

                System.out.print("Input:");
                String Auswertung = sc.nextLine();
                while (true) {
                    if(Auswertung.equals("0")) {
                        auswahl = "9";
                        break;
                    }
                    else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        Auswertung = sc.nextLine();
                    }

                }

            }//Auswertung anzeigen
            else if (auswahl.equals("8")) {
                System.out.print("___________________________________________________\n");
                System.out.print("Hier können Sie die PaperDB mit Testdaten ausfüllen!\n");
                System.out.print("___________________________________________________\n   \n");
                if (paperListe.size == 0) {
                    duplikat = 0;
                }
                if (duplikat == 0) {
                    System.out.print("\n*Die Datenbank sollte vor dem Import leer sein!*\n");
                    importList(paperListe);
                    System.out.print("""

                            Testdaten wurden importiert!

                            0.Zurück zum Hauptmenü
                            1.Einen weiteren Eintrag manuell erfassen
                            """);
                    duplikat = 1;
                } else {
                    System.out.print("""

                            Testdaten sind schon importiert worden!

                            0.Zurück zum Hauptmenü
                            1.Einen weiteren Eintrag manuell erfassen
                            """);
                }
                System.out.print("Input:");
                String test = sc.nextLine();
                while (true) {
                if (test.equals("0")){
                    auswahl = "9";
                    break;
                } else if(test.equals("1")){
                    auswahl = "1";
                    switchcase = 1;
                    break;
                }
                else{
                        System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                        System.out.print("Input:");
                        test = sc.nextLine();
                    }
                }

            }//DB mit Testdaten ausfüllen
            else if (auswahl.equals("10")) {
                System.out.print("______________________________________\n");
                System.out.print("Hier können Sie die PaperDB bereinigen\n");
                System.out.print("______________________________________\n   \n");
                if (paperListe.head == null) {
                    System.out.println("Es können keine Einträge gelöscht werden,Liste ist leer!");
                } else {
                    while (paperListe.head != null) {
                        PaperDBLogik.deletePaper(paperListe, "0");
                    }
                    System.out.print("\nPaperDB wurde bereinigt!\n");
                }

                System.out.print("""

                        0.Zurück zum Hauptmenü
                        """);

                System.out.print("Input:");
                String deleteAll = sc.nextLine();
                while (!deleteAll.equals("0")){
                    System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                    System.out.print("Input:");
                    deleteAll = sc.nextLine();
                }
                auswahl = "9";
            }//DB bereinigen
            else if (auswahl.equals("11")) {
                System.out.print("_____________________________________________\n");
                System.out.print("Hier können Sie die Statistik anzeigen lassen\n");
                System.out.print("_____________________________________________\n   \n");
                SortFilterSearch.Statistik(paperListe);

                System.out.print("""

                        0.Zurück zum Hauptmenü
                        """);

                System.out.print("Input:");
                String Stat = sc.nextLine();
                while (!Stat.equals("0")){
                    System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                    System.out.print("Input:");
                    Stat = sc.nextLine();
                }
                auswahl = "9";
            }//Statistik& Auswertung anzeigen lassen
            else if (!auswahl.equals("9")) {
                System.out.print("Bitte geben Sie eine gültige Zahl ein!\n");
                System.out.print("Input:");
                auswahl = sc.nextLine();
                MenuPoint = 1;
            }//Prüfen vom Variabel
            if (auswahl.equals("9")) {
                System.out.print("""

                        HAUPTMENÜ:

                        0.Paper Manager beenden
                        1.Paper erfassen
                        2.Paper anzeigen
                        3.Paper löschen
                        4.Referenzen hinzufügen
                        5.Sortieren
                        6.Filtern/Suchen
                        7.Zitationsgraph anzeigen
                        8.DB mit Testdaten ausfüllen
                        9.Hauptmenü anzeigen
                        10.PaperDB bereinigen
                        11.Statistik/Analysen zeigen
                        """);
            }//Hauptmenü
            if (switchcase == 0 && MenuPoint == 0) {
                System.out.print("\nInput:");
                auswahl = sc.nextLine();
            }
        }
    }
    private static void importList(PaperList list) {
        PaperDBLogik.add(list, PaperDB.create("Brunnbauer", "b-title", Date.create(2014, 5, 30), 2));
        PaperDBLogik.add(list, PaperDB.create("Cerny", "a-title", Date.create(2020, 3, 13), 3));
        PaperDBLogik.add(list, PaperDB.create("Mandl", "g-title", Date.create(2018, 7, 6), 5));
        PaperDBLogik.add(list, PaperDB.create("Hösel", "r-title", Date.create(1990, 12, 31), 2));
        PaperDBLogik.add(list, PaperDB.create("Demetz", "r-title", Date.create(1990, 1, 7), 88));
        PaperDBLogik.add(list, PaperDB.create("Satek", "z-title", Date.create(2004, 8, 27), 12));
        PaperDBLogik.add(list, PaperDB.create("Brunnbauer", "l-title", Date.create(2004, 8, 17), 2));
        PaperDBLogik.add(list, PaperDB.create("Kelmendi", "b-title", Date.create(2022, 1, 3), 27));
        Paper.addReference(list,0,1);
        Paper.addReference(list,0,2);
        Paper.addReference(list,0,3);
        Paper.addReference(list,0,4);
        Paper.addReference(list,1,0);
        Paper.addReference(list,2,0);
        Paper.addReference(list,3,0);
        Paper.addReference(list,3,1);
        Paper.addReference(list,4,0);
        Paper.addReference(list,4,1);
        Paper.addReference(list,5,0);
        Paper.addReference(list,5,1);
        Paper.addReference(list,7,6);
        Paper.addReference(list,7,5);
        Paper.addReference(list,7,4);
        Paper.addReference(list,7,3);
        Paper.addReference(list,7,2);
    }//Import von Testdaten
}



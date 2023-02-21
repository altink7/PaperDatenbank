package web;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/***
 * This class is used to create a GUI for the paper database.
 * It contains the methods for creating the GUI.
 * @author Altin
 * @version 1.0
 */

public class PaperDatabaseGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paper Database GUI");

        JLabel title = new JLabel("HAUPTMENÜ:");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        String[] menuItems = new String[] {
                "0. Paper Manager beenden",
                "1. Paper erfassen",
                "2. Paper anzeigen",
                "3. Paper löschen",
                "4. Referenzen hinzufügen",
                "5. Sortieren",
                "6. Filtern/Suchen",
                "7. Zitationsgraph anzeigen",
                "8. DB mit Testdaten ausfüllen",
                "9. Hauptmenü anzeigen",
                "10. PaperDB bereinigen",
                "11. Statistik/Analysen zeigen"
        };

        JList<String> menuList = new JList<>(menuItems);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(menuList);

        frame.add(title, SwingConstants.CENTER);
        frame.add(scrollPane);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

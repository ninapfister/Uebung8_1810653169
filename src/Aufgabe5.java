import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Aufgabe5
{
    public static void main(String[] args)
    {

        writeFile(); // Ausführen von Methode writeFile

        int eingabe = Integer.parseInt(JOptionPane.showInputDialog("Bitte Zahl zwischen 1 und 50 eingeben!")); // fragt nach die gesuchte werden soll, speichert es in Variable eingabe
        int anzahl = searchNumber(eingabe); // Methode searchNumber verlangt nach Zahl, diese Zahl ist meine Eingabe

        JOptionPane.showMessageDialog(null, "Die Zahl " + eingabe + " ist " + anzahl + "mal zu finden!"); // Ausgabe

    }

    public static int searchNumber(int number) // hier gibt man ein, wie oft die Zahl enthalten ist
    {

        File file = null; // neue Datei machen, alles auf null setzen, damit nichts drinnen steht
        FileReader fr = null; // Datei auslesen
        BufferedReader reader = null; // Datei auslesen
        ArrayList<Integer> list = new ArrayList<Integer>(); // ArrayList, geht die Liste durch, jedes mal wenn er Zahl findet added er es in ArrayList, wie oft ist die Zahl enthalten

        try {

            file = new File("C:\\Users\\Nina Pfister\\Desktop\\FH\\numbers.txt"); // neues File, mit Pfad

            fr = new FileReader(file); // neuer Reader, sonst kann man nichts auslesen
            reader = new BufferedReader(fr); // neuer Reader, FileReader ist im BufferedReader

            while (true) // so lange es war ist, läuft es
            {

                String line = reader.readLine(); // Reader (BufferedReader), lest Zeile und speichert Wert in die String line hinein, geht dann in die nächste Zeile
                if (line == null) break; // wenn in line nichts drinnen, also null, aufhören

                if (Integer.parseInt(line) == number) // String in Integer umwandeln, die umgewandelte Zahl vergleicht ich mit meine Eingabe (number)
                {
                    list.add(Integer.parseInt(line)); // wenn es übereinstimmt, dann wird umgewandeltes Int zur Liste geaddet
                }

            }

        } catch(Exception ex) // wenn Fehler, dann Fehlermeldung
        {
            ex.printStackTrace(); // genaueste Fehlermeldung die man bekommt
        }

        return list.size(); // größe der ArrayList zurückgeben

    }

    public static void writeFile() // speichere Reihe von Zufallszahlen in eine Texdatei hinein
    {

        File file = null; // neue Datei machen, zuerst alles auf null setzen
        FileWriter fw = null; // in Datei schreiben
        BufferedWriter writer = null; // schreiben der Datei
        String seperator = System.getProperty("line.separator"); // Zeilenumbruch, jede Zahl in eigener Zeile
        Random random = new Random(); // Zufallszahl erstellen

        try {

            file = new File("C:\\Users\\Nina Pfister\\Desktop\\FH\\numbers.txt"); // File erstellen, Pfadname, nur 1 verschiedene Befehlen, 2 mal dass es erkannt wird

            if (!file.exists()) // wenn File nicht existiert
            {
                file.createNewFile(); // macht neues File
            }

            fw = new FileWriter(file); // schreibt ins File hinein
            writer = new BufferedWriter(fw); // schreibt in Buffered Writer hinein

            for (int i = 0; i < 50; i++) // Anzahl der Zahlen die aufgelistet wird, immer 50 verschieden Zahlen
            {
                int randomNumber = random.nextInt(50) + 1; // Zufallszahlen generieren, beginnt bei 1 bis 50
                writer.write(randomNumber + seperator); // schreibe Zufallszahl in Datei, machen einen Umbruch, Schleife beginnt neu, geht 50 mal
            }

            writer.close(); // schließen, sonst kann niemand Datei auslesen

        } catch (Exception ex) // falls Fehler, gibt er hier Eehlermeldung
        {
            ex.printStackTrace(); // genaueste Fehlermeldung die man bekommt
        }

    }
}

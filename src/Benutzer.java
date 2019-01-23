import javax.swing.*;
import java.io.Serializable;


    public class Benutzer implements Serializable  //beutzerklasse ist sommit serialisierbar/ speicherbar
    {
        private String benutzername; // Objekte definieren
        private String password;


        public Benutzer(String benutzername, String password) // Konstruktor, man greift auf die Daten zu
        {
            this.benutzername = benutzername;
            this.password = password;
            System.out.println(this.toString()); // Ausgabe mit toString
        }

        // getter und setter
        public void setBenutzername(String benutzername)
        {
            this.benutzername = benutzername;
        }

        public String getBenutzername()
        {
            return benutzername;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public String getPassword()
        {
            return password;
        }

        @Override // überschreiben
        public String toString() // Methode toString
        {
            return "Neuer Benutzer registriert! Benutzer = " + benutzername + "Passwort= " + password; // Rückgabe
        }
    }
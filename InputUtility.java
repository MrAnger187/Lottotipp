package inputHilfe;

import java.text.NumberFormat;
import java.util.Scanner;

public class InputUtility {

    // 1 Scanner Objekt für die Klasse(dh. für die ganze Anwendung)
    private static Scanner input; //= new Scanner(System.in); --> das macht der static initializer

    // static initializer
    static {
        input = new Scanner(System.in);
        //System.out.println("______Achtung: Kommatrennzeichen ist der '.'");
    }

    // statische Methoden zum einlesen verschiedener Datentypen

    public static String readString() {
        // eine Zeile lesen das Ergebnis ist der String ohne Zeilenende
        return input.nextLine();
    }

    public static int readInt() {
        String strZahl = input.nextLine();
        try {
            // aus einer Zeichenfolge eine ganze Zahl ermitteln
//            int zahl = Integer.parseInt(strZahl);
//            return zahl;
            return Integer.parseInt(strZahl);
        } catch (Exception e) {
            System.err.println("Fehlerhafte Eingabe: " + e.toString());
            System.out.print("Zahl erneut Eingeben: ");
            // Die Methode nocheinmal aufrufen
            return readInt();
        }
    }
    public static double readDouble() {
        String strZahl = input.nextLine();
        try {
            // aus einer Zeichenfolge eine ganze Zahl ermitteln
//            int zahl = Integer.parseInt(strZahl);
//            return zahl;
            //return Double.parseDouble(strZahl);
            // Neu statt dem oben NumberFormat
            NumberFormat fmt = NumberFormat.getNumberInstance();
            return fmt.parse(input.nextLine()).doubleValue();
        } catch (Exception e) {
            System.err.println("Fehlerhafte Eingabe: " + e.toString());
            System.out.print("Zahl erneut Eingeben: ");
            // Die Methode nocheinmal aufrufen
            return readDouble();
        }
    }

    public static char readChar(){
        try {
            String text = input.nextLine();
            if(text.length() > 0) {
                return text.charAt(0);
            }else{
                System.err.println("Fehlerhafte Eingabe. Es muss mindestens ein Zeichen eingegeben werden");
                return  readChar();
            }
        } catch (Exception e) {
            System.err.println("Fehlerhafte Eingabe: " + e.toString());
            System.out.println("Neuer Versuch: ");
            // die Methode rekursiv noch einmal aufrufen
            return readChar();
        }
    }
}

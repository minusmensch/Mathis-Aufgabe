
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Wetter[] wetterArray = new Wetter[14];
        wetterArray[0] = new Wetter(1, 12.6);
        wetterArray[1] = new Wetter(2, 14.9);
        wetterArray[2] = new Wetter(3, 9.4);
        wetterArray[3] = new Wetter(4, 12.1);
        wetterArray[4] = new Wetter(5, 15.8);
        wetterArray[5] = new Wetter(6, 16.8);
        wetterArray[6] = new Wetter(7, 15.6);
        wetterArray[7] = new Wetter(8, 15.1);
        wetterArray[8] = new Wetter(9, 11.3);
        wetterArray[9] = new Wetter(10, 8.7);
        wetterArray[10] = new Wetter(11, 13.1);
        wetterArray[11] = new Wetter(12, 13.2);
        wetterArray[12] = new Wetter(13, 15.9);
        wetterArray[13] = new Wetter(14, 12.2);

        boolean shouldContinue = true;

        System.out.println("Willkommen bei der Wetterstation von Mathis Clermont.\n\n");

        while (shouldContinue) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Möchten Sie die Wetterdaten der letzten Woche angezeigt bekommen? Geben Sie 'Wetterdaten' ein.\n");
            System.out.println("Möchten Sie die Durchschnittstemperatur der letzten 2 Wochen wissen? Geben Sie 'Durchschnitt' ein.\n");
            System.out.println("Möchten Sie die Durchschnittstemperatur der 1. Woche wissen? Geben Sie 'WocheEins' ein.\n");
            System.out.println("Möchten Sie die Durchschnittstemperatur der 2. Woche wissen? Geben Sie 'WocheZwei' ein.\n");
            System.out.println("Möchten Sie die höchste und die niedrigste Temperatur der letzten 2 Wochen wissen? Geben Sie 'Temperatur' ein\n");
            System.out.println("Möchten Sie die höchste und die niedrigste Temperatur der 1. Wochen wissen? Geben Sie 'TemperaturEins' ein\n");
            System.out.println("Möchten Sie die höchste und die niedrigste Temperatur der 2. Wochen wissen? Geben Sie 'TemperaturZwei' ein\n");
            System.out.println("Möchten Sie das Programm beenden, geben Sie 'Beenden' ein.");

            String answer = scanner.nextLine();

            if (answer.equals("Wetterdaten")) {
                printWetterdaten(wetterArray);

            } else if (answer.equals("Durchschnitt")) {
                printDurchschnittstemperatur(wetterArray);

            } else if (answer.equals("WocheEins")) {
                printErsteWocheDurchschnittstemperatur(wetterArray);

            } else if (answer.equals("WocheZwei")) {
                printZweiteWocheDurchschnittstemperatur(wetterArray);

            } else if (answer.equals("Temperatur")) {
                printExtremaTemperaturen(wetterArray);

            } else if (answer.equals("TemperaturEins")) {
                printErsteWocheExtremaTemperaturen(wetterArray);

            } else if (answer.equals("TemperaturZwei")) {
                printZweiteWocheExtremaTemperaturen(wetterArray);

            } else if (answer.equals("Beenden")) {
                shouldContinue = false;
            }

            System.out.println("Haben Sie weitere Fragen? 'JA' oder 'NEIN'");
            String userWantsToContinue = scanner.nextLine();
            if (userWantsToContinue.equals("JA")) {
                shouldContinue = true;
            } else if (userWantsToContinue.equals("NEIN")) {
                shouldContinue = false;
            }
        }
    }

    private static void printWetterdaten(Wetter[] wetterArray) {
        for (int i = 0; i < wetterArray.length; i++) {
            System.out.println("Tag: " + wetterArray[i].tag + "\nTemperatur: " + wetterArray[i].temperatur);
            System.out.println();
        }
    }

    private static void printDurchschnittstemperatur(Wetter[] wetterArray) {
        double summe = 0;

        for (int i = 0; i < wetterArray.length; i++) {
            summe = summe + wetterArray[i].temperatur;
        }

        double ergebnis = summe / 14;

        System.out.println("Die Durchschnittstemperatur liegt bei " + ergebnis + " Grad");
    }

    private static void printErsteWocheDurchschnittstemperatur(Wetter[] wetterArray) {
        double summe = 0;

        for (int i = 0; i < wetterArray.length - 7; i++) {
            summe = summe + wetterArray[i].temperatur;
        }
        double ergebnis = summe / 7;

        System.out.println("Der Durchschnitt von der 1. Woche liegt bei " + ergebnis + " Grad");
    }

    private static void printZweiteWocheDurchschnittstemperatur(Wetter[] wetterArray) {
        double summe = 0;

        for (int i = 7; i < wetterArray.length; i++) {
            summe = summe + wetterArray[i].temperatur;
        }
        double ergebnis = summe / 7;

        System.out.println("Der Durchschnitt von der 2. Woche liegt bei " + ergebnis + " Grad");
    }

    private static void printExtremaTemperaturen(Wetter[] wetterArray) {
        double max = 0;
        double low = wetterArray[0].temperatur;

        for (int i = 0; i < wetterArray.length; i++) {
            if (low > wetterArray[i].temperatur) {
                low = wetterArray[i].temperatur;
            }
        }

        for (int i = 0; i < wetterArray.length; i++) {
            if (max < wetterArray[i].temperatur) {
                max = wetterArray[i].temperatur;
            }
        }

        System.out.println("Maximale Temperatur der zwei Wochen liegt bei: " + max + "Grad");
        System.out.println("Minimale Temperatur der zwei Wochen liegt bei: " + low + "Grad");
    }

    private static void printErsteWocheExtremaTemperaturen(Wetter[] wetterArray) {
        double max = 0;
        double low = wetterArray[0].temperatur;

        for (int i = 0; i < wetterArray.length - 7; i++) {
            if (low > wetterArray[i].temperatur) {
                low = wetterArray[i].temperatur;
            }
        }

        for (int i = 0; i < wetterArray.length - 7; i++) {
            if (max < wetterArray[i].temperatur) {
                max = wetterArray[i].temperatur;
            }
        }

        System.out.println("Maximale Temperatur der 1. Wochen liegt bei: " + max + "Grad");
        System.out.println("Minimale Temperatur der 1. Wochen liegt bei: " + low + "Grad");
    }

    private static void printZweiteWocheExtremaTemperaturen(Wetter[] wetterArray) {
        double max = 0;
        double low = wetterArray[0].temperatur;

        for (int i = 7; i < wetterArray.length; i++) {
            if (low > wetterArray[i].temperatur) {
                low = wetterArray[i].temperatur;
            }
        }

        for (int i = 7; i < wetterArray.length; i++) {
            if (max < wetterArray[i].temperatur) {
                max = wetterArray[i].temperatur;
            }
        }

        System.out.println("Maximale Temperatur der 2. Wochen liegt bei: " + max + "Grad");
        System.out.println("Minimale Temperatur der 2. Wochen liegt bei: " + low + "Grad");
    }
}

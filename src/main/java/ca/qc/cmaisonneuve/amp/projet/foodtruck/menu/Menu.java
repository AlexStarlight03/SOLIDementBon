package ca.qc.cmaisonneuve.amp.projet.foodtruck.menu;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public String demanderTailleSalade() {
        System.out.print("Taille de la salade (PETITE/GRANDE): ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public String demanderVinaigretteSalade() {
        System.out.print("Vinaigrette (CESAR/MAISON): ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public String demanderTypePlat() {
        System.out.print("Type de plat (BURGER/TACO/WRAP/SALADE) ou QUIT: ");
        return scanner.nextLine().trim().toUpperCase();
    }
    public String demanderEmail() {
        System.out.print("Adresse courriel du client: ");
        return scanner.nextLine().trim();
    }

    public String demanderTel() {
        System.out.print("Numéro de téléphone du client: ");
        return scanner.nextLine().trim();
    }

    public boolean demanderOuiNon(String question) {
        System.out.print(question + " (o/n): ");
        String rep = scanner.nextLine().trim().toLowerCase();
        return rep.equals("o") || rep.equals("oui") || rep.equals("y") || rep.equals("yes");
    }
    public String demanderTypePaiement() {
        System.out.print("Type de paiement (CARTE/COMPTANT/VIREMENT): ");
        return scanner.nextLine().trim().toUpperCase();
    }
    public String demanderTypeNotification() {
        System.out.print("Comment voulez-vous être contacté (EMAIL/SMS): ");
        return scanner.nextLine().trim().toUpperCase();
    }
    public void afficherMessage(String msg) {
        System.out.println(msg);
    }
    public String demanderOption(String label, String[] valeursPossibles) {
        System.out.print(label + " (" + String.join("/", valeursPossibles) + "): ");
        return scanner.nextLine().trim().toUpperCase();
    } 
}


package ca.qc.cmaisonneuve.amp.projet.foodtruck;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        FoodTruckManager manager = new FoodTruckManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SOLIDEMENT Bon - Commandes CLI ===");
        System.out.println("Saisissez vos commandes (BURGER, TACO, WRAP). Tapez QUIT pour terminer.");
        System.out.println("Options: extraFromage (o/n), epice (o/n), typePaiement (CARTE/COMPTANT)");

        boolean running = true;
        while (running) {
            System.out.print("Type de plat (BURGER/TACO/WRAP) ou QUIT: ");
            String itemType = scanner.nextLine();
            if (itemType == null) {
                itemType = "";
            }
            itemType = itemType.trim().toUpperCase();

            if ("QUIT".equals(itemType)) {
                running = false;
                break;
            }
            if (!("BURGER".equals(itemType) || "TACO".equals(itemType) || "WRAP".equals(itemType))) {
                System.out.println("Type invalide. Veuillez saisir BURGER, TACO ou WRAP.");
                continue;
            }

            System.out.print("Adresse courriel du client: ");
            String email = scanner.nextLine();
            if (email == null) {
                email = "";
            }
            email = email.trim();

            boolean extraCheese = askYesNo(scanner, "Extra fromage (o/n): ");
            boolean spicy = askYesNo(scanner, "Epice (o/n): ");

            System.out.print("Type de paiement (CARTE/COMPTANT): ");
            String typePaiement = scanner.nextLine();
            if (typePaiement == null) {
                typePaiement = "";
            }
            typePaiement = typePaiement.trim().toUpperCase();
            if (!("CARTE".equals(typePaiement) || "COMPTANT".equals(typePaiement))) {
                System.out.println("Type de paiement non supporte: utilisation par defaut d'argent COMPTANT.");
                typePaiement = "COMPTANT";
            }

            manager.traiterCommande(email, itemType, extraCheese, spicy, typePaiement);

            System.out.println("Commande traitee. Voulez-vous passer une autre commande ? (o/n)");
            boolean again = askYesNo(scanner, "> ");
            if (!again) {
                running = false;
            }
        }

        System.out.println("Au revoir !");
        scanner.close();
    }

    private static boolean askYesNo(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String answer = scanner.nextLine();
        if (answer == null) {
            answer = "";
        }
        answer = answer.trim().toLowerCase();
        if ("y".equals(answer) || "yes".equals(answer) || "o".equals(answer) || "oui".equals(answer)) {
            return true;
        }
        return false;
    }
}

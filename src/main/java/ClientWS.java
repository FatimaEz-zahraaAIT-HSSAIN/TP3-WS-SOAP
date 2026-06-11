package client;

// On importe les classes générées par le plugin Maven
import ws.proxy.BanqueWS;
import ws.proxy.BanqueService;
import ws.proxy.Compte;
import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        // 1. Instancier le service (Le nom de la classe correspond au serviceName du WSDL)
        BanqueWS stub = new BanqueWS();

        // 2. Récupérer le port (l'interface qui contient nos méthodes)
        BanqueService port = stub.getBanqueServicePort();

        // --- TEST DES OPÉRATIONS ---

        // Test Conversion
        System.out.println("--- Test Conversion ---");
        double res = port.convertirEuroEnDH(100);
        System.out.println("100 Euros = " + res + " DH");

        // Test Consulter un compte
        System.out.println("\n--- Test Consultation de Compte ---");
        Compte c = port.getCompte(12);
        System.out.println("Code : " + c.getCode());
        System.out.println("Solde : " + c.getSolde());

        // Test Consulter une liste
        System.out.println("\n--- Test Liste des Comptes ---");
        List<Compte> comptes = port.listComptes();
        for(Compte cp : comptes) {
            System.out.println("Compte " + cp.getCode() + " | Solde : " + cp.getSolde());
        }
    }
}
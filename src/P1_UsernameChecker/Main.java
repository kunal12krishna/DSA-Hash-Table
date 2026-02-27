package P1_UsernameChecker;

public class Main {

    public static void main(String[] args) {

        UsernameService service = new UsernameService();

        // Register users
        service.registerUser("john_doe", 101);
        service.registerUser("admin", 102);

        // Check availability
        System.out.println("john_doe available? " +
                service.checkAvailability("john_doe"));

        System.out.println("jane_smith available? " +
                service.checkAvailability("jane_smith"));

        // Suggestions
        System.out.println("Suggestions for john_doe: " +
                service.suggestAlternatives("john_doe"));

        // Increase attempts
        service.checkAvailability("admin");
        service.checkAvailability("admin");
        service.checkAvailability("admin");

        // Most attempted
        System.out.println("Most Attempted: " +
                service.getMostAttempted());
    }
}
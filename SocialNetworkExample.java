import java.util.Arrays;
import java.util.logging.Logger;

public class SocialNetworkExample {
    private static final Logger logger = Logger.getLogger(SocialNetworkExample.class.getName());

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();

        // Add some users to the network
        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");
        User user3 = new User("3", "Charlie");
        User user4 = new User("4", "Diana");
        User user5 = new User("5", "Eve");

        socialNetwork.addUser(user1);
        socialNetwork.addUser(user2);
        socialNetwork.addUser(user3);
        socialNetwork.addUser(user4);
        socialNetwork.addUser(user5);

        // Establish connections between users
        socialNetwork.establishConnection("1", "2");
        socialNetwork.establishConnection("1", "3");
        socialNetwork.establishConnection("2", "4");
        socialNetwork.establishConnection("3", "5");

        // Add interests for users
        socialNetwork.addInterest("1", "Music");
        socialNetwork.addInterest("1", "Reading");
        socialNetwork.addInterest("2", "Sports");
        socialNetwork.addInterest("2", "Music");
        socialNetwork.addInterest("3", "Traveling");
        socialNetwork.addInterest("3", "Music");
        socialNetwork.addInterest("4", "Cooking");
        socialNetwork.addInterest("4", "Movies");
        socialNetwork.addInterest("5", "Music");
        socialNetwork.addInterest("5", "Reading");

        // Display users with common interests
        logger.info("Users with common interests:");
        socialNetwork.matchInterest(Arrays.asList("Music", "Reading"));

        // Given a user, display their connections
        logger.info("Connections of Alice:");
        socialNetwork.displayUserConnections("1");
    }
}

import java.util.*;
import java.util.logging.Logger;

public class SocialNetwork {
    private static final Logger logger = Logger.getLogger(SocialNetwork.class.getName());
    private Map<String, User> users;
    private Set<String> predefinedInterests;

    public SocialNetwork() {
        users = new HashMap<>();
        predefinedInterests = new HashSet<>(Arrays.asList("Music", "Sports", "Reading", "Traveling", "Cooking", "Movies"));
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        logger.info("Added user: " + user);
    }

    public void establishConnection(String userId1, String userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        if (user1 != null && user2 != null) {
            user1.addConnection(user2);
            user2.addConnection(user1);
            logger.info("Established connection between: " + user1.getName() + " and " + user2.getName());
        } else {
            logger.warning("One or both users not found: " + userId1 + ", " + userId2);
        }
    }

    public void addInterest(String userId, String interest) {
        if (!predefinedInterests.contains(interest)) {
            logger.warning("Invalid interest: " + interest);
            return;
        }
        User user = users.get(userId);
        if (user != null) {
            user.addInterest(interest);
            logger.info("Added interest: " + interest + " to user: " + user.getName());
        } else {
            logger.warning("User not found: " + userId);
        }
    }

    public void matchInterest(List<String> interests) {
        logger.info("Users with interests: " + interests);
        for (User user : users.values()) {
            if (user.getInterests().containsAll(interests)) {
                logger.info(user.toString());
            }
        }
    }

    public void displayUserConnections(String userId) {
        User user = users.get(userId);
        if (user != null) {
            logger.info(user.getName() + "'s connections:");
            for (User connection : user.getConnections()) {
                logger.info(connection.getName());
            }
        } else {
            logger.warning("User not found: " + userId);
        }
    }
}

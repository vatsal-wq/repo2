import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String userId;
    private String name;
    private List<User> connections;
    private List<String> interests;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.connections = new ArrayList<>();
        this.interests = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<User> getConnections() {
        return connections;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void addConnection(User user) {
        connections.add(user);
    }

    public void addInterest(String interest) {
        interests.add(interest);
    }

    @Override
    public String toString() {
        return "UserID: " + userId + ", Name: " + name + ", Interests: " + interests + ", Connections: " + connections.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

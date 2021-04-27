package user;

public class User {
    private String name;
    private Boolean isWhite;


    public User(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    public boolean isUserWhite() {
        return this.isWhite;
    }

    public String getUserName() {
        return this.name;
    }
}

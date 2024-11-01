package by.kiok.gallows;

public class User {

    private String username;
    private int lives;

    public User(String username, int lives) {
        this.username = username;
        this.lives = lives;
    }

    public String getUsername() {
        return username;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}

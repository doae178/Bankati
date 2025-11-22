package ma.bankati.model.users;

import java.time.LocalDate;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private ERole role;
    private LocalDate creationDate;

    // Constructeur sans arguments
    public User() {
    }

    // Constructeur avec tous les paramètres
    public User(Long id, String firstName, String lastName, String username, String password, ERole role, LocalDate creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.creationDate = creationDate;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    // Optionnel: Méthode toString pour afficher l'objet User
    @Override
    public String toString() {
        return "User{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', username='" + username + "', role=" + role + ", creationDate=" + creationDate + "}";
    }

    // Builder interne
    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;
        private ERole role;
        private LocalDate creationDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(ERole role) {
            this.role = role;
            return this;
        }

        public Builder creationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        // Méthode pour construire l'objet User
        public User build() {
            return new User(id, firstName, lastName, username, password, role, creationDate);
        }
    }
}

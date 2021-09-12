package com.example.retailstore.user;

public class User {

    private String firstName;
    private String lastName;
    private String number;
    private UserRole userRole;

    /**
     * @param firstName
     * @param lastName
     * @param number
     * @param userRole
     */
    public User(String firstName, String lastName, String number, UserRole userRole) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setNumber(number);
        setUserRole(userRole);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String telephone) {
        this.number = number;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "[firstName=" + getFirstName() + ", lastName=" + getLastName() + ", number=" + getNumber()
                + ", userType=" + getUserRole() + "]";
    }

}










package com.example.retailstore.userbuilder;

import com.example.retailstore.user.User;
import com.example.retailstore.user.UserRole;
import org.springframework.stereotype.Component;

public class UserBuilder {
    @Component
    public class userBuilder {

        private String firstName;
        private String lastName;
        private String number;
        private UserRole userRole;

        public userBuilder() {

        }

        public userBuilder firstName(String firstname) {
            this.firstName = firstname;
            return this;
        }

        public userBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public userBuilder number(String number) {
            this.number = number;
            return this;
        }

        public userBuilder userType(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User build() {
            return new User(firstName, lastName, number, userRole);
        }
    }
}

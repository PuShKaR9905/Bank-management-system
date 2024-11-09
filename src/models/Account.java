// src/models/Account.java
package models;

import java.math.BigDecimal;

public class Account {
    private int id;
    private int customerId;
    private BigDecimal balance;
    private String type;

    public Account(int id, int customerId, BigDecimal balance, String type) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.type = type;
    }

    // Getters and setters
}
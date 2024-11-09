// src/dao/AccountDAO.java
package dao;

import utils.DatabaseConnection;
import models.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public void addAccount(Account account) throws SQLException {
        String sql = "INSERT INTO Account (customer_id, balance, type) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setBigDecimal(2, account.getBalance());
            stmt.setString(3, account.getType());
            stmt.executeUpdate();
        }
    }

    public List<Account> getAllAccounts() throws SQLException {
        String sql = "SELECT * FROM Account";
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account account = new Account(
                    rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getBigDecimal("balance"),
                    rs.getString("type")
                );
                accounts.add(account);
            }
        }
        return accounts;
    }
}
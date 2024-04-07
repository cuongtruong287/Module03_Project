package dao;

import entity.Account;

public interface AccountDAO {
    Account login(String username, String password);
}

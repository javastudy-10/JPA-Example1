package com.javastudy.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "ACCOUNTS", schema = "PUBLIC", catalog = "JPA")
public class Account {
    private int id;
    private String login;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account that = (Account) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login);
    }
}

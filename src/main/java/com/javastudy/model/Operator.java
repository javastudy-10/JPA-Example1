package com.javastudy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Maxim Sambulat
 */
@Entity
@Table(name = "OPERATOR", schema = "PUBLIC", catalog = "JPA")
@NamedQuery(name = "Operator.findWithDetails",
        query = "SELECT o FROM Operator o INNER JOIN FETCH o.account WHERE o.id=:id")
public class Operator implements Serializable {
    private int id;
    private String name;
    private Account account;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator that = (Operator) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

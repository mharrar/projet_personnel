package com.example.projet_industriel_1.model;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "users_table")
public class usersmodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String login;
    String password;
    String email;
    String fullname;

    String numero_telephone;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        usersmodel that = (usersmodel) o;
        return Objects.equals(id, that.id) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(fullname,that.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email,fullname);
    }

    public usersmodel() {
    }

    public usersmodel(String login, String password, String email,String fullname,String numero_telephone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.fullname=fullname;
        this.numero_telephone=numero_telephone;
    }


}
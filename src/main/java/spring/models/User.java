package spring.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    //for oracle comment @GeneratedValue
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private Integer status;

    protected User() {
    }

    public User(String name, String password, Integer status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, name);
    }
}

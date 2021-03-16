package rtek.perpus.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "phone")
    public String phone;

    @Column(name = "email")
    public String email;

    @OneToMany(targetEntity = Borrow.class, mappedBy = "book")
    public List<Borrow> borrowedBooks;
}

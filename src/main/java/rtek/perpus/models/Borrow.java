package rtek.perpus.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long id;

    @Column(name = "borrow_date", nullable = false)
    public LocalDateTime borrowDate;

    @Column(name = "borrow_day", nullable = false)
    public int borrowDay;

    @Column(name = "borrow_qty", nullable = false)
    public int qty;

    @Column(name = "return_date")
    public LocalDateTime returnDate;

    @Column(name = "borrow_status")
    public String status;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    public Member member;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    public Book book;
}

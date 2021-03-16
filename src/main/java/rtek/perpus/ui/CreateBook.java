package rtek.perpus.ui;

import rtek.perpus.models.Book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CreateBook {
    @NotBlank(message = "Judul Tidak Boleh Kosong")
    private String title;

    @NotBlank(message = "Pembuat Tidak Boleh Kosong")
    private String author;

    @NotBlank(message = "Isbn Tidak Boleh Kosong")
    private String isbn;

    @Min(message = "Jumlah Qty Tidak Boleh Kecil Dari 0", value = 0)
    private int qty;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQty() {
        return qty;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Book toBook() {
        Book b = new Book();
        b.setTitle(getTitle());
        b.setAuthor(getAuthor());
        b.setQty(getQty());
        b.setIsbn(getIsbn());

        return b;
    }
}

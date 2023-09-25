package dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    private String id;
    private String text;
    private LocalDate date;
    private AuthorDTO author;

    public CommentDTO() {}

    public CommentDTO(String text, LocalDate date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author.getName();
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}

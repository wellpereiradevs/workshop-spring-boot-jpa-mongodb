package com.wpdevs.workshopmongo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("text")
    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}

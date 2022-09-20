package com.pluralsight.bookstore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 200)
    private String title;
    @Column(length = 1000)
    private String description;
    @Column(name = "unit_cost")
    private Float unitCost;
    private String isbn;
    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Column(name = "no_of_pages")
    private Integer nbOfPages;
    @Column(name = "image_url")
    private String imageUrl;
    private Language language;

    public Book(String isbn, String title, float unitCost, int nbOfPages, Language language, Date publicationDate, String imageURL, String description) {
        this.isbn = isbn;
        this.title = title;
        this.unitCost = unitCost;
        this.nbOfPages = nbOfPages;
        this.language = language;
        this.publicationDate = publicationDate;
        this.imageUrl = imageURL;
        this.description = description;
    }

    public Book() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", nbOfPages=" + nbOfPages +
                ", imageUrl='" + imageUrl + '\'' +
                ", language=" + language +
                '}';
    }
}

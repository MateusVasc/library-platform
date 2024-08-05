package com.matt.libraryapi.domain.entities;

import com.matt.libraryapi.domain.enums.Genre;
import com.matt.libraryapi.domain.enums.Language;
import com.matt.libraryapi.domain.enums.State;
import com.matt.libraryapi.domain.requests.SaveBookRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String title;

  @Column(nullable = false)
  private String author;

  @Column(nullable = false)
  private String publisher;

  @Column(nullable = false)
  private LocalDateTime publishedAt;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Genre genre;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Language language;

  @Column(nullable = false)
  private int numPages;

  @Column(nullable = true)
  private byte[] cover;

  @Column(nullable = false)
  private double price;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private State availability;

  @Column(nullable = false)
  private int stockCount;

  public Book(SaveBookRequest request) {
    this.title = request.title();
    this.author = request.author();
    this.publisher = request.publisher();
    this.publishedAt = request.publishedAt();
    this.genre = request.genre();
    this.language = request.language();
    this.numPages = request.numPages();
    this.cover = request.cover();
    this.price = request.price();
    this.availability = request.availability();
    this.stockCount = request.stockCount();
  }
}
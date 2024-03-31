package com.example.blogapplication.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter

@Table(name = "posts", uniqueConstraints = { @UniqueConstraint(columnNames = "title")})

public class Post {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

}

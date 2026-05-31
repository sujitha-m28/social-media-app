package com.example.social_media.Entity;
import io.micrometer.common.util.internal.logging.InternalLogger;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     private String name;
     @Column(unique = true)
     private String email;

     private String password;

    @Column(length = 500)
    private String bio;

    private String profileImage;

}

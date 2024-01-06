package com.example.springproject.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends IndexableEntity {

    private String username;

    private String encode;

}

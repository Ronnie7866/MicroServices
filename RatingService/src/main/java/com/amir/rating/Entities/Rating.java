package com.amir.rating.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_rating")
public class Rating {

    @Id
    private String id;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String feedback;
}

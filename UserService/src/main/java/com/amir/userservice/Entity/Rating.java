package com.amir.userservice.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String id;
    private Integer userId;
    private Integer hotelId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;
}

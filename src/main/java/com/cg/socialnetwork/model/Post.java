package com.cg.socialnetwork.model;


import com.cg.socialnetwork.model.enumModel.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String content;

    @ManyToOne
    @JoinColumn(name = "image_id",referencedColumnName = "id")
    private Media media;


}

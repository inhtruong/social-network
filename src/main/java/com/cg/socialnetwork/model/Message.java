package com.cg.socialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "messages")
public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_userfrom", referencedColumnName = "id")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "id_userto",referencedColumnName = "id")
    private User userTo;

    private String content;

}

package com.cg.socialnetwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FriendId implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id",referencedColumnName = "id")
    private User friend;

}

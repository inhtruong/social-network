
package com.cg.socialnetwork.model;

import com.cg.socialnetwork.model.enumModel.StatusFriend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "friends")
public class Friend{

    @EmbeddedId
    private FriendId id;

    @Enumerated(EnumType.STRING)
    private StatusFriend statusFriend;

}


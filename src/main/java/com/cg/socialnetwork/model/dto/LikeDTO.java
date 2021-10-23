package com.cg.socialnetwork.model.dto;

import com.cg.socialnetwork.model.Post;
import com.cg.socialnetwork.model.Reaction;
import com.cg.socialnetwork.model.User;

public class LikeDTO {
    private User user;
    private Post post;
    private Reaction reactionId;

    public LikeDTO() {
    }

    public LikeDTO(User user, Post post, Reaction reactionId) {
        this.user = user;
        this.post = post;
        this.reactionId = reactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Reaction getReactionId() {
        return reactionId;
    }

    public void setReactionId(Reaction reactionId) {
        this.reactionId = reactionId;
    }
}

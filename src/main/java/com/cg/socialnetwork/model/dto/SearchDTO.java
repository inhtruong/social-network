package com.cg.socialnetwork.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchDTO {
    private long id;
    private String name;
    private String avatar;

    public SearchDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

package com.crud.tasks.domain;

import lombok.Data;

@Data
public class TrelloBoardDto {
    private String name;
    private String id;

    @Override
    public String toString() {
        return "ID = " + id + "  name: " + name;
    }
}

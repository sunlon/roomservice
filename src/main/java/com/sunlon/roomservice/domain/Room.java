package com.sunlon.roomservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private  String name;
    private Map<String,Object> attributes = new HashMap<>();
}

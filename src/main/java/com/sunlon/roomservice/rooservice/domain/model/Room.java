package com.sunlon.roomservice.rooservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Room {
    @Id
    private String id;
    private  String name;
    private Map<String,Object> attributes;
}

package com.sunlon.roomservice.rooservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@Data
public class RoomResponse {
    private String id;
    private  String name;
    private Map<String,Object> attributes;
}

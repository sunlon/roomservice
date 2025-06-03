package com.sunlon.roomservice.rooservice.application.dto;

import lombok.Data;

import java.util.Map;
@Data
public class RoomRequest {
//    @NotBlank(message = "name is required")
    private String id;
    private  String name;
    private Map<String,Object> attributes;
}

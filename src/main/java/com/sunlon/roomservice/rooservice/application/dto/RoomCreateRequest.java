package com.sunlon.roomservice.rooservice.application.dto;

import lombok.Data;

import java.util.Map;
@Data
public class RoomCreateRequest {
    private  String name;
    private Map<String,Object> attributes;
}

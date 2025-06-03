package com.sunlon.roomservice.rooservice.application.mapper;

import com.sunlon.roomservice.rooservice.application.dto.RoomRequest;
import com.sunlon.roomservice.rooservice.application.dto.RoomResponse;
import com.sunlon.roomservice.rooservice.domain.model.Room;


public class RoomMapper {

    public static Room toDomain(RoomRequest request) {

        Room room = new Room();
        room.setId(request.getId());
        room.setName(request.getName());
        room.setAttributes(request.getAttributes());
        return room;
    }

    public static Room toDomain(String id, RoomRequest request) {

        Room room = new Room();
        room.setId(id);
        room.setName(request.getName());
        room.setAttributes(request.getAttributes());
        return room;
    }

    public static RoomResponse toResponse(Room room) {
        RoomResponse response = new RoomResponse();
        response.setId(room.getId());
        response.setName(room.getName());
        response.setAttributes(room.getAttributes());

        return response;
    }

    public static Room toUpdatedDomain(RoomRequest request, Room existing) {
        existing.setName(request.getName());
        existing.setAttributes(request.getAttributes());
        return existing;
    }

}

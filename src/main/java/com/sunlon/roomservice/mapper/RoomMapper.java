package com.sunlon.roomservice.mapper;

import com.sunlon.roomservice.dto.RoomDTO;
import com.sunlon.roomservice.domain.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public Room toRoom(RoomDTO roomDTO){
        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setAttributes(roomDTO.getAttributes());
        return  room;
    }

    public RoomDTO toRoomDTO(Room room){
        RoomDTO dto = new RoomDTO();
        dto.setName(room.getName());
        dto.setAttributes(room.getAttributes());
        return dto;
    }
}

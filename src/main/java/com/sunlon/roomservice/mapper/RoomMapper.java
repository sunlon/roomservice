package com.sunlon.roomservice.mapper;

import com.sunlon.roomservice.dto.RoomDTO;
import com.sunlon.roomservice.domain.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface RoomMapper {
    Room toRoom(RoomDTO roomDTO);
    Room updateRoomFromDTO(RoomDTO roomDTO, @MappingTarget Room room);
    RoomDTO toRoomDTO(Room room);

}

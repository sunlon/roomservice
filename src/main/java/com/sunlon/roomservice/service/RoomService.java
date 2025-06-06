package com.sunlon.roomservice.service;


import com.sunlon.roomservice.domain.Room;
import com.sunlon.roomservice.dto.RoomDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {

    Flux<RoomDTO> getAll();
    Mono<RoomDTO> getRoomById(String id);
    Mono<RoomDTO> createRoom(RoomDTO roomDTO);
    Mono<RoomDTO> updateRoom(String id,RoomDTO roomDTO);
    Mono<Void> deleteRoomById(String id);
}

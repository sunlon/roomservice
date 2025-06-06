package com.sunlon.roomservice.controller;


import com.sunlon.roomservice.dto.RoomDTO;

import com.sunlon.roomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public Mono<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }

    @GetMapping
    public Flux<RoomDTO> getAllRoom() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<RoomDTO> getRoomById(@PathVariable String id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public Mono<RoomDTO> updateRoom(@PathVariable String id, @RequestBody RoomDTO roomDTO) {
        return roomService.updateRoom(id, roomDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
     return roomService.deleteRoomById(id);
    }

}

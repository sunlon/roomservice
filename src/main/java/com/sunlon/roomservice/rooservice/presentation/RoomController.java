package com.sunlon.roomservice.rooservice.presentation;


import com.sunlon.roomservice.rooservice.application.dto.RoomRequest;

import com.sunlon.roomservice.rooservice.application.dto.RoomResponse;
import com.sunlon.roomservice.rooservice.application.mapper.RoomMapper;
import com.sunlon.roomservice.rooservice.application.service.RoomService;
import com.sunlon.roomservice.rooservice.domain.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public Mono<RoomResponse> create(@RequestBody RoomRequest request) {
        return roomService.save(RoomMapper.toDomain(request)).map(RoomMapper::toResponse);
    }

    @GetMapping
    public Flux<RoomResponse> getAll() {
        return roomService.findAll().map(RoomMapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<RoomResponse> getById(@PathVariable String id) {
        return roomService.findById(id)
                .map(RoomMapper::toResponse);
    }

    @PutMapping("/{id}")
    public Mono<RoomResponse> update(@PathVariable String id, @RequestBody RoomRequest request) {
        return roomService.update(id, RoomMapper.toDomain(request))
                .map(RoomMapper::toResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
         roomService.deleteById(id);
    }

}

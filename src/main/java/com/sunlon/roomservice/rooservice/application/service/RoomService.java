package com.sunlon.roomservice.rooservice.application.service;


import com.sunlon.roomservice.rooservice.domain.model.Room;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {

    Flux<Room> findAll();
    Mono<Room> findById(String id);
    Mono<Room> save(Room room);
    Mono<Room> update(String id,Room room);
    Mono<Void> deleteById(String id);
}

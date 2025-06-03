package com.sunlon.roomservice.rooservice.application.service.imp;

import com.sunlon.roomservice.rooservice.application.mapper.RoomMapper;
import com.sunlon.roomservice.rooservice.domain.model.Room;
import com.sunlon.roomservice.rooservice.domain.repository.RoomRepository;
import com.sunlon.roomservice.rooservice.application.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;


    private RoomMapper roomMapper;

    @Override
    public Flux<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Room> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Room> save(Room room) {
        return repository.save(room);
    }

    @Override
    public Mono<Room> update(String id,Room room) {
        return repository.update(id, room);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}

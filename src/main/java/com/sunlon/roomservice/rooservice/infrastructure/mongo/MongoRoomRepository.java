package com.sunlon.roomservice.rooservice.infrastructure.mongo;

import com.sunlon.roomservice.rooservice.domain.model.Room;
import com.sunlon.roomservice.rooservice.domain.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public  class MongoRoomRepository implements RoomRepository {

    private final MongoRoomReactiveRepository repository;
    @Override
    public Flux<Room> findAll() {
        return repository.findAll().map(RoomDocument::toDomain);
    }

    @Override
    public Mono<Room> findById(String id) {
        return repository.findById(id).map(RoomDocument::toDomain);
    }

    @Override
    public Mono<Room> save(Room room) {
        return repository.save(RoomDocument.fromDomain(room)).map(RoomDocument::toDomain);
    }

    @Override
    public Mono<Room> update(String id ,Room room) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(room.getName());
                    existing.setAttributes(room.getAttributes());
                    return repository.save(existing);
                })
                .map(RoomDocument::toDomain);

    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}

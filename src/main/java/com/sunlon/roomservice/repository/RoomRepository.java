package com.sunlon.roomservice.repository;

import com.sunlon.roomservice.domain.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoomRepository extends ReactiveMongoRepository<Room,String> {

}

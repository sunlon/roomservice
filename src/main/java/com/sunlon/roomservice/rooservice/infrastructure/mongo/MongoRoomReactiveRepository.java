package com.sunlon.roomservice.rooservice.infrastructure.mongo;

import com.sunlon.roomservice.rooservice.domain.model.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MongoRoomReactiveRepository extends ReactiveMongoRepository<RoomDocument,String> {

}

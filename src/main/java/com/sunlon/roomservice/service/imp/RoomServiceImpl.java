package com.sunlon.roomservice.service.imp;

import com.sunlon.roomservice.dto.RoomDTO;
import com.sunlon.roomservice.mapper.RoomMapper;
import com.sunlon.roomservice.domain.Room;
import com.sunlon.roomservice.repository.RoomRepository;
import com.sunlon.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomMapper roomMapper;


    @Override
    public Flux<RoomDTO> getAll() {



        return  repository.findAll().map( roomMapper::toRoomDTO);
    }

    @Override
    public Mono<RoomDTO> getRoomById(String id) {

        return repository.findById(id).map(roomMapper::toRoomDTO);
    }

    @Override
    public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {



        Room room = roomMapper.toRoom(roomDTO);
        return  repository.save(room).map( roomMapper::toRoomDTO);

    }

    @Override
    public Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO) {
    //    Room room = roomMapper.toRoom(roomDTO);
        return  repository.findById(id).flatMap( existringRoom->{
            return  repository.save(roomMapper.updateRoomFromDTO(roomDTO,existringRoom));
                }
        ).map(roomMapper::toRoomDTO);

    }

    @Override
    public Mono<Void> deleteRoomById(String id) {
        return repository.deleteById(id);
    }
}

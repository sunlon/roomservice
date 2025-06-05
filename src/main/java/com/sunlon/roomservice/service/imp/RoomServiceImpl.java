package com.sunlon.roomservice.service.imp;

import com.sunlon.roomservice.dto.RoomDTO;
import com.sunlon.roomservice.mapper.RoomMapper;
import com.sunlon.roomservice.domain.Room;
import com.sunlon.roomservice.repository.RoomRepository;
import com.sunlon.roomservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomMapper roomMapper;


//    @Override
//    public Flux<RoomDTO> getAll() {
//
//        Flux<RoomDTO> flux=repository.findAll().map(r -> roomMapper.toRoomDTO(r));
//        return  flux;
//    }

//    @Override
//    public Mono<RoomDTO> getRoomById(String id) {
//        return repository.findById(id).map(r -> roomMapper.toRoomDTO(r));
//    }

    @Override
    public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toRoom(roomDTO);

        Mono<RoomDTO> mono =  repository.save(room).map(r -> roomMapper.toRoomDTO(r));
        return mono;

    }

//    @Override
//    public Mono<RoomDTO> updateRoom(String id, RoomDTO roomDTO) {
//
//        return null;
//    }

//    @Override
//    public Mono<Void> deleteRoomById(String id) {
//        return repository.deleteById(id);
//    }
}

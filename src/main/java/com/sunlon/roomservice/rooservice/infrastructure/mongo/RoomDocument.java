package com.sunlon.roomservice.rooservice.infrastructure.mongo;

import com.sunlon.roomservice.rooservice.domain.model.Room;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "rooms")
public class RoomDocument {
    @Id
    private String id;
    private  String name;
    private Map<String,Object> attributes;


    // ✅ Map to domain
    public Room toDomain() {
        Room room = new Room();
        room.setId(this.id);
        room.setName(this.name);
        room.setAttributes(this.attributes);
        return room;
    }

    // ✅ Map from domain
    public static RoomDocument fromDomain(Room room) {
        RoomDocument doc = new RoomDocument();
        doc.setId(room.getId());
        doc.setName(room.getName());
        doc.setAttributes(room.getAttributes());
        return doc;
    }

}

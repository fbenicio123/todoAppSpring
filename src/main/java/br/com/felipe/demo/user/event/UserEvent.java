package br.com.felipe.demo.user.event;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {
    private UUID userId;
    private enum eventType {
        CREATED,
        UPDATED,
        DELETED;
    };
    private eventType type;
    private String email;
    private String name;
    private Instant currentTimestamp = Instant.now();

}

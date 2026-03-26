package br.com.felipe.demo.user.event;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {
    private UUID userId;
    private String eventType;
    private String email;
    private String name;
    private LocalDateTime timestamp;
}

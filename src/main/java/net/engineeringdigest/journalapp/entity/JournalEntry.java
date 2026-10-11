package net.engineeringdigest.journalapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class JournalEntry {

    private String id;
    private String title;
    private String content;
    private LocalDateTime date = LocalDateTime.now();
}

package net.engineeringdigest.journalapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserEntity {

    private String id;
    private String username;
    private String password;
    private List<String> roles = new ArrayList<>();
    private List<JournalEntry> journalEntries = new ArrayList<>();
}

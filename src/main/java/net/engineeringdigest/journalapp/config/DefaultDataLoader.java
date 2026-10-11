package net.engineeringdigest.journalapp.config;

import net.engineeringdigest.journalapp.entity.JournalEntry;
import net.engineeringdigest.journalapp.entity.UserEntity;
import net.engineeringdigest.journalapp.service.JournalEntryService;
import net.engineeringdigest.journalapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Seeds the in-memory store so the APIs have default data on startup.
@Configuration
public class DefaultDataLoader {

    @Bean
    public CommandLineRunner loadDefaultData(UserService userService, JournalEntryService journalEntryService) {
        return args -> {
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setPassword("password");
            userService.saveUser(user);

            JournalEntry entry = new JournalEntry();
            entry.setTitle("Welcome");
            entry.setContent("This is a default journal entry.");
            journalEntryService.saveEntry(entry, "user");
        };
    }
}

package net.engineeringdigest.journalapp.repository;

import net.engineeringdigest.journalapp.entity.JournalEntry;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

// In-memory store (no database); data is lost on restart.
@Repository
public class JournalEntryRepository {

    private final Map<String, JournalEntry> entries = new ConcurrentHashMap<>();

    public JournalEntry save(JournalEntry entry) {
        if (entry.getId() == null) {
            entry.setId(UUID.randomUUID().toString());
        }
        entries.put(entry.getId(), entry);
        return entry;
    }

    public Optional<JournalEntry> findById(String id) {
        return Optional.ofNullable(entries.get(id));
    }

    public void deleteById(String id) {
        entries.remove(id);
    }
}

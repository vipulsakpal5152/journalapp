package net.engineeringdigest.journalapp.service;

import net.engineeringdigest.journalapp.entity.JournalEntry;
import net.engineeringdigest.journalapp.entity.UserEntity;
import net.engineeringdigest.journalapp.repository.JournalEntryRepository;
import net.engineeringdigest.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(JournalEntry entry, String username) {
        JournalEntry saved = journalEntryRepository.save(entry);
        UserEntity user = userRepository.findByUsername(username);
        user.getJournalEntries().add(saved);
        userRepository.save(user);
    }

    public List<JournalEntry> getAllEntriesOfUser(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return user.getJournalEntries();
    }

    public Optional<JournalEntry> findById(String id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteEntry(String id, String username) {
        journalEntryRepository.deleteById(id);
        UserEntity user = userRepository.findByUsername(username);
        user.getJournalEntries().removeIf(e -> e.getId().equals(id));
        userRepository.save(user);
    }
}

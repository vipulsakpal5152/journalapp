package net.engineeringdigest.journalapp.controller;

import net.engineeringdigest.journalapp.entity.JournalEntry;
import net.engineeringdigest.journalapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAll(Authentication auth) {
        return ResponseEntity.ok(journalEntryService.getAllEntriesOfUser(auth.getName()));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody JournalEntry entry, Authentication auth) {
        journalEntryService.saveEntry(entry, auth.getName());
        return ResponseEntity.ok("Journal entry created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id, Authentication auth) {
        journalEntryService.deleteEntry(id, auth.getName());
        return ResponseEntity.ok("Deleted successfully");
    }
}
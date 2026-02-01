package io.github.beldeanStefania.service;

import io.github.beldeanStefania.dto.PreferenceUpdatedEvent;
import io.github.beldeanStefania.entities.PreferencesDocument;
import io.github.beldeanStefania.repository.PreferenceRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PreferencesService {

    private final PreferenceRepository repo;
    private final KafkaTemplate<String, PreferenceUpdatedEvent> kafka;
    private static final String TOPIC = "consumer.preferences";

    public PreferencesService(PreferenceRepository repo,
                              KafkaTemplate<String, PreferenceUpdatedEvent> kafka) {
        this.repo = repo;
        this.kafka = kafka;
    }

    public PreferencesDocument savePreferences(PreferencesDocument doc) {
        // 1) persist
        PreferencesDocument saved = repo.save(doc);

        // 2) event
        PreferenceUpdatedEvent event = new PreferenceUpdatedEvent();
        // asigură-te că PreferencesDocument are getCustomerId()
        event.setUserId(saved.getCustomerId());
        event.setPrefs(saved.getPrefs());
        event.setOccurredAt(Instant.now());

        // 3) publish
        kafka.send(TOPIC, event);

        return saved;
    }

    // optional: alias pentru handler-ul tău XML care cheamă save(...)
    public PreferencesDocument save(PreferencesDocument doc) {
        return savePreferences(doc);
    }
}

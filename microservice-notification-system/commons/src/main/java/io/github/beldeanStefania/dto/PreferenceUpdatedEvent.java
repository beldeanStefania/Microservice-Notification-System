package io.github.beldeanStefania.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.beldeanStefania.model.Preferences;

import java.time.Instant;
import java.util.Map;

public class PreferenceUpdatedEvent {
    private String userId;
    private Map<String, Preferences> prefs;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant occurredAt;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    private String eventId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Preferences> getPrefs() {
        return prefs;
    }

    public void setPrefs(Map<String, Preferences> prefs) {
        this.prefs = prefs;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}

package io.github.beldeanStefania.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.beldeanStefania.model.Preferences;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Document
public class PreferencesDocument extends BaseDocument{
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private String customerId;
    Map<String, Preferences> prefs;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedAt;
    public static final String TYPE = "preferences";

    private final String type = TYPE;

    public Map<String, Preferences> getPrefs() {
        return prefs;
    }

    public void setPrefs(Map<String, Preferences> prefs) {
        this.prefs = prefs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getType() {
        return type;
    }
}

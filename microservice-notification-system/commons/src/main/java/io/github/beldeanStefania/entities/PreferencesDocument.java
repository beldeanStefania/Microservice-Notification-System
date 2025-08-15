package io.github.beldeanStefania.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.beldeanStefania.model.Preferences;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document
public class PreferencesDocument extends BaseDocument{
    Map<String, Preferences> prefs;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss'")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss'")
    private Date modifiedAt;
    public static final String TYPE = "preferences";

    private final String type = TYPE;
}

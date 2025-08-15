package io.github.beldeanStefania.repository;

import io.github.beldeanStefania.entities.PreferencesDocument;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.Optional;

public interface PreferenceRepository extends CouchbaseRepository<PreferencesDocument, String> {
    Optional<PreferencesDocument> findByCustomerId(String customerId);
}

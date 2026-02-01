package io.github.beldeanStefania.config;
import com.couchbase.client.core.env.IoConfig;
import com.couchbase.client.core.env.TimeoutConfig;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.time.Duration;

@Configuration
///
@PropertySource("classpath:application.properties")
@EnableCouchbaseRepositories(basePackages = "io.github.beldeanStefania.repository")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private Environment env;

    @Value("${spring.couchbase.connection-string}")
    private String connectionString;

    @Value("${spring.couchbase.username}")
    private String username;

    @Value("${spring.couchbase.password}")
    private String password;

    @Value("${spring.data.couchbase.bucket-name}")
    private String bucketName;

    @Value("${spring.data.couchbase.scope-name:}")
    private String scopeName; // optional

    @Override
    public String getConnectionString() {
        return env.getProperty("spring.couchbase.connection-string", "127.0.0.1");
    }

    @Override
    public String getUserName() {
        return env.getRequiredProperty("spring.couchbase.username");
    }

    @Override
    public String getPassword() {
        return env.getRequiredProperty("spring.couchbase.password");
    }

    @Override
    public String getBucketName() {
        return env.getRequiredProperty("spring.data.couchbase.bucket-name");
    }

    @Override public String getScopeName() {
        return env.getProperty("spring.data.couchbase.scope-name", "_default");
    }

    @Override
    protected void configureEnvironment(ClusterEnvironment.Builder builder) {
        builder
                .timeoutConfig(
                        TimeoutConfig
                                .connectTimeout(Duration.ofSeconds(12))
                                .kvTimeout(Duration.ofSeconds(12))
                )
                .ioConfig(IoConfig.numKvConnections(4));
    }
}

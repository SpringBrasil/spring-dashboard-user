package br.com.springbrasil.user.configuration;

import javax.sql.DataSource;
import java.io.IOException;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import de.flapdoodle.embed.process.runtime.Network;
import ru.yandex.qatools.embed.postgresql.PostgresExecutable;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;


@Configuration
public class DatabaseConfiguration {

    @Bean
    public PostgresProcess postgresProcess() throws IOException {

        PostgresConfig postgresConfig = new PostgresConfig(
            Version.V9_6_5,
            new AbstractPostgresConfig.Net("localhost", Network.getFreeServerPort()),
            new AbstractPostgresConfig.Storage("spring_dashboard_user_db"),
            new AbstractPostgresConfig.Timeout(),
            new AbstractPostgresConfig.Credentials("noob", "10203040")
        );

        PostgresStarter<PostgresExecutable, PostgresProcess> runtime = PostgresStarter.getDefaultInstance();
        PostgresExecutable exec = runtime.prepare(postgresConfig);
        PostgresProcess process = exec.start();

        return process;
    }

    @Bean
    public DataSource dataSource(PostgresProcess postgresProcess) {

        PGPoolingDataSource dataSource = new PGPoolingDataSource();

        PostgresConfig postgresConfig = postgresProcess.getConfig();
        dataSource.setUser(postgresConfig.credentials().username());
        dataSource.setPassword(postgresConfig.credentials().password());
        dataSource.setPortNumber(postgresConfig.net().port());
        dataSource.setServerName(postgresConfig.net().host());
        dataSource.setDatabaseName(postgresConfig.storage().dbName());

        return dataSource;
    }
}
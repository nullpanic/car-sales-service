package dev.nullpanic.messageservice.config;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;


public class LiquibaseStarter {

    @Value("${liquibase.change-log}")
    private String changeLogPath;

    private final DataSource dataSource;

    public LiquibaseStarter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void startLiquibase() throws LiquibaseException, SQLException {
        java.sql.Connection connection = dataSource.getConnection();

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        try (Liquibase liquibase = new liquibase.Liquibase(changeLogPath, new ClassLoaderResourceAccessor(), database)) {
            liquibase.update(new Contexts(), new LabelExpression());
        }
    }


}

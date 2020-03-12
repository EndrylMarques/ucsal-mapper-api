package br.ucsal.ucsal.mapper.ucsalmapper.repositories;

import org.neo4j.driver.*;
import org.springframework.beans.factory.annotation.Value;

public class DbConnection {

    @Value("${spring.data.neo4j.uri}")
    private String urlDatabase;
    @Value("${spring.data.neo4j.username}")
    private String user;
    @Value("${spring.data.neo4j.password}")
    private String password;

    public void testingConnection() {
        System.out.println("Testando a conexão ein ");

        Config noSSL = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();

        System.out.println(urlDatabase + " < url;");
        System.out.println(user + " < user;");
        System.out.println(password + " < password;");

        Driver driver = GraphDatabase.driver(urlDatabase, AuthTokens.basic(user,password), noSSL);

        try (Session session = driver.session()) {
            String cypherQuery =
                    "MATCH (n) " +
                            "RETURN id(n) AS id";
            StatementResult result = session.run(cypherQuery, parameters());
            while (result.hasNext()) {
                System.out.println(result.next().get("id"));
            }
        }

    }


}

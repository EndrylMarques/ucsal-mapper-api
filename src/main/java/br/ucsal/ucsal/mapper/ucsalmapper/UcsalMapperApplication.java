package br.ucsal.ucsal.mapper.ucsalmapper;

import br.ucsal.ucsal.mapper.ucsalmapper.repositories.DbConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UcsalMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcsalMapperApplication.class, args);

		DbConnection db = new DbConnection();
		db.testingConnection();

	}

}

package com.practice.symphony.coreservice.config;

import java.util.Objects;

import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;

public class DatabaseConfiguration extends SimpleMongoClientDatabaseFactory {

	private String DbConnectionString;

	public DatabaseConfiguration(String dbConnectionString, ConnectionString connectionString) {
		super(connectionString);
		this.DbConnectionString = dbConnectionString;
	}

	@Override
	protected MongoDatabase doGetMongoDatabase(String dbName) {

		System.out.println("DbConnectionString in doGetMongoDatabase: "+DbConnectionString);
		ConnectionString connectionString = new ConnectionString(DbConnectionString);
		System.out.println(" doGetMongoDatabase: "+"  "+connectionString + "  " + connectionString.getUsername() + "  "
				+ String.valueOf(connectionString.getPassword()) + "   " + connectionString.getDatabase());
		return super.doGetMongoDatabase(Objects.requireNonNull(connectionString.getDatabase()));
	}
}

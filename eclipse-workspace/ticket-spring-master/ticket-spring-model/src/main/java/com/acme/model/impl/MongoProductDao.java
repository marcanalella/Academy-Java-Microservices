package com.acme.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.bson.Document;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import com.acme.model.Product;
import com.acme.model.ProductDao;
import com.acme.model.ProductType;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
@ConfigurationProperties(prefix = "mongo")
public class MongoProductDao implements ProductDao {
	private MongoClient client;
	private MongoDatabase db;
	private int port = 27017;
	
	// FIXME: should be set by config, but doesnt' work
	private String host = "mongodb"; // "localhost";
	private String dbName = "sampledb";
	private String collectionName = "products";
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@PostConstruct
	void initialize() {
		String client_url = "mongodb://" + host + ":" + port + "/" + dbName;
		MongoClientURI uri = new MongoClientURI(client_url);
	    client = new MongoClient(uri);
		db = client.getDatabase(dbName);
	}
	
	@PreDestroy
	void destroy() {
		client.close();
	}

	@Override
	public List<Product> getAllProducts() {
		MongoCollection<Document> coll = db.getCollection(collectionName);	
		
		try (Stream<Document> s = StreamSupport.stream(coll.find().spliterator(), false)) {
			return s.map(MongoProductDao::toProduct).collect(Collectors.toList());
		}
	}
	
	private static Product toProduct (Document doc) {
		String id = doc.getString("_id");
		String name = doc.getString("name");
		double price = doc.getDouble("price");
		List<ProductType> types = new ArrayList<>(); // TODO
		return new Product(id, name, price, types);
	}

	@Override
	public void insertProduct(Product product) {
		db.getCollection(collectionName).insertOne(toDocument(product));
	}
	
	private static Document toDocument (Product product) {
		Document doc = new Document();
		doc.put("_id", product.getId());
		doc.put("name", product.getName());
		doc.put("price", product.getPrice());
		// TODO types
		return doc;
	}

	@Override
	public Optional<Product> findProductById(String id) {
		return null;
	}
}

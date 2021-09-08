package com.sme.poc;


import com.ibm.watson.discovery.v1.Discovery;
import com.ibm.watson.discovery.v1.model.Collection;
import com.ibm.watson.discovery.v1.model.GetCollectionOptions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmesearchpocApplication {

	public static void main(String[] args) {
		// Discovery discovery = new Discovery("2019-04-30");

		// String environmentId = "b21d9de6-7124-4035-8343-9046fce25703";
		// String collectionId = "882a3d1f-3dd2-46e1-86c5-b2fce32affa8";

		// GetCollectionOptions getOptions = new
		// GetCollectionOptions.Builder( environmentId, collectionId).build();
		// Collection getResponse = 
		// discovery.getCollection(getOptions).execute().getResult();
		// System.out.println(getResponse);
		SpringApplication.run(SmesearchpocApplication.class, args);
		
	}

}

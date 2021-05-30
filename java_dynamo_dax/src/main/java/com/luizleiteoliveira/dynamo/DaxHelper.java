package com.luizleiteoliveira.dynamo;

import com.amazon.dax.client.dynamodbv2.AmazonDaxClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DaxHelper {

    private static final String region = "us-east-1";

    DynamoDB getDaxClient(String daxEndpoint) {
        System.out.println("Creating a DAX client with cluster endpoint " + daxEndpoint);
        AmazonDaxClientBuilder daxClientBuilder = AmazonDaxClientBuilder.standard();
        daxClientBuilder.withRegion(region).withEndpointConfiguration(daxEndpoint);
        AmazonDynamoDB client = daxClientBuilder.build();
        return new DynamoDB(client);
    }

    void writeData(String tableName, DynamoDB client, String json) {
        Table table = client.getTable(tableName);
        System.out.println("Writing data to the table..."+ tableName);
        Item item = new Item().fromJSON(json);
        try {
            table.putItem(item);
        } catch (Exception e) {
            System.err.println("Unable to write item:");
            e.printStackTrace();
        }
    }

    private static void retrieveItem(String tableName, DynamoDB client, Long id) {
        Table table = client.getTable(tableName);

        try {

            Item item = table.getItem("id", id);

            System.out.println("Printing item after retrieving it....");
            System.out.println(item.toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("GetItem failed.");
            System.err.println(e.getMessage());
        }

    }

}

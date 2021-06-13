package com.luizleiteoliveira.dynamo;

import com.amazon.dax.client.dynamodbv2.AmazonDaxClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

import java.util.Iterator;

public class DynamoClientHelper {

    private static final String region = "us-east-1";

    DynamoDB getDaxClient(String daxEndpoint) {
        System.out.println("Creating a DAX client with cluster endpoint " + daxEndpoint);
        AmazonDaxClientBuilder daxClientBuilder = AmazonDaxClientBuilder.standard();
        daxClientBuilder.withRegion(region).withEndpointConfiguration(daxEndpoint);
        AmazonDynamoDB client = daxClientBuilder.build();
        return new DynamoDB(client);
    }

    DynamoDB getDynamoClient(BasicAWSCredentials awsCredentialsProvider) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentialsProvider)).build();
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

    public Item retrieveItem(String tableName, DynamoDB client, Long id) {
        Table table = client.getTable(tableName);

        Item item = table.getItem("id", id);

        System.out.println("Printing item after retrieving it....");
        System.out.println(item.toJSONPretty());

        return item;

    }

    public int queryIndexCount(DynamoDB client, String tableName, String indexName, String ucode) {
        Table table = client.getTable(tableName);

        System.out.println("\n***********************************************************\n");
        System.out.print("Querying index " + indexName + "...");

        Index index = table.getIndex(indexName);

        ItemCollection<QueryOutcome> items = null;

        QuerySpec querySpec = new QuerySpec();


        querySpec.withKeyConditionExpression("ucode = :ucode")
                .withValueMap(new ValueMap().withString(":ucode", ucode));
        items = index.query(querySpec);

        Iterator<Item> iterator = items.iterator();

        System.out.println("Query: printing results...");
        int count = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toJSONPretty());
            count = count + 1;
        }
        return count;
    }

}

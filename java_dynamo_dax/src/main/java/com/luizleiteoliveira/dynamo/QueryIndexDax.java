package com.luizleiteoliveira.dynamo;


import java.util.Iterator;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashMap;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class QueryIndexDax {

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

package com.luizleiteoliveira.dynamo;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class MainClass {


    public static void main(String[] args) {


        DynamoClientHelper dynamoClientHelper = new DynamoClientHelper();

        String tableName = null;
        String accessKey = null;
        String secretKey = null;
        String daxEndpoint = null;
        if (args.length >= 1) {
            tableName = args[0]; // table name as parameter
            accessKey = args[1];
            secretKey = args[2];
            if (args.length > 3) {
                daxEndpoint = args[3];
            }
        }
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

        DynamoDB dynamoDB = dynamoClientHelper.getDynamoClient(awsCredentials);

        long start = System.currentTimeMillis();
        String json = "{\n" +
                "  \"context\": \"dataTest\",\n" +
                "  \"data\": \"teste=\",\n" +
                "  \"id\": \"1234"+start+"\",\n" +
                "  \"ucode\": \"AE82E1F33FEDF83D6E9A9ED9F30673C7\"\n" +
                "}";


        assert dynamoDB != null;
        System.out.println("Verificando itens para ucode ..... AE82E1F33FEDF83D6E9A9ED9F30673C7");
//        int i = queryIndexDax.queryIndexCount(dynamoDB, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
//        System.out.println("Quantidade de itens = "+ i);
        System.out.println("Populando itens ..... ");
        dynamoClientHelper.writeData(tableName, dynamoDB, json);
//        int j = queryIndexDax.queryIndexCount(dynamoDB, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
//        while (j< i+1) {
//            j = queryIndexDax.queryIndexCount(dynamoDB, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
//            System.out.println("Quantidade de itens = "+ j);
//        }
        System.out.println("Time in milisseconds: "+ (System.currentTimeMillis() - start));



    }
}

package com.luizleiteoliveira.dynamo;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class MainClass {


    public static void main(String[] args) {


        DaxHelper daxHelper = new DaxHelper();
        QueryIndexDax queryIndexDax = new QueryIndexDax();

        DynamoDB daxClient = null;
        String tableName = null;
        if (args.length >= 1) {
            daxClient = daxHelper.getDaxClient(args[0]);// pass endpoint on args to connect
            tableName = args[1]; // table name as parameter
        }

        long start = System.currentTimeMillis();
        String json = "{\n" +
                "  \"context\": \"bankingData\",\n" +
                "  \"data\": \"teste=\",\n" +
                "  \"id\": \"1234"+start+"\",\n" +
                "  \"ucode\": \"AE82E1F33FEDF83D6E9A9ED9F30673C7\"\n" +
                "}";


        assert daxClient != null;
        System.out.println("Verificando itens para ucode ..... AE82E1F33FEDF83D6E9A9ED9F30673C7");
        int i = queryIndexDax.queryIndexCount(daxClient, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
        System.out.println("Quantidade de itens = "+ i);
        System.out.println("Populando itens ..... ");
        daxHelper.writeData(tableName, daxClient, json);
        int j = queryIndexDax.queryIndexCount(daxClient, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
        while (j< i+1) {
            j = queryIndexDax.queryIndexCount(daxClient, tableName, "ucode_index", "AE82E1F33FEDF83D6E9A9ED9F30673C7");
            System.out.println("Quantidade de itens = "+ j);
        }
        System.out.println("Time in milisseconds: "+ (System.currentTimeMillis() - start));



    }
}

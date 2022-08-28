package org.luizleiteoliveira.examples;


import java.util.ArrayList;
import java.util.List;

public class CeasarCypherExamples {

    private static final String ALPHABETH = " ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public String encrypt(String plainText, int key){
        String upperCaseText = plainText.toUpperCase();
        StringBuilder encryptText = new StringBuilder();
        for (int charPosition = 0; charPosition < plainText.length(); charPosition++ ) {
            char currentChar = upperCaseText.charAt(charPosition);
            encryptText.append(ALPHABETH.charAt(Math.floorMod(ALPHABETH.indexOf(currentChar) + key, ALPHABETH.length())));
        }
        return encryptText.toString();
    }

    public String decrypt(String cypherText, int key){

        StringBuilder decryptText = new StringBuilder();

        for (int charPosition = 0; charPosition < cypherText.length(); charPosition++ ) {
            char currentChar = cypherText.charAt(charPosition);
            decryptText.append(ALPHABETH.charAt(Math.floorMod(ALPHABETH.indexOf(currentChar) - key, ALPHABETH.length())));
        }

        return decryptText.toString();

    }

    public List<String> crackCaesarCypher(String cypherText) {

        List<String> allResults = new ArrayList<>();

        for (int index = 0; index < ALPHABETH.length(); index++) {
            StringBuilder decryptText = new StringBuilder();
            for (int charPosition = 0; charPosition < cypherText.length(); charPosition++ ) {
                char currentChar = cypherText.charAt(charPosition);
                decryptText.append(ALPHABETH.charAt(Math.floorMod(ALPHABETH.indexOf(currentChar) - index, ALPHABETH.length())));
            }
            allResults.add(decryptText.toString());
        }
        return allResults;
    }
}

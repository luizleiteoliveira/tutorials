package org.luizleiteoliveira.examples;


public class CeasarCypherExamples {

    private static final String ALPHABETH = " ABCDEFGHIJKLMNOPQRSTUWXYZ";

    public String encrypt(String plainText, int key){
        StringBuilder encryptText = new StringBuilder();
        for (int charPosition = 0; charPosition < plainText.length(); charPosition++ ) {
            char currentChar = plainText.charAt(charPosition);
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
}

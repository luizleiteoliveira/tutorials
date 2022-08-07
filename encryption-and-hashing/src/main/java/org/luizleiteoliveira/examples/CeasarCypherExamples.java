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
}

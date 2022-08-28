package org.luizleiteoliveira.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class CeasarCypherExamplesTest {

    private final CeasarCypherExamples ceasarCypherExamples = new CeasarCypherExamples();

    @Test
    public void checkOneLetterEncrypt(){
        String plainText = "A";
        String encryptResult = ceasarCypherExamples.encrypt(plainText, 1);
        Assertions.assertEquals("B", encryptResult);
        plainText = "Z";
        encryptResult = ceasarCypherExamples.encrypt(plainText, 1);
        Assertions.assertEquals(" ", encryptResult);
    }

    @Test
    public void testWordEncrypt() {
        String plainText = "AMOR";
        String encryptResult = ceasarCypherExamples.encrypt(plainText, 1);
        Assertions.assertEquals("BNPS", encryptResult);
    }

    @Test
    public void checkOneLetterDecrypt(){
        String cypherText = "B";
        String decryptResult = ceasarCypherExamples.decrypt(cypherText, 1);
        Assertions.assertEquals("A", decryptResult);
        cypherText = " ";
        decryptResult = ceasarCypherExamples.decrypt(cypherText, 1);
        Assertions.assertEquals("Z", decryptResult);
    }

    @Test
    public void testWordDecrypt() {
        String plainText = "BNPS";
        String decryptResult = ceasarCypherExamples.decrypt(plainText, 1);
        Assertions.assertEquals("AMOR", decryptResult);
    }

    @Test
    public void crackTest() {

        String message = "This is a secret message";
        int random = new Random().ints(0, 90).findAny().getAsInt();
        String encryptMessage = ceasarCypherExamples.encrypt(message, random);
        List<String> allResults = ceasarCypherExamples.crackCaesarCypher(encryptMessage);
        Assertions.assertTrue(allResults.contains(message.toUpperCase()));


    }

}
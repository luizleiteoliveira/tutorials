package org.luizleiteoliveira.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        String encryptResult = ceasarCypherExamples.decrypt(cypherText, 1);
        Assertions.assertEquals("A", encryptResult);
        cypherText = " ";
        encryptResult = ceasarCypherExamples.decrypt(cypherText, 1);
        Assertions.assertEquals("Z", encryptResult);
    }

    @Test
    public void testWordDecrypt() {
        String plainText = "BNPS";
        String encryptResult = ceasarCypherExamples.decrypt(plainText, 1);
        Assertions.assertEquals("AMOR", encryptResult);
    }

}
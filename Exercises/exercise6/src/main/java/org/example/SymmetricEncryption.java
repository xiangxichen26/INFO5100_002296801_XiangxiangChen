package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/**
 * Demonstrates symmetric encryption and decryption using the AES algorithm in GCM mode.
 * This class provides an example of encrypting and decrypting a string using a generated AES key and a static IV.
 */
public class SymmetricEncryption {
    /**
     * The main method to execute the symmetric encryption and decryption process.
     * It generates an AES key, encrypts a plaintext message, and then decrypts it back to the original message.
     *
     * @param args The command line arguments (not used in this application).
     * @throws Exception If there is any error during the key generation, encryption, or decryption processes.
     */
    public static void main(String[] args) throws Exception {
        // Key generator for AES using 256-bit key size
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Use 256-bit AES
        SecretKey key = keyGenerator.generateKey();

        // Cipher object for AES using GCM mode and no padding
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12]; // Ensure that you use a secure random IV in production
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv); // 128 bit auth tag length

        // Plaintext message to be encrypted
        String input = "Hello Bob, this is Alice.";
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

        // Plaintext message to be encrypted
        byte[] cipherText = cipher.doFinal(input.getBytes());
        System.out.println("Encrypted text: " + java.util.Base64.getEncoder().encodeToString(cipherText));

        // Decrypting the ciphertext back to plaintext
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        byte[] plainText = cipher.doFinal(cipherText);
        System.out.println("Decrypted text: " + new String(plainText));
    }
}

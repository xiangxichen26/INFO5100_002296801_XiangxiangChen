import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

/**
 * This class demonstrates the process of asymmetric encryption and decryption using RSA algorithm.
 * It generates a key pair, encrypts a plaintext message with the public key, and then decrypts it using the private key.
 */
public class AsymmetricEncryption {
    /**
     * The main method that handles the encryption and decryption process.
     *
     * @param args The command line arguments (not used in this application).
     * @throws Exception If there is any error during the encryption/decryption process, including issues with key generation or cipher operations.
     */
    public static void main(String[] args) throws Exception {
        // Initialize a KeyPairGenerator for RSA algorithm with a key size of 2048 bits
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Cipher object to handle RSA encryption and decryption
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Encrypt a plaintext message using the public key
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encrypted = cipher.doFinal("Hello Alice, this is Bob.".getBytes());
        System.out.println("RSA Encrypted: " + java.util.Base64.getEncoder().encodeToString(encrypted));

        // Decrypt the ciphertext using the private key to retrieve the original message
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("RSA Decrypted: " + new String(decrypted));
    }
}

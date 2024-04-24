import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 * Demonstrates the creation and verification of a digital signature using RSA and SHA-256.
 * The class uses Java's security API to generate a key pair, sign a message, and verify the signature.
 */
public class DigitalSignature {
    /**
     * The main method to execute the signature creation and verification.
     *
     * @param args The command line arguments (not used in this application).
     * @throws Exception If any security issues occur during the signature generation or verification.
     */
    public static void main(String[] args) throws Exception {
        // Initialize a KeyPairGenerator for RSA algorithm with a key size of 2048 bits
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair pair = keyPairGenerator.generateKeyPair();

        // Signature object to handle signing and verification using SHA256 with RSA
        Signature signature = Signature.getInstance("SHA256withRSA");

        // Signing process: initialize the signature with the private key and update with the message
        signature.initSign(pair.getPrivate());
        signature.update("Message to sign".getBytes());
        byte[] digitalSignature = signature.sign();
        System.out.println("Signature: " + java.util.Base64.getEncoder().encodeToString(digitalSignature));

        // Verification process: initialize the signature with the public key, update with the message, and verify the signature
        signature.initVerify(pair.getPublic());
        signature.update("Message to sign".getBytes());
        boolean isCorrect = signature.verify(digitalSignature);
        System.out.println("Signature verified: " + isCorrect);
    }
}


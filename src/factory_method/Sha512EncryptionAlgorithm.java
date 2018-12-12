package factory_method;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yugo
 */
public class Sha512EncryptionAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encrypt(String plaintext) {
        MessageDigest digest;
        String hexString = "";
        try {
          
            digest = MessageDigest.getInstance("SHA-256");
            byte[] textDigest = digest.digest();
            hexString = new String(textDigest, "UTF-8"); 
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha256CEncryptionAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Sha256CEncryptionAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hexString; 
    }
}

package factory_method;

/**
 * @author Yugo
 */
public class EncryptionAlgorithmFactory {
    
    public enum EncryptionAlgorithms {    
        SHA256, SHA512;
    }
    
    public static EncryptionAlgorithm getEncryptionAlgorithm(EncryptionAlgorithms algorithm) { 
        EncryptionAlgorithm choice = null; 
        switch (algorithm) {
            case SHA256: 
                choice = new Sha256CEncryptionAlgorithm(); 
                break;
            case SHA512: 
                choice = new Sha512EncryptionAlgorithm();
                break; 
            default: 
                break;
        }
        return choice; 
    }
}

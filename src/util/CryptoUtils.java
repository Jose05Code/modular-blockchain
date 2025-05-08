package util;

import java.security.*;

public class CryptoUtils {

    // Private constructor to prevent instantiation
    private CryptoUtils() {
        throw new UnsupportedOperationException("util.LoggerUtils is a utility class and cannot be instantiated.");
    }

    public static byte[] signData(String data, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes());
            return signature.sign();
        }
        catch (Exception e) {
            return null;
        }

    }

    public static boolean verifySign(String data, byte[] signatureBytes, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            return signature.verify(signatureBytes);
        }
        catch (Exception e) {
            return false;
        }
    }
}

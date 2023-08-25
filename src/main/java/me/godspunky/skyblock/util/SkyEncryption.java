package me.godspunky.skyblock.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class SkyEncryption {
    private String myEncryptionKey = "ThisIsSpartaThisIsSparta";

    private String myEncryptionScheme = "DESede";

    byte[] arrayBytes = this.myEncryptionKey.getBytes("UTF8");

    private KeySpec ks = new DESedeKeySpec(this.arrayBytes);

    private SecretKeyFactory skf = SecretKeyFactory.getInstance(this.myEncryptionScheme);

    private Cipher cipher = Cipher.getInstance(this.myEncryptionScheme);

    SecretKey key = this.skf.generateSecret(this.ks);

    private static final String UNICODE_FORMAT = "UTF8";

    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";

    public SkyEncryption() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
    }

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            this.cipher.init(1, this.key);
            byte[] plainText = unencryptedString.getBytes("UTF8");
            byte[] encryptedText = this.cipher.doFinal(plainText);
            encryptedString = new String(Base64.getEncoder().encode(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            this.cipher.init(2, this.key);
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
            byte[] plainText = this.cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysi\\util\SkyEncryption.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
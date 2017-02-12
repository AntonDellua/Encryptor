package Encryption_Methods.Classic_Cipher;

/**
 * Created by Nutrient on 30/01/2017.
 */
public interface Encryptor {

    void setUnencryptedString(String unencryptedString);
    void setKey(int key);
    void setKey(String key);
    void setKey(int[][] key);
    String Encrypt();

}

package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public interface Encryptor {

    public void setAlphabet(String alphabet);
    public void setKey(int key);
    public String Encrypt();
}

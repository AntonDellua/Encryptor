package Encryption_Methods.Block_Cipher_Base;

/**
 * Created by Nutrient on 02/02/2017.
 */
public interface Block_Cipher {

    void setKey(byte[] key);
    void setFormula(String F);
    byte[][] generateSubKey();
    void swapBlock(Block A, Block B);
    byte[] encrypt();

}

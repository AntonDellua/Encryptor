package Encryption_Methods.Block_Cipher_Base;

/**
 * Created by Nutrient on 02/02/2017.
 */
public class Red_Feistel implements Block_Cipher{

    byte[] key;

    public void setKey(byte[] key) {
        this.key = key;
    }

    public void setFormula(String F) {

    }

    public byte[][] generateSubKey() {
        return new byte[0][];
    }

    public void swapBlock(Block A, Block B) {

    }

    public byte[] encrypt() {
        return new byte[0];
    }
}

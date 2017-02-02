package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class Julius_Caesar  extends Alphabet implements Encryptor{

    private int size;
    private String alphabet;
    private int key;


    public void setUnencryptedString(String unencryptedString){
        this.alphabet = unencryptedString.replaceAll("\\s","").toLowerCase();
        setCurrentAlphabet(0);
        size = getAlphabetLength();

    }

    public void setKey(int key) {this.key = key;}

    public void setKey(String key) {

    }

    public void setKey(int[][] key) {

    }


    public String Encrypt(){
        String encrypted_alphabet = "";

        for (int i = 0; i < alphabet.length(); i++){
            encrypted_alphabet += getAlphabetChar((alphabet.charAt(i)-97 + key) % size);
        }
        System.out.println(encrypted_alphabet.toUpperCase());
        return encrypted_alphabet.toUpperCase();
    }
}

package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class Julius_Caesar  implements Encryptor{

    int size;
    String alphabet;
    int key;
    char[] english_alphabet = {'a','b','c','d','e','f',
                                'g','h','i','j','k','l',
                                'm','n','o','p','q','r',
                                's','t','u','v','w','x',
                                'y','z'
    };

    public void setAlphabet(String alphabet){
        this.alphabet = alphabet.replaceAll("\\s","").toLowerCase();
        size = english_alphabet.length;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String Encrypt(){
        String encrypted_alphabet = "";

        for (int i = 0; i < alphabet.length(); i++){
            encrypted_alphabet += english_alphabet[((int)alphabet.charAt(i)-97 + key) % size];
        }
        System.out.println(encrypted_alphabet);
        return encrypted_alphabet;
    }
}

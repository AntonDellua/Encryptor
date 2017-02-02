package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class Hill_Cypher extends Alphabet implements Encryptor {
    private int size;
    private String UnencryptedString;
    private int[][] key;


    public void setUnencryptedString(String unencryptedString) {
        this.UnencryptedString = unencryptedString;
        size = unencryptedString.length();
        setCurrentAlphabet(0);
    }

    public void setKey(int key) {

    }

    public void setKey(String key) {

    }

    public void setKey(int[][] key) {
        this.key = key;
    }

    private int multiply3x1(int[] row, int[] column){
        return ((row[0] * column[0]) + (row[1] * column[1]) + (row[2] * column[2])) % getAlphabetLength();
    }

    private int multiply2x1(int[] row, int[] column){
        return ((row[0] * column[0]) + (row[1] * column[1])) % getAlphabetLength();
    }

    public String Encrypt() {
        int alphabetIndex = 0;
        String encrypted_alphabet = "";

        while (alphabetIndex < UnencryptedString.length()){
            int[] temp;
            switch (key[0].length){
                case 2:{
                    while (UnencryptedString.length() % 2 != 0){
                        UnencryptedString += 'x';
                    }

                    temp = new int[]{(UnencryptedString.charAt(alphabetIndex++) - 97),
                                     (UnencryptedString.charAt(alphabetIndex++) - 97)
                    };
                    encrypted_alphabet +=  getAlphabetChar(multiply2x1(key[0],temp));
                    encrypted_alphabet +=  getAlphabetChar(multiply2x1(key[1],temp));
                    break;

                }
                case 3:{
                    while (UnencryptedString.length() % 3 != 0){
                        UnencryptedString += 'x';
                    }
                    temp = new int[]{(UnencryptedString.charAt(alphabetIndex++) - 97),
                                     (UnencryptedString.charAt(alphabetIndex++) - 97),
                                     (UnencryptedString.charAt(alphabetIndex++) - 97)
                    };
                    encrypted_alphabet +=  getAlphabetChar(multiply3x1(key[0],temp));
                    encrypted_alphabet +=  getAlphabetChar(multiply3x1(key[1],temp));
                    encrypted_alphabet +=  getAlphabetChar(multiply3x1(key[2],temp));
                    break;
                }
            }
        }
        System.out.println(encrypted_alphabet.toUpperCase());
        return encrypted_alphabet.toUpperCase();
    }
}

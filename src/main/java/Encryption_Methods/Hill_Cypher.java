package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class Hill_Cypher implements Encryptor {
    private int size;
    private String alphabet;
    private int[][] key;

    private char[] english_alphabet = { 'a','b','c','d','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t',
            'u','v','w','x','y',
            'z'
    };

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
        size = alphabet.length();
    }

    public void setKey(int key) {

    }

    public void setKey(String key) {

    }

    public void setKey(int[][] key) {
        this.key = key;
    }

    private int multiply3x1(int[] row, int[] column){
        return ((row[0] * column[0]) + (row[1] * column[1]) + (row[2] * column[2])) % english_alphabet.length;
    }

    private int multiply2x1(int[] row, int[] column){
        return ((row[0] * column[0]) + (row[1] * column[1])) % english_alphabet.length;
    }

    public String Encrypt() {
        int alphabetIndex = 0;
        String encrypted_alphabet = "";

        while (alphabetIndex < alphabet.length()){
            int[] temp;
            switch (key[0].length){
                case 2:{
                    while (alphabet.length() % 2 != 0){
                        alphabet+= 'x';
                    }

                    temp = new int[]{(alphabet.charAt(alphabetIndex++) - 97),
                                     (alphabet.charAt(alphabetIndex++) - 97)
                    };
                    System.out.println(multiply2x1(key[0],temp) + "/"+ multiply2x1(key[1],temp));
                    encrypted_alphabet +=  english_alphabet[multiply2x1(key[0],temp)];
                    encrypted_alphabet +=  english_alphabet[multiply2x1(key[1],temp)];
                    break;

                }
                case 3:{
                    while (alphabet.length() % 3 != 0){
                        alphabet+= 'x';
                    }
                    temp = new int[]{(alphabet.charAt(alphabetIndex++) - 97),
                                     (alphabet.charAt(alphabetIndex++) - 97),
                                     (alphabet.charAt(alphabetIndex++) - 97)
                    };
                    encrypted_alphabet +=  english_alphabet[multiply2x1(key[0],temp)];
                    encrypted_alphabet +=  english_alphabet[multiply2x1(key[1],temp)];
                    encrypted_alphabet +=  english_alphabet[multiply2x1(key[2],temp)];
                    break;
                }
            }

        }
        System.out.println(encrypted_alphabet);
        return encrypted_alphabet;
    }
}

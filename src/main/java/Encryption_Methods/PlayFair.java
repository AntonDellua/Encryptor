package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class PlayFair implements Encryptor{

    private String alphabet;
    private String key;


    private int firstRow = 0;
    private int firstColumn = 0;
    private int secondRow = 0;
    private int secondColumn = 0;

    private char[][] matrix;

    private char[] english_alphabet = { 'a','b','c','d','e',
                                'f','g','h','i','j',
                                'k','l','m','n','o',
                                'p','q','r','s','t',
                                'u','v','w','x','y',
                                'z'
    };

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet.replaceAll("\\s","").toLowerCase();
    }

    public void setKey(int key) {

    }

    private void fillMatrix(char[][] matrix){
        int getKeyChar = 0;
        for(int i = 0; i < 5 ; i++){
            for (int j = 0; j < 5; j++){
                if (getKeyChar < key.length() && english_alphabet[(int)key.charAt(getKeyChar) - 97] != '0'){

                    if(key.charAt(getKeyChar) == 'j'){
                        if(english_alphabet['i'-97] != '0') {
                            english_alphabet['j' - 97] = '0';
                            english_alphabet['i' - 97] = '0';
                            matrix[i][j] = 'i';
                            getKeyChar++;
                        }
                    }
                    else{

                        matrix[i][j] = key.charAt(getKeyChar);
                        english_alphabet['j' - 97] = (key.charAt(getKeyChar) == 'i') ? 'j':'0';
                        english_alphabet[(int)key.charAt(getKeyChar++) - 97] = '0';

                    }
                }
                else if(getKeyChar >= key.length()){
                    int getNextCharIndex = 0;
                    char index = english_alphabet[0];
                    while (index  == '0'){
                        getNextCharIndex++;
                        index = english_alphabet[getNextCharIndex];

                    }

                    matrix[i][j] = english_alphabet[getNextCharIndex];
                    english_alphabet[getNextCharIndex] = '0';
                }
                else {
                    getKeyChar++;
                    j--;
                }
            }

        }
    }

    public void setKey(String key) {
        this.key = key;
        matrix = new char[5][5];
        fillMatrix(matrix);
        /*System.out.println(matrix[0]);
        System.out.println(matrix[1]);
        System.out.println(matrix[2]);
        System.out.println(matrix[3]);
        System.out.println(matrix[4]);*/

    }

    public void setKey(int[][] key) {

    }

    public String Encrypt() {
        String encrypted_alphabet = "";
        char firstLetter;
        char secondLetter;
        int index = 0;
        while(index < alphabet.length()){
            firstLetter = alphabet.charAt(index++);
            secondLetter = (index+1 < alphabet.length()) ? alphabet.charAt(index++) : 'x';
            if(firstLetter == secondLetter){
                secondLetter = 'x';
                index--;
            }
            getRow_and_Column(firstLetter,secondLetter);
            if(firstRow == secondRow){
                encrypted_alphabet += (!(firstColumn+1 > 4)) ? matrix[firstRow][firstColumn+1] :  matrix[firstRow][0];
                encrypted_alphabet += (!(secondColumn+1 > 4)) ?  matrix[secondRow][secondColumn+1] :  matrix[secondRow][0];
            }
            else if(firstColumn == secondColumn){
                encrypted_alphabet += (!(firstRow+1 > 4)) ? matrix[firstRow+1][firstColumn]: matrix[0][firstColumn];
                encrypted_alphabet += (!(secondRow+1 > 4)) ? matrix[secondRow+1][secondColumn]: matrix[0][secondColumn];
            }
            else {
                encrypted_alphabet += matrix[firstRow][secondColumn];
                encrypted_alphabet += matrix[secondRow][firstColumn];
            }

        }
        System.out.println(encrypted_alphabet.toUpperCase());
        return encrypted_alphabet;
    }
    private void getRow_and_Column(char firstLetter, char secondLetter){
        for(int i = 0; i < 5 ; i++){
            for (int j = 0; j < 5 ; j++){
                if(matrix[i][j] == firstLetter){
                    firstRow = i;
                    firstColumn = j;
                }
                if(matrix[i][j] == secondLetter){
                    secondRow = i;
                    secondColumn = j;
                }
            }
        }
    }
}

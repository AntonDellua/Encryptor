package Encryption_Methods;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class PlayFair extends Alphabet implements Encryptor{

    private String UnencryptedString;
    private String key;


    private int firstRow = 0;
    private int firstColumn = 0;
    private int secondRow = 0;
    private int secondColumn = 0;

    private char[][] matrix;


    public void setUnencryptedString(String unencryptedString) {
        this.UnencryptedString = unencryptedString.replaceAll("\\s","").toLowerCase();
        setCurrentAlphabet(0);
    }

    public void setKey(int key) {

    }

    private void fillMatrix(char[][] matrix){
        int getKeyChar = 0;
        for(int i = 0; i < 5 ; i++){
            for (int j = 0; j < 5; j++){
                if (getKeyChar < key.length() && getAlphabetChar(key.charAt(getKeyChar)) != '0'){

                    if(key.charAt(getKeyChar) == 'j'){
                        if(getAlphabetChar('i') != '0') {
                            setAlphabetChar('j');
                            setAlphabetChar('i');
                            matrix[i][j] = 'i';
                            getKeyChar++;
                        }
                    }
                    else{

                        matrix[i][j] = key.charAt(getKeyChar);
                        setAlphabetChar((key.charAt(getKeyChar) == 'i') ? 'j': key.charAt(getKeyChar));
                        setAlphabetChar(key.charAt(getKeyChar++));

                    }
                }
                else if(getKeyChar >= key.length()){
                    char getNextCharIndex = 'a';
                    char index = getAlphabetChar(getNextCharIndex);
                    while (index  == '0'){
                        getNextCharIndex++;
                        index =  getAlphabetChar(getNextCharIndex);

                    }

                    matrix[i][j] = getAlphabetChar(getNextCharIndex);
                    setAlphabetChar(getNextCharIndex);
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
        System.out.println(matrix[0]);
        System.out.println(matrix[1]);
        System.out.println(matrix[2]);
        System.out.println(matrix[3]);
        System.out.println(matrix[4]);

    }

    public void setKey(int[][] key) {

    }

    public String Encrypt() {
        String encrypted_alphabet = "";
        char firstLetter;
        char secondLetter;
        int index = 0;
        while(index < UnencryptedString.length()){
            firstLetter = UnencryptedString.charAt(index++);
            secondLetter = (index+1 < UnencryptedString.length()) ? UnencryptedString.charAt(index++) : 'x';
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
        return encrypted_alphabet.toUpperCase();
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

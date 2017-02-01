import Encryption_Methods.Hill_Cypher;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class launcher {
    public static void main(String[] args){

        int[][] key = new int[2][2];
        key[0] = new int[]{7, 3 };
        key[1] = new int[]{4, 5};

        Hill_Cypher x = new Hill_Cypher();
        x.setAlphabet("universidad");
        x.setKey(key);
        x.Encrypt();
    }
}

import Encryption_Methods.Julius_Caesar;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class launcher {
    public static void main(String[] args){

        int[][] key = new int[2][2];
        key[0] = new int[]{7, 3 };
        key[1] = new int[]{4, 5};

        Julius_Caesar x = new Julius_Caesar();
        x.setUnencryptedString("ve a la tienda");
        x.setKey(7);
        x.Encrypt();
    }

}

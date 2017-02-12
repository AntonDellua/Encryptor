import Encryption_Methods.Classic_Cipher.Hill_Cipher;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class launcher {
    public static void main(String[] args){

        int[][] key = new int[2][2];
        key[0] = new int[]{9, 4 };
        key[1] = new int[]{5, 7};

        for(int i = 0;i<1000;i++){
            double x = ((i*26)+1);
            System.out.println(x/441);
        }

        /*Julius_Caesar x =new Julius_Caesar();
        x.setUnencryptedString("ve a la tienda");
        x.setKey(7);
        //x.Encrypt();*/

       /* PlayFair y = new PlayFair();
        //y.setUnencryptedString(x.Encrypt());
        //y.setUnencryptedString("ferrocarril");
        y.setKey("royalnewzealandnavy");
        y.Decrypt("KXJEYUREBEZWEHEWRYTUHEYFS" +
                "KREHEGOYFIWTTTUOLKSYCAJPO" +
                "BOTEIZONTXBYBNTGONEYCUZWR" +
                "GDSONSXBOUYWRHEBAAHYUSEDQ","royal new zealand navy");*/

        Hill_Cipher z = new Hill_Cipher();
        z.setUnencryptedString("meet me at the usual place at ten rather than eight oclock");
        z.setKey(key);
        z.Encrypt();
    }

}

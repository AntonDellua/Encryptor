import Encryption_Methods.PlayFair;

/**
 * Created by Nutrient on 30/01/2017.
 */
public class launcher {
    public static void main(String[] args){
        PlayFair x = new PlayFair();
        x.setAlphabet("Ferrocarril");
        x.setKey("muurcielago");
        x.Encrypt();
    }
}

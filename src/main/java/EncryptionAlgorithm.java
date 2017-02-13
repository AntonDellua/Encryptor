import Encryption_Methods.Classic_Cipher.Hill_Cipher;
import Encryption_Methods.Classic_Cipher.Julius_Caesar;
import Encryption_Methods.Classic_Cipher.PlayFair;

/*The algorithm shall use Julius Caesar, PlayFair and HillCipher in that order.
 *The Key Field shall be used to both Encrypt and Decrypt the messages.
 *The SubKeys generated shall be used to both Encrypt and Decrypt and must be the always the same for the given Global Field Key.
 *To Decrypt just reverse the order of the encryption methods.
 */

public class EncryptionAlgorithm {
	private String PlainText;
	private String Key;
	private String EncryptedMessage;
	
	private int JC_subKey;
	//private char[][] PF_subKey;
	private int[][] HC_subKey;

	private Julius_Caesar a = new Julius_Caesar();
	private PlayFair b = new PlayFair();
	private Hill_Cipher c = new Hill_Cipher();

	public EncryptionAlgorithm(){
		setPlainText("HolaMundo");
		setKey("Key");
		//TODO: Add here code that fills the rest of the fields. Everytime a new object of this class is created it must encrypt and maybe decrypt the received String.
	}

	public EncryptionAlgorithm(String plainText, String key){
		setPlainText(plainText);
		setKey(key);
		//TODO: Add here code that fills the rest of the fields. Everytime a new object of this class is created it must encrypt and maybe decrypt the received String.
	}

	public void setSubKeys(String key){
		//TODO: Set the three subKeys using the parameter that is supposed to be the global key in the class.
		//Julius Caesar
		int sum = 0;
		for (int i = 0; i <= key.length(); i++){
			sum += Integer.parseInt(key[i]) - 97;
		}
		this.JC_subKey = sum % 26;
		//PlayFair
		this.b.setKey(key);
		//TODO: Hill_Cipher subkey
	}

	public String Encryption(){
		//TODO; This method might be called from the constructors. The purposse of this method is to call the encryption methods from other classes.
		
	}

	public void setPlainText(String s){
		this.PlainText = s;
	}
	public void setKey(String s){
		this.Key = s;
	}
	public String getPlainText(){
		return this.PlainText;
	}
	public String getKey(){
		return this.Key;
	}
}

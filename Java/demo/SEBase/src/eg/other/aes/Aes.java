package eg.other.aes;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
	public static void main(String[] args) {
		Object localObject;
		try {
			localObject = KeyGenerator.getInstance("AES");
			((KeyGenerator)localObject).init(128, SecureRandom.getInstance("SHA1PRNG"));
		      ((KeyGenerator)localObject).generateKey();
		      localObject = new SecretKeySpec(new byte[] { 51, -110, 57, -77, -95, 102, -10, 17, 30, 97, -79, 109, -34, -27, 110, -49 }, "AES");
		      Cipher localCipher = Cipher.getInstance("AES");
		      localCipher.init(2, (Key)localObject);
		      byte[] paramArrayOfByte= {-32,15,33,-27,-45,-13,92,-21,100,-76,-35,82,71,34,-51,48,86,-43,-18,89,-77,70,27,48,75,67,70,85,10,-58,82,20,-6,14,-46,67,54,34,72,27,-75,90,10,101,-77,-64,-83,124,-103,-106,-50,-47,-115,64,98,-73,-35,-13,-82,25,-122,-94,-59,81,-63,-97,48,17,97,127,-119,-74,99,100,-82,-57,64,12,15,-97,-96,41,28,44,103,45,-54,-29,-76,75,26,-109,70,123,-49,-81,-105,-70,63,-33,55,72,60,0,89,-10,115,42,58,-111,-124,-88,-38,103,71,-18,95,121,121,-64,-41,-19,-74,46,0,96,37,97,68,77,-60,16,-6,-44,104,103,1,-74,86,-34,-51,-117,-112,-6,84,-13,19,-62,33,3,14,0,-51,66,76,-119,108,13,72,11,94,-34,-115,-60,60,116,-93,-50,-86,62,-40,-123,57,51,-77,127,57,-35,27,-50,-57,-84,73,-85,113,110,34,1,-47,-10,93,22,25,-124,-13,-64,-22,-51,-89,59,87,19,77,86,90,-124,-121,-101,36,96,91,53,-41,104,-46,-80,59,115,77,39,-23,-22,-64,-69,-93,-82,-57,-96,-120,81,-125,61,32,-47,39,-94,63,26,-70,92,38,90,1,-78,-34,-9,-107,-110,124,32,122,123,-118,31,105,-64,-112,-61,-80,-2,20,-50,-122,78,99,-34,127,-86,53,-50,114,31};
		      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
		      String str = new String(paramArrayOfByte);
		      System.out.print(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

package STATE.REALIZATION.SM2;


import java.io.IOException;  
import java.math.BigInteger;  
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;  
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;  
import org.bouncycastle.crypto.params.ECPublicKeyParameters;  
import org.bouncycastle.math.ec.ECPoint;

import UTIL.Util;  
  
public class SM2Utils   
{  
    public static void main(String[] args) throws Exception   
    {  
    	SM2 sm2 = SM2.Instance();  
        //生成密钥对  
    	String[] keyPair=sm2.generateKeyPair();  
          
        String plainText = "43242343242";  
        byte[] sourceData = plainText.getBytes();  
          
        //下面的秘钥可以使用generateKeyPair()生成的秘钥内容  
        // 国密规范正式私钥  
        String prik = keyPair[1];
        // 国密规范正式公钥  
        String pubk = keyPair[0];
        System.out.println("私钥: "); 
        System.out.println(prik);  
        System.out.println("公钥 ");
        System.out.println(pubk); 
        System.out.println("加密: ");  
        String cipherText = sm2.encrypt(Util.hexToByte(pubk), sourceData);  
        System.out.println(cipherText);  
        System.out.println("解密: ");  
        plainText = new String(sm2.decrypt(Util.hexToByte(prik), Util.hexToByte(cipherText)));  
        System.out.println(plainText);  
          
    }  
}  
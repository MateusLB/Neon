package com.neon.arthurabreu.neon.Utils;

import android.content.Context;
import android.provider.Settings;
import android.util.Base64;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by af2g on 15/12/2017.
 */

public class Cripto {

    private static final String CRIPT 						= "ASdalkd34mofmoef0fjnflsnfd943nt" ;

    public static String Encrypt(String raw) throws Exception {
        Cipher c = getCipher(Cipher.ENCRYPT_MODE);

        byte[] encryptedVal = c.doFinal(raw.getBytes("UTF-8"));
        return Base64.encodeToString(encryptedVal, Base64.DEFAULT);
    }

    public static Cipher getCipher(int mode) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //a random Init. Vector. just for testing
        //byte[] iv = "e675f725e675f725".getBytes("UTF-8");

        byte[] iv = {12, 34, 56, 78, 90, 102, 114, 126, 12, 34, 56, 78, 90, 102, 114, 126};

        c.init(mode, generateKey(), new IvParameterSpec(iv));
        return c;
    }

    public static String Decrypt(String encrypted) throws Exception {

        byte[] decodedValue =  Base64.decode(encrypted, Base64.DEFAULT);

        Cipher c = getCipher(Cipher.DECRYPT_MODE);
        byte[] decValue = c.doFinal(decodedValue);

        return new String(decValue);
    }

    private static Key generateKey() throws Exception {

        byte[] encoded = "tv93h58sk1zh5x8v".getBytes("UTF-8");
        SecretKeySpec specs = new SecretKeySpec(encoded, "AES");

        System.out.println(specs.getEncoded());
        return specs;
    }

    public static String criptString(String string){
        Cripto c = new Cripto();
        String paramsCrip = null;
        try {
            paramsCrip = c.Encrypt(string);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return paramsCrip;
    }

    public static String decriptString(String string){
        Cripto c = new Cripto();
        String paramsCrip = null;
        try {
            paramsCrip = c.Decrypt(string);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return paramsCrip;
    }

    public static SecretKey newGenerateKey() throws NoSuchAlgorithmException {
        // Generate a 256-bit key
        final int outputKeyLength = 256;

        SecureRandom secureRandom = new SecureRandom();
        // Do *not* seed secureRandom! Automatically seeded from system entropy.
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(outputKeyLength, secureRandom);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public static String encryptNew(Context context, String value ) {

        try {
            final byte[] bytes = value!=null ? value.getBytes("utf-8") : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(CRIPT.toCharArray()));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(context.getContentResolver(), Settings.System.ANDROID_ID).getBytes("utf-8"), 20));
            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP),"utf-8");

        } catch( Exception e ) {
            throw new RuntimeException(e);
        }

    }

    public static String decryptNew(Context context,String value){
        try {
            final byte[] bytes = value!=null ? Base64.decode(value,Base64.DEFAULT) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(CRIPT.toCharArray()));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(context.getContentResolver(),Settings.System.ANDROID_ID).getBytes("utf-8"), 20));
            return new String(pbeCipher.doFinal(bytes),"utf-8");

        } catch( Exception e) {
            throw new RuntimeException(e);
        }
    }

}
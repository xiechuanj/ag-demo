//package com.xiecj.cloud.zuul.jwt;
//
//import org.junit.Test;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//
//public class JwtTest {
//
//    @Test
//    public void generateKey() throws IOException, NoSuchAlgorithmException {
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        SecureRandom secureRandom = new SecureRandom("pass".getBytes());
//        keyPairGenerator.initialize(1024, secureRandom);
//        KeyPair keyPair = keyPairGenerator.genKeyPair();
//        String publicKeyFilename = "E:\\workspaces\\ag-demo\\cg-zuul\\src\\test\\resources\\pub.key";
//        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
//        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
//        fos.write(publicKeyBytes);
//        fos.close();
//        String privatekeyFilename = "E:\\workspaces\\ag-demo\\cg-zuul\\src\\test\\resources\\pri.key";
//        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
//        fos = new FileOutputStream(privatekeyFilename);
//        fos.write(privateKeyBytes);
//        fos.close();
//    }
//}

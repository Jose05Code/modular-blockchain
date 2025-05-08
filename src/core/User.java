package core;//Keys
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;

import java.security.NoSuchAlgorithmException;

public class User {
    String name;
    int id;

    //Keys
    PrivateKey privateKey;
    PublicKey publicKey;

    //For Assign news ids
    private static int idCounter = 1;

    public User(String name){
        this.name = name;
        this.id = idCounter++;
        generateKeyPair();
    }

    private void generateKeyPair(){
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(256);
            KeyPair pair = keyGen.generateKeyPair();
            this.privateKey = pair.getPrivate();
            this.publicKey = pair.getPublic();
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    //Getters
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public PrivateKey getPrivateKey(){
        return privateKey;
    }

    public PublicKey getPublicKey(){
        return publicKey;
    }


}

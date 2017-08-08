package net.kuryshev.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    public static String hash(String input) {
        String result = input;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes());
            result = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (NoSuchAlgorithmException e) { }
        return result;
    }
}

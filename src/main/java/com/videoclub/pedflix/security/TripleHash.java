package com.videoclub.pedflix.security;

import java.security.MessageDigest;

public class TripleHash {

    public static String hash(String input) {
        try {
            String hashed = input;

            for (int i = 0; i < 3; i++) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] bytes = md.digest(hashed.getBytes());
                StringBuilder sb = new StringBuilder();

                for (byte b : bytes) {
                    sb.append(String.format("%02x", b));
                }

                hashed = sb.toString();
            }

            return hashed;

        } catch (Exception e) {
            throw new RuntimeException("Error al hacer triple hash", e);
        }
    }
}

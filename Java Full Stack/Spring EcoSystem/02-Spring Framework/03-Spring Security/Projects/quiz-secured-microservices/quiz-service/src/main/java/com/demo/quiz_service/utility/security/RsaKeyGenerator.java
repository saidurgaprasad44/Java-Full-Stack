package com.demo.quiz_service.utility.security;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;


//This utility class generates an RSA key pair and saves them in PEM format to the "keys" directory. 
//PEM = header + Base64(DER key bytes) + footer
public class RsaKeyGenerator {

    public static void main(String[] args) throws Exception {

        // Generate RSA key pair
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");

        generator.initialize(2048);

        KeyPair keyPair = generator.generateKeyPair();

        // Convert keys to PEM format
        String privateKeyPem = toPem(
                "PRIVATE KEY",
                keyPair.getPrivate().getEncoded() //Binary representation (DER) of private key
        );

        String publicKeyPem = toPem(
                "PUBLIC KEY",
                keyPair.getPublic().getEncoded() //Binary representation (DER) of public key
        );

        // Create keys directory
        Path keysDirectory = Path.of("keys");
        Files.createDirectories(keysDirectory);

        // Save files
        Files.writeString(
                keysDirectory.resolve("jwt-private.pem"),
                privateKeyPem
        );

        Files.writeString(
                keysDirectory.resolve("jwt-public.pem"),
                publicKeyPem
        );

        System.out.println("RSA key pair generated successfully.");

        System.out.println(
                "Private key: " +
                keysDirectory.resolve("jwt-private.pem").toAbsolutePath()
        );

        System.out.println(
                "Public key: " +
                keysDirectory.resolve("jwt-public.pem").toAbsolutePath()
        );
    }

    private static String toPem(String type, byte[] keyBytes) {

        String base64 = Base64.getMimeEncoder(
                64,
                "\n".getBytes(StandardCharsets.US_ASCII)
        ).encodeToString(keyBytes);

        return "-----BEGIN " + type + "-----\n"
                + base64
                + "\n-----END " + type + "-----\n";
    }
}
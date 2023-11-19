package Seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptar {
    public static String encriptar(String contraseña) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] diggest = md.digest(contraseña.getBytes());
        contraseña = new String(diggest);
        return contraseña;
    }
}

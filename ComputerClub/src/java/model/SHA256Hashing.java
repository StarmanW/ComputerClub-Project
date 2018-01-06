package model;

import java.security.MessageDigest;

public class SHA256Hashing {

    public String getHashedText(String text) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
}

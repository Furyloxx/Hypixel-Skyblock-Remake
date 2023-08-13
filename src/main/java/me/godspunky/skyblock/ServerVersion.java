package me.godspunky.skyblock;

import me.godspunky.skyblock.util.SkyEncryption;

public class ServerVersion {
    private String z;

    private int a;

    private int b;

    private int c;

    private int d;

    private byte[] finalResult;

    public ServerVersion(String stage, int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.z = stage;
        try {
            this.finalResult = (new SkyEncryption()).encrypt(this.z + "-" + this.a + "." + this.b + "." + this.c + "." + this.d).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readableString() throws Exception {
        return (new SkyEncryption()).decrypt(new String(this.finalResult));
    }

    public byte[] getEncryptedByteArray() {
        return this.finalResult;
    }

    public byte[] getDecryptedByteArray() throws Exception {
        return (new SkyEncryption()).decrypt(new String(this.finalResult)).getBytes();
    }
}


/* Location:              C:\Users\Administrator\Downloads\legacy-2022-05-build143.jar!\vn\giakhanhvn\skysim\ServerVersion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
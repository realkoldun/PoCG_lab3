package example.colors;

public class XYZ {
    short cX;
    short cY;
    short cZ;
    public XYZ(){
        this.cX = this.cY = this.cZ = 0;
    }
    public XYZ(short cX, short cY, short cZ) {
        set_color(cX, cY, cZ);
    }
    public void set_color(short cX, short cY, short cZ) {
        if(cX >= 0 && cX <= 95) this.cX = cX;
        if(cY >= 0 && cY <= 100) this.cY = cY;
        if(cZ >= 0 && cZ <= 109)this.cZ = cZ;
    }
    public void to_RGB(RGB rgb) {
        float r = 3.240479F * cX / 100 - 1.53715F * cY / 100 - 0.498535F * cZ / 100;
        float g = -0.969256F * cX / 100 + 1.875992F * cY / 100 + 0.041556F * cZ / 100;
        float b = 0.055648F * cX / 100 - 0.204043F * cY / 100 + 1.057311F * cZ / 100;

        rgb.set_color((int) (r * 255), (int) (g * 255), (int) (b * 255));
    }
    static double Fxyz(double t) {
        return ((t > 0.008856)? Math.pow(t, (1.0 / 3.0)) : (7.787 * t + 0.1379));
    }
    public void to_Lab(Lab lab) {
        short L = (short) ((116.0 * Fxyz(cY / 100.0)) - 16);
        short A = (short) (500.0 * (Fxyz(cX / 95.0) - Fxyz(cY)));
        short B = (short) (200.0 * (Fxyz(cY / 100.0) - Fxyz( cZ / 109.0)));
        lab.set_color(L, A, B);
    }
    public Lab to_Lab() {
        short L = (short) ((116.0 * Fxyz(cY / 100.0)) - 16);
        short A = (short) (500.0 * (Fxyz(cX / 95.0) - Fxyz(cY)));
        short B = (short) (200.0 * (Fxyz(cY / 100.0) - Fxyz( cZ / 109.0)));
        return new Lab(L, A, B);
    }
    public short getX() {
        return cX;
    }

    public short getY() {
        return cY;
    }

    public short getZ() {
        return cZ;
    }

    @Override
    public String toString() {
        return "XYZ{" +
                "cX=" + cX +
                ", cY=" + cY +
                ", cZ=" + cZ +
                '}';
    }
}

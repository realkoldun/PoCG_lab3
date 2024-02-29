package example.colors;

import example.colors.RGB;

public class CMYK {
    private float cCyan;
    private float cMagenta;
    private float cYellow;
    private float cBlack;
    public CMYK() {
        this.cCyan = 100;
        this.cBlack = this.cMagenta = this.cYellow = 0;
    }

    public CMYK(float cCyan, float cMagenta, float cYellow, float cBlack) {
        set_color(cCyan, cMagenta, cYellow, cBlack);
    }

    public void set_color(float cCyan, float cMagenta, float cYellow, float cBlack) {
        if(cCyan >= 0 && cCyan <= 1) this.cCyan = cCyan;
        if(cMagenta >= 0 && cMagenta <= 1) this.cMagenta =  cMagenta;
        if(cYellow >= 0 && cYellow <= 1) this.cYellow =  cYellow;
        if(cBlack >= 0 && cBlack <= 1) this.cBlack = cBlack;
    }
    public float getCyan() {
        return cCyan;
    }
    public float getMagenta() {
        return cMagenta;
    }
    public float getYellow() {
        return cYellow;
    }
    public float getBlack() {
        return cBlack;
    }
    public void to_RGB(RGB rgb) {
        float r = (1 - cCyan) * (1 - cBlack);
        float g = (1 - cMagenta) * (1 - cBlack);
        float b = (1 - cYellow) * (1 - cBlack);
        rgb.set_color((int) (255 * r), (int) (255 * g), (int) (255 * b));
    }
    public RGB to_RGB() {
        float r = (1 - cCyan) * (1 - cBlack);
        float g = (1 - cMagenta) * (1 - cBlack);
        float b = (1 - cYellow) * (1 - cBlack);
        return new RGB((int) (255 * r), (int) (255 * g), (int) (255 * b));
    }
    @Override
    public String toString() {
        return "CMYK{" +
                "cCyan=" + cCyan +
                ", cMagenta=" + cMagenta +
                ", cYellow=" + cYellow +
                ", cBlack=" + cBlack +
                '}';
    }
}

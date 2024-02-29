package example.colors;

public class RGB {
    private short cRed;
    private short cGreen;
    private short cBlue;
    public RGB() {
        this.cRed = this.cBlue = this.cGreen = 0;
    }
    public RGB(int cRed, int cGreen, int cBlue) {
        set_color(cRed, cGreen, cBlue);
    }
    public void set_color(int cRed, int cGreen, int cBlue) {
        if(cRed >= 0 && cRed <= 255) this.cRed = (short) cRed;
        if(cGreen >= 0 && cGreen <= 255) this.cGreen = (short) cGreen;
        if(cBlue >= 0 && cBlue <= 255) this.cBlue = (short) cBlue;
    }
    public short getRed() {
        return cRed;
    }

    public short getGreen() {
        return cGreen;
    }

    public short getBlue() {
        return cBlue;
    }
    public void to_CMYK(CMYK cmyk) {
        int k = Math.min(cBlue, cGreen);
        k = Math.min(cRed, k);
        int k1 = 1 - k;
        int c = 1 - (cRed / k1);
        int m = 1 - (cGreen / k1);
        int y = 1 - (cBlue / k1);
        cmyk.set_color(c, m, y, k);
    }
    public CMYK to_CMYK() {
        int k = Math.min(cBlue, cGreen);
        k = Math.min(cRed, k);
        int k1 = 1 - k;
        int c = 1 - (cRed / k1);
        int m = 1 - (cGreen / k1);
        int y = 1 - (cBlue / k1);
        return new CMYK(c, m, y, k);
    }
    public void to_HSL(HSL hsl) {
        double h = 0, s = 0;

        // нормализовать значения красного, зеленого, синего
        double r = (double) cRed/ 255.0;
        double g = (double) cGreen / 255.0;
        double b = (double) cBlue / 255.0;

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));

        if(max == min) {
            h = 0;
        }
        else {
            double bufH = 60.0 * (g - b) / (max - min);
            if(max == r && g >= b) {
                h = bufH;
            }
            else if(max == r && g < b) {
                h = bufH + 360.0;
            }
            else if(max == g) {
                h = 60.0 * (b - r) / (max - min) + 120.0;
            }
            else if(max == b) {
                h = 60.0 * (r - g) / (max - min) + 240.0;
            }
        }

        double l = (max + min) / 2.0;

        if(l == 0 || max == min) {
            s = 0;
        }
        else if(0 < l && l <= 0.5) {
            s = (max - min) / (max + min);
        }
        else if(l>0.5) {
            s = (max - min)/(2 - (max + min));
        }

        hsl.set_color((int) h, (float) s, (float) l);
    }
    public HSL to_HSL() {
        double h = 0, s = 0;

        // нормализовать значения красного, зеленого, синего
        double r = (double) cRed/ 255.0;
        double g = (double) cGreen / 255.0;
        double b = (double) cBlue / 255.0;

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));

        if(max == min) {
            h = 0;
        }
        else {
            double bufH = 60.0 * (g - b) / (max - min);
            if(max == r && g >= b) {
                h = bufH;
            }
            else if(max == r && g < b) {
                h = bufH + 360.0;
            }
            else if(max == g) {
                h = 60.0 * (b - r) / (max - min) + 120.0;
            }
            else if(max == b) {
                h = 60.0 * (r - g) / (max - min) + 240.0;
            }
        }

        double l = (max + min) / 2.0;

        if(l == 0 || max == min) {
            s = 0;
        }
        else if(0 < l && l <= 0.5) {
            s = (max - min) / (max + min);
        }
        else if(l>0.5) {
            s = (max - min)/(2 - (max + min));
        }

        return new HSL((short) h, (float) s, (float) l);
    }
    public void to_XYZ(XYZ xyz) {
        float r = cRed / 255F;
        float g = cGreen / 255F;
        float b = cBlue / 255F;

        float x = 0.412453F * r + 0.35758F * g + 0.180423F * b;
        float y = 0.212671F * r + 0.71518F * g + 0.072169F * b;
        float z = 0.019334F * r + 0.119193F * g + 0.950227F * b;

        xyz.set_color((short) (x * 100), (short) (y * 100), (short) (z * 100));
    }
    public XYZ to_XYZ() {
        float r = cRed / 255F;
        float g = cGreen / 255F;
        float b = cBlue / 255F;

        float x = 0.412453F * r + 0.35758F * g + 0.180423F * b;
        float y = 0.212671F * r + 0.71518F * g + 0.072169F * b;
        float z = 0.019334F * r + 0.119193F * g + 0.950227F * b;

        return new XYZ((short) (x * 100), (short) (y * 100), (short) (z * 100));
    }

    @Override
    public String toString() {
        return "RGB{" +
                "cRed=" + cRed +
                ", cGreen=" + cGreen +
                ", cBlue=" + cBlue +
                '}';
    }
}

package example.colors;

public class HSL {
    short cHue;
    float cSaturation;
    float cLightness;
    public HSL() {
        this.cHue = 0;
        this.cLightness = this.cSaturation = 0;
    }
    public HSL(int cHue, float cSaturation, float cLightness) {
        set_color(cHue, cSaturation, cLightness);
    }
    public void set_color(int cHue, float cSaturation, float cLightness) {
        if(cHue >= 0 && cHue < 360) this.cHue = (short) cHue;
        if(cSaturation >= 0 && cSaturation <= 1) this.cSaturation = cSaturation;
        if(cLightness >= 0 && cLightness <= 1) this.cLightness = cLightness;
    }
    public void to_RGB(RGB rgb) {
        if(cSaturation == 0) {
            rgb.set_color((int) (cLightness * 255),
                    (int) (cLightness * 255),
                    (int) (cLightness * 255));
        } else {
            double q = (cLightness < 0.5) ? (cLightness * (1.0 + cSaturation))
                    : (cLightness + cSaturation - (cLightness * cSaturation));
            double p = (2.0 * cLightness) - q;

            double Hk = cHue / 360.0;
            double[] T = new double[3];
            T[0] = Hk + (1.0 / 3.0);    // Tr
            T[1] = Hk;                // Tb
            T[2] = Hk - (1.0 / 3.0);    // Tg

            for (int i = 0; i < 3; i++) {
                if (T[i] < 0) T[i] += 1.0;
                if (T[i] > 1) T[i] -= 1.0;

                if ((T[i] * 6) < 1) {
                    T[i] = p + ((q - p) * 6.0 * T[i]);
                } else if ((T[i] * 2.0) < 1) {
                    T[i] = q;
                } else if ((T[i] * 3.0) < 2) {
                    T[i] = p + (q - p) * ((2.0 / 3.0) - T[i]) * 6.0;
                } else T[i] = p;
            }
            rgb.set_color((int) (T[0] * 255), (int) (T[1] * 255), (int) (T[2] * 255));
        }
    }
    public RGB to_RGB() {
        if(cSaturation == 0) {
            return new RGB((int) (cLightness * 255),
                    (int) (cLightness * 255),
                    (int) (cLightness * 255));
        } else {
            double q = (cLightness < 0.5) ? (cLightness * (1.0 + cSaturation))
                    : (cLightness + cSaturation - (cLightness * cSaturation));
            double p = (2.0 * cLightness) - q;

            double Hk = cHue / 360.0;
            double[] T = new double[3];
            T[0] = Hk + (1.0 / 3.0);    // Tr
            T[1] = Hk;                // Tb
            T[2] = Hk - (1.0 / 3.0);    // Tg

            for (int i = 0; i < 3; i++) {
                if (T[i] < 0) T[i] += 1.0;
                if (T[i] > 1) T[i] -= 1.0;

                if ((T[i] * 6) < 1) {
                    T[i] = p + ((q - p) * 6.0 * T[i]);
                } else if ((T[i] * 2.0) < 1) {
                    T[i] = q;
                } else if ((T[i] * 3.0) < 2) {
                    T[i] = p + (q - p) * ((2.0 / 3.0) - T[i]) * 6.0;
                } else T[i] = p;
            }
            return new RGB((short) (T[0] * 255), (short) (T[1] * 255), (short) (T[2] * 255));
        }
    }
    public void to_Lab(Lab lab) {
        to_RGB().to_XYZ().to_Lab(lab);
    }
    public Lab to_Lab() {
        return to_RGB().to_XYZ().to_Lab();
    }
    public short getHue() {
        return cHue;
    }

    public float getSaturation() {
        return cSaturation;
    }

    public float getLightness() {
        return cLightness;
    }

    @Override
    public String toString() {
        return "HSL{" +
                "cHue=" + cHue +
                ", cSaturation=" + cSaturation +
                ", cLightness=" + cLightness +
                '}';
    }
}

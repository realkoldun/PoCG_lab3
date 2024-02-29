package example.colors;

public class Lab {
    short cLightness;
    short cA;
    short cB;
    public Lab() {
        this.cA = this.cB = this.cLightness = 0;
    }

    public Lab(short cLightness, short cA, short cB) {
        set_color(cLightness, cA, cB);
    }

    public void set_color(short cLightness, short cA, short cB) {
        if(cLightness >= 0 && cLightness <= 100) this.cLightness = cLightness;
        if(cA >= -128 && cA <= 127) this.cA = cA;
        if(cB >= -128 && cB <= 127) this.cB = cB;
    }
    public void to_XYZ(XYZ xyz) {
        double delta = 6.0/29.0;

        double fy = (cLightness + 16) / 116.0;
        double fx = fy + (cA / 500.0);
        double fz = fy - (cB / 200.0);

        xyz.set_color(
                (short) ((fx > delta)? 95.0 * (fx * fx * fx) : (fx - 16.0 / 116.0) * 3 *
                        (delta * delta) * 95.0),
                (short) ((fy > delta)? 100 * (fy * fy * fy) : (fy - 16.0 / 116.0) * 3 *
                        (delta * delta) * 100.0),
                (short) ((fz > delta)? 109 * (fz * fz * fz) : (fz - 16.0 / 116.0) * 3 *
                        (delta * delta)*100)
        );
    }
    public XYZ to_XYZ() {
        double delta = 6.0/29.0;

        double fy = (cLightness + 16) / 116.0;
        double fx = fy + (cA / 500.0);
        double fz = fy - (cB / 200.0);

        return new XYZ(
                (short) ((fx > delta)? 95.0 * (fx * fx * fx) : (fx - 16.0 / 116.0) * 3 *
                        (delta * delta) * 95.0),
                (short) ((fy > delta)? 100 * (fy * fy * fy) : (fy - 16.0 / 116.0) * 3 *
                        (delta * delta) * 100.0),
                (short) ((fz > delta)? 109 * (fz * fz * fz) : (fz - 16.0 / 116.0) * 3 *
                        (delta * delta)*100)
        );
    }
    public void to_HSL(HSL hsl) {
        XYZ xyz = new XYZ(); to_XYZ(xyz);
        System.out.println(xyz);
        RGB rgb = new RGB(); xyz.to_RGB(rgb);
        System.out.println(rgb);
        rgb.to_HSL(hsl);
    }
    public HSL to_HSL() {
        XYZ xyz = new XYZ(); to_XYZ(xyz);
        System.out.println(xyz);
        RGB rgb = new RGB(); xyz.to_RGB(rgb);
        System.out.println(rgb);
        return rgb.to_HSL();
    }

    public short getLightness() {
        return cLightness;
    }

    public short getA() {
        return cA;
    }

    public short getB() {
        return cB;
    }
    @Override
    public String toString() {
        return "Lab{" +
                "cLightness=" + cLightness +
                ", cA=" + cA +
                ", cB=" + cB +
                '}';
    }
}

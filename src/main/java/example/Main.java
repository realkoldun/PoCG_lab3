package example;

import example.colors.CMYK;
import example.colors.HSL;
import example.colors.Lab;
import example.colors.RGB;

public class Main {
    static void lab_2_1() {
        RGB rgb = new RGB(0, 255, 255);
        CMYK cmyk = rgb.to_CMYK();
        System.out.println(cmyk);
        cmyk.set_color(1F, 0.16F, 0F, 0.68F);
        rgb = cmyk.to_RGB();
        System.out.println(rgb);
    }
    static void lab_2_2() {
        HSL hsl = new HSL(0, 1, 1);
        System.out.println(hsl);
        Lab lab = hsl.to_Lab();
        System.out.println(lab);
        hsl = lab.to_HSL();
        System.out.println(hsl);
    }
    public static void main(String[] args) {
        lab_2_1();
        lab_2_2();
    }
}
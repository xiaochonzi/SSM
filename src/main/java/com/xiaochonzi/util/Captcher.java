package com.xiaochonzi.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by stone on 2017/6/21.
 */
public class Captcher {
    private int width = 160;
    private int height = 40;
    private int codeCount = 4;
    private int lineCount = 20;
    private String code = null;
    private BufferedImage buffImg;
    Random random = new Random();

    public Captcher(){
        createImage();
    }

    public Captcher(int width,int height){
        this.width = width;
        this.height = height;
        createImage();
    }

    private void createImage(){
        int fontWidth = width / codeCount;
        int fontHeight = height - 5;
        int codeY = height - 8;

        buffImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = buffImg.getGraphics();
        g.setColor(getRandColor(200,250));
        g.fillRect(0,0,width,height);

        Font font = new Font("Fixedsys",Font.BOLD,fontHeight);
        g.setFont(font);

        for(int i=0;i<lineCount;i++){
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width);
            int ye = ys + random.nextInt(height);
            g.setColor(getRandColor(1,255));
            g.drawLine(xs,ys,xe,ye);
        }
        float yawpRate = 0.01f;
        int area = (int)(yawpRate * width * height);
        for(int i=0;i<area;i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            buffImg.setRGB(x,y,random.nextInt(255));
        }
        String ret = randomStr(codeCount);
        this.code = ret;
        for(int i=0;i<codeCount;i++){
            String strRand = ret.substring(i,i+1);
            g.setColor(getRandColor(1,255));
            g.drawString(strRand,i*fontWidth+3,codeY);
        }
        shearX(g,width,height,getRandColor(1,255));
    }

    private void shearX(Graphics g,int w,int h,Color color){
        int period = random.nextInt(2);
        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);
        for (int i = 0; i < h; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w, i, w, i);
            }
        }
    }
    private void shearY(Graphics g,int w,int h,Color color){
        int period = random.nextInt(40) + 10;
        boolean borderGap = true;
        int frames = 20;
        int phase = random.nextInt(7);
        for (int i = 0; i < h; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h, 0, (int)d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i,(int)d,i,0);
                g.drawLine(i,(int)d+h,i,h);
            }
        }
    }

    public void write(OutputStream os) throws IOException {
        ImageIO.write(buffImg,"png",os);
    }

    public String getCode() {
        return code!=null?code.toLowerCase():null;
    }

    private String randomStr(int n){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String ret = "";
        int len = str.length() - 1;
        double r;
        for(int i=0;i<n;i++){
            r = (Math.random()) * len;
            ret = ret + str.charAt((int)r);
        }
        return ret;
    }

    private Color getRandColor(int fc,int bc){
        if(fc > 255){
            fc = 255;
        }
        if(bc > 255){
            bc = 255;
        }
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}

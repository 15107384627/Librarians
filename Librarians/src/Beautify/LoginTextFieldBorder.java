package Beautify;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

public class LoginTextFieldBorder extends AbstractBorder{
	//美化账号密码输入框
private static final Color BACKGROUND01=new Color(0,30,255);
public LoginTextFieldBorder(){
}
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
Graphics2D g2d=(Graphics2D) g;
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));				//设置线条宽带
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));					//设置透明度
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(BACKGROUND01);
        g2d.drawRoundRect(0, 0, c.getWidth(),c.getHeight()-3, 9, 20);								//设置矩形的样式
    }
    public Insets getBorderInsets(Component c)       {
        return new Insets(3, 5, 4, 0);																//设置文本框的位置
    }
}

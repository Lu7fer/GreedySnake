package cf.vbnm.gui;

import java.awt.*;

/**
 * �滭�ӿ�,ʵ�ִ˽ӿڿ�������Ļ�ϻ���ͼ��
 */
public interface Drawable {
	/**
	 * X��Ļ���ƫ��
	 */
	int XOffset = Constant.DRAW_X_OFFSET;
	/**
	 * Y����ƫ��
	 */
	int YOffset = Constant.DRAW_Y_OFFSET;

	/**
	 * ������Ҫ���ƵĶ���
	 *
	 * @param g ϵͳ���õ�,��������ͼ��
	 */
	void paint(Graphics g);
}

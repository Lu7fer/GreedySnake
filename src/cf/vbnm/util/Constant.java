package cf.vbnm.util;

import java.awt.*;

/**
 * �����洢������Ը��ĵĳ���
 */
public final class Constant {
	/**
	 * ����Ҫnew�����
	 */
	private Constant() {
	}

	/**
	 * ��ʼҳ��������ʽ
	 */
	public static final Font BUTTON_FONT = new Font("����", Font.BOLD | Font.ITALIC, 25);
	/**
	 * �����ͼ�ĺ��������ƫ����
	 */
	public static final int DRAW_X_OFFSET = 10;
	public static final int DRAW_Y_OFFSET = 7;
	/**
	 * һ����ͼ���ӵĳ���
	 */
	public static final int GRID_WIDTH = 10;
	public static final int GRID_HEIGHT = 10;
	/**
	 * ̰����һ��body�ĳ���
	 */
	public static final int SNAKE_BODY_WIDTH = 9;
	public static final int SNAKE_BODY_HEIGHT = 9;
	/**
	 * ��Ϸʱ�ײ���״̬��
	 */
	public static final int BOTTOM_DOCK_HEIGHT = 60;
	/**
	 * �ߵĳ�ʼ����
	 */
	public static final int INIT_SNAKE_LENGTH = 5;
	/**
	 * ��ͼ���������
	 */
	public static final int GRID_X_NUM = 40;
	public static final int GRID_Y_NUM = 30;
	/**
	 * ʳ������
	 */
	public static final int FOODS_NUM = 50;
	/**
	 * �����������С����ʱ��
	 */
	public static final int RANDOM_SEED_UPDATE_TIME = 2000;
	/**
	 * �ߵ��ٶ�
	 */
	public static final int SNAKE_SPEED = 150;
	/**
	 * �����ڴ�С
	 */
	public static final int MAIN_WINDOW_WIDTH = 300;
	public static final int MAIN_WINDOW_HEIGHT = 200;
	/**
	 * �������ڵ�ƫ��
	 */
	public static final int GAME_WINDOW_X_OFFSET =
			(1920 - (GRID_X_NUM + 5) * GRID_WIDTH) / 2;
	public static final int GAME_WINDOW_Y_OFFSET =
			(1080 - (GRID_Y_NUM + 7) * GRID_HEIGHT - BOTTOM_DOCK_HEIGHT) / 2;
	public static final int MAIN_WINDOW_X_OFFSET = (1920 - MAIN_WINDOW_WIDTH) / 2;
	public static final int MAIN_WINDOW_Y_OFFSET = (1080 - MAIN_WINDOW_HEIGHT) / 2;
	/**
	 * ��������ʱ��, ��¼��־��
	 */
	public static final long TIME_STAMP = System.currentTimeMillis();
}

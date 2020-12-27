package cf.vbnm.gui;

import cf.vbnm.gui.components.Food;
import cf.vbnm.gui.components.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Ϸ����, ������, ʳ��ȵ�����, ��װ����Ϸ���ݵĶ���
 */
public class GameWindow implements Drawable {

	/**
	 * ���÷���
	 */
	private int score;
	/**
	 * ��Ϸpanel,������Ϸ��
	 */
	private JPanel gamePanel;
	/**
	 * ̰���߶���
	 */
	private Snake snake;
	/**
	 * ���е�ʳ�����
	 */
	private ArrayList<Food> foods;
	/**
	 * ��ʶ��Ϸ�Ƿ�������(�Ƿ�û��ͣ)
	 */
	private boolean gameContinue;

	/**
	 * ��ͣ��Ϸ
	 */
	public void pauseGame() {
		this.gameContinue = false;
	}

	/**
	 * ������Ϸ
	 */
	public void resumeGame() {
		this.gameContinue = true;
	}

	/**
	 * ��ȡ��Ϸ�Ƿ�������
	 *
	 * @return ��Ϸ�Ƿ�������
	 */
	public boolean getGameContinue() {
		return gameContinue;
	}

	/**
	 * ��ȡ����̰����
	 *
	 * @return ����̰����
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * ����һ��̰����
	 *
	 * @param snake Ҫ��ӵ���
	 */
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	/**
	 * ��ȡʳ��
	 *
	 * @return ����ʳ�������
	 */
	public ArrayList<Food> getFoods() {
		return foods;
	}

	/**
	 * ��������ʳ��
	 *
	 * @param foods ����ʳ�������
	 */
	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}


	/**
	 * ��ȡ��ǰ����
	 *
	 * @return ��ǰ����
	 */
	public int getScore() {
		return score;
	}

	/**
	 * �ӷ�
	 *
	 * @param score Ҫ�ӵķ���
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * ��ȡ��Ϸpanel
	 *
	 * @return ��Ϸ��panel
	 */
	public JPanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * ������Ϸpanel
	 *
	 * @param gamePanel ��Ϸ��panel
	 */
	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	/**
	 * ���췽��
	 *
	 * @param snake ��Ҫһ��̰������ɹ���
	 */
	public GameWindow(Snake snake) {
		this.snake = snake;
		foods = new ArrayList<>();
	}

	/**
	 * Drawable�ӿ�ʵ��
	 *
	 * @param g ͼ�ζ���,ϵͳ��������ͼ��
	 */
	@Override
	public void paint(Graphics g) {
		gamePanel.repaint();
	}
}

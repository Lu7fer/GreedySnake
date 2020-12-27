package cf.vbnm.main;

import cf.vbnm.gui.Constant;

import javax.swing.*;

/**
 * ����,������
 */
public class Main {
	/**
	 * ��Ϸ���
	 */
	private JFrame entry;
	/**
	 * ѡ��
	 */
	private JPanel select;
	/**
	 * ��ʼ��Ϸ����
	 */
	private JButton startGame;
	/**
	 * �˳�����
	 */
	private JButton exit;
	/**
	 * ����
	 */
	private final GameMain gameMain = new GameMain();

	/**
	 * ����ע��
	 *
	 * @param args �������ûɶ��
	 */
	public static void main(String[] args) {
		System.err.printf("%.3f [WARNING] ��ʼ��\n", 0.0f);
		Main main = new Main();
		main.entry = new JFrame("��ɫ̰����С��Ϸ");
		main.entry.setBounds(Constant.MAIN_WINDOW_X_OFFSET, Constant.MAIN_WINDOW_Y_OFFSET,
				Constant.MAIN_WINDOW_WIDTH, Constant.MAIN_WINDOW_HEIGHT);
		/*���������贰���С*/
		main.entry.setResizable(false);
		main.entry.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		main.select = new JPanel();
		main.startGame = new JButton("Start Game!");
		main.exit = new JButton("EXIT");
		/*��������*/
		main.startGame.setFont(Constant.BUTTON_FONT);
		main.exit.setFont(Constant.BUTTON_FONT);
		/*������*/
		main.select.add(main.startGame);
		main.select.add(main.exit);
		main.entry.add(main.select);
		/*ע���¼�*/
		main.eventReg(main);
		main.entry.setVisible(true);
		main.entry.validate();

	}

	/**
	 * ��һ�����ڵ��¼�ע��
	 *
	 * @param main ��������ע���¼���,�����ڵĶ���������
	 */
	public void eventReg(Main main) {
		System.err.printf("%.3f [WARNING] �������¼�ע��\n",
				(float) (System.currentTimeMillis() - Constant.TIME_STAMP) / 1000);
		/*��ʼ��Ϸ���¼�ע��*/
		main.startGame.addActionListener((e) -> {
			gameMain.init(Constant.INIT_SNAKE_LENGTH, Constant.FOODS_NUM,
					Constant.GRID_X_NUM, Constant.GRID_Y_NUM);
			gameMain.regEvent();
			gameMain.setSuperFrame(entry);
			entry.setVisible(false);
			gameMain.startGame();
		});
		/*�˳����¼�ע��*/
		main.exit.addActionListener((e -> {
			System.exit(0);
		}));
	}

}

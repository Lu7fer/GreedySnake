package cf.vbnm.gui.components;

import cf.vbnm.util.Constant;
import cf.vbnm.gui.Drawable;
import cf.vbnm.util.Util;

import java.awt.*;

/**
 * ���ඨ����ʳ���ʵ��
 */
public class Food extends AbstractFood implements Drawable {
	/**
	 * ʳ������,���ԼӲ�ͬ�÷�
	 */
	private EnumFood foodType;
	/**
	 * ʳ����ɫ
	 */
	private ComponentColor color;
	/**
	 * ʳ��λ��
	 */
	private Point coordinate;

	/**
	 * ���췽��, ����һ��ʳ��
	 *
	 * @param color      ʳ����ɫ
	 * @param coordinate ʳ��λ��
	 */
	public Food(Point coordinate, ComponentColor color) {
		this.coordinate = coordinate;
		setFoodType();
		this.color = color;
	}

	/**
	 * ���ʳ�����ɫ
	 *
	 * @return ʳ����ɫ
	 */
	public ComponentColor getColor() {
		return color;
	}

	/**
	 * ���ʳ��λ��
	 *
	 * @return ʳ��λ��
	 */
	public Point getCoordinate() {
		return coordinate;
	}

	/**
	 * �������һ��ʳ������,
	 * �����е�ʳ�����3/5,��ʳ�����1/5,��ʳ�����1/5
	 */
	public void setFoodType() {
		int random = Util.random(5);
		switch (random) {
			case 0:
				foodType = EnumFood.BAD;
			case 1:
			case 2:
			case 3:
				foodType = EnumFood.MIDDLE;
			default:
				foodType = EnumFood.GOOD;
		}
	}

	/**
	 * ���ʳ������,�Ա����Ӧ�ķ�
	 *
	 * @return ʳ������
	 */
	public EnumFood getFoodType() {
		return foodType;
	}

	/**
	 * ����һ�������ʳ��,���ǲ��ܸ��ߵ�λ���ص�
	 *
	 * @param snake ̰����
	 * @return ����һ��ʳ��
	 */
	public Food generateFood(Snake snake) {
		Point randomPoint = Util.randomPoint(Constant.GRID_X_NUM, Constant.GRID_Y_NUM);
		while (true) {
			boolean innerFlag = true;
			for (Point point : snake.getSnakePosition()) {
				if (randomPoint.equals(point)) {
					randomPoint = Util.randomPoint(Constant.GRID_X_NUM, Constant.GRID_Y_NUM);
					innerFlag = false;
					break;
				}
			}
			if (innerFlag)
				return new Food(randomPoint, ComponentColor.getRandomColor());
		}
	}

	/**
	 * ����ʳ��
	 *
	 * @param g ϵͳ����
	 */
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(color.getColor());
		g.fillRect(coordinate.x * Constant.GRID_WIDTH + Drawable.XOffset + 1,
				coordinate.y * Constant.GRID_HEIGHT + Drawable.YOffset + 1,
				Constant.SNAKE_BODY_WIDTH, Constant.SNAKE_BODY_HEIGHT
		);
		g.setColor(c);
	}

	/**
	 * ������ɫ
	 *
	 * @param color ��ɫ
	 */
	@Override
	public void setColor(ComponentColor color) {
		this.color = color;
	}
}

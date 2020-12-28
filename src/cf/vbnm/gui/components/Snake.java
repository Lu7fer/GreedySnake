package cf.vbnm.gui.components;

import cf.vbnm.util.Constant;
import cf.vbnm.gui.Drawable;
import cf.vbnm.main.GameMain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ����������һ��̰���������е�����
 */
public class Snake implements Drawable, Movable, HitBorder {
	/**
	 * �ߵ�����
	 */
	Body snakeBody;
	/**
	 * ���ߵķ���
	 */
	Direction direction;
	/**
	 * �������ķ���,�Ա���һ�����ص�bug
	 */
	Direction tempDirection;

	/**
	 * �ߵ�����Ķ���,��Ա�ڲ���
	 */
	private static class Body {
		/**
		 * ������ĸ�����ɫ������
		 */
		private final ArrayList<ComponentColor> bodyColor;
		/**
		 * ������������ֵ�����
		 */
		private LinkedList<Point> coordinates;

		/**
		 * ���췽��,����һ���ߵ�����
		 *
		 * @param snakeLength �߳�ʼ����
		 */
		public Body(int snakeLength) {
			bodyColor = new ArrayList<>();
			coordinates = new LinkedList<>();
			for (int i = 0; i < snakeLength; i++) {
				bodyColor.add(ComponentColor.getRandomColor());
				coordinates.add(new Point(i, 0));
			}
		}

		/**
		 * ���һ���ߵķ���
		 *
		 * @param componentColor �ߵ���ɫ
		 * @param coordinate     �ߵ�λ��
		 */
		public void addBody(ComponentColor componentColor, Point coordinate) {
			bodyColor.add(componentColor);
			coordinates.addLast(coordinate);
		}

		/**
		 * �õ��ߵ�������ɫ
		 *
		 * @return �ߵ����������ɫ������
		 */
		public ArrayList<ComponentColor> getBodyColor() {
			return bodyColor;
		}

		/**
		 * �õ��ߵ�����λ��
		 *
		 * @return �ߵ�λ�õ�����
		 */
		public LinkedList<Point> getCoordinates() {
			return coordinates;
		}
	}

	/**
	 * �õ��ߵĸ������岿λ������
	 *
	 * @return �ߵ�λ�õ�����
	 */
	public LinkedList<Point> getSnakePosition() {
		return snakeBody.coordinates;
	}

	/**
	 * ��ȡ̰���ߵ�ǰǰ������
	 *
	 * @return ǰ������
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * ����̰���ߵ�ǰǰ������
	 *
	 * @param direction ����
	 */
	public void setDirection(Direction direction) {
		this.tempDirection = direction;
	}

	/**
	 * ʵ�ֻ����ߵķ���,�ɵ��Ե���
	 *
	 * @param g ͼ��
	 */
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		Iterator<Point> coordinateIterator = snakeBody.getCoordinates().iterator();
		Iterator<ComponentColor> colorIterator = snakeBody.getBodyColor().iterator();
		while (coordinateIterator.hasNext() && colorIterator.hasNext()) {
			g.setColor(colorIterator.next().getColor());
			Point next = coordinateIterator.next();
			g.fillRect(next.x * Constant.GRID_WIDTH + Drawable.XOffset + 1,
					next.y * Constant.GRID_HEIGHT + Drawable.YOffset + 1,
					Constant.SNAKE_BODY_WIDTH, Constant.SNAKE_BODY_HEIGHT);
		}
		g.setColor(c);
	}

	/**
	 * ����һ��̰����
	 *
	 * @param initLength �ߵĳ�ʼ����
	 */
	public Snake(int initLength) {
		snakeBody = new Body(initLength);
		direction = Direction.RIGHT;
		tempDirection = Direction.RIGHT;
	}

	/**
	 * Movable�ӿڻص���չ����
	 *
	 * @param direction �ƶ�����
	 */
	public void move0(Direction direction) {
		LinkedList<Point> coordinates = snakeBody.getCoordinates();
		Point first = coordinates.removeFirst();
		Point last = coordinates.getLast();
		if (direction == Direction.UP) {
			first.x = last.x;
			first.y = last.y - 1;
		} else if (direction == Direction.DOWN) {
			first.x = last.x;
			first.y = last.y + 1;
		} else if (direction == Direction.LEFT) {
			first.x = last.x - 1;
			first.y = last.y;
		} else if (direction == Direction.RIGHT) {
			first.x = last.x + 1;
			first.y = last.y;
		}
		coordinates.addLast(first);
	}

	/**
	 * ײǽ��Ļص�,(��ֹ��Ϸ)
	 */
	@Override
	public void hitBorder() {
		GameMain.getGameWindow().pauseGame();
		JButton jButton = (JButton) GameMain.getGameWindow().getGamePanel().getComponent(1);
		jButton.setText("��ʧ����,�÷���" + GameMain.getGameWindow().getScore());
		jButton.setVisible(true);
		try {
			Thread.sleep(Constant.SNAKE_SPEED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jButton.repaint();
	}

	/**
	 * �ж�ǰ����û��ʳ��,ͬʱ�Ե�ǰ���ʳ�ﲢ�����峤��+1
	 *
	 * @param p     ��ǰ���ڵĵ�
	 * @param d     ����
	 * @param foods ���е�ʳ��
	 * @return �Ƿ�Ե���ʳ��
	 */
	public boolean isFoodFront(Point p, Direction d, ArrayList<Food> foods) {
		p = (Point) p.clone();
		if (d == Direction.UP) {
			p.y -= 1;
			return eatFood(p, foods);
		} else if (d == Direction.DOWN) {
			p.y += 1;
			return eatFood(p, foods);
		} else if (d == Direction.RIGHT) {
			p.x += 1;
			return eatFood(p, foods);
		} else if (d == Direction.LEFT) {
			p.x -= 1;
			return eatFood(p, foods);
		}
		return false;
	}

	/**
	 * Movable�ӿڵ�ʵ��
	 */
	@Override
	public void move() {
		System.out.printf("%.3f [INFO] 1 step\n",
				(float) (System.currentTimeMillis() - Constant.TIME_STAMP) / 1000);
		direction = tempDirection;
		move1(GameMain.getGameWindow().getFoods());
	}

	/**
	 * �߽���, ͬʱ���᲻�������Լ�
	 *
	 * @param direction ��Ҫ���ķ���
	 * @return �Ƿ������߽�, ���߳Ե��Լ�
	 */
	public boolean hitDetect(Direction direction) {
		Point last = snakeBody.getCoordinates().getLast();
		last = (Point) last.clone();
		if (direction == Direction.UP) {
			if (last.y-- <= 0) {
				return true;
			}
		} else if (direction == Direction.DOWN) {
			if (last.y++ >= Constant.GRID_Y_NUM - 1) {
				return true;
			}
		} else if (direction == Direction.LEFT) {
			if (last.x-- <= 0) {
				return true;
			}
		} else if (direction == Direction.RIGHT) {
			if (last.x++ >= Constant.GRID_X_NUM - 1) {
				return true;
			}
		}
		for (Point point : snakeBody.getCoordinates()) {
			if (point.equals(last)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �Ե�һ������,Ȼ������һ���·���
	 *
	 * @param p     ���ķ���,���P������ʳ��,�ͳԵ�
	 * @param foods ���е�ʳ��
	 * @return �Ƿ�Ե�ʳ��
	 */
	private synchronized boolean eatFood(Point p, ArrayList<Food> foods) {
		Food food;
		for (int i = 0; i < foods.size(); i++) {
			food = foods.get(i);
			if (food.getCoordinate().equals(p)) {
				snakeBody.addBody(food.getColor(), food.getCoordinate());
				/*���ݳԵ��Ĳ�ͬ�������ԼӲ�ͬ�ķ���*/
				switch (food.getFoodType()) {
					case BAD:
						GameMain.getGameWindow().addScore(1);
					case MIDDLE:
						GameMain.getGameWindow().addScore(2);
					case GOOD:
						GameMain.getGameWindow().addScore(3);
				}
				System.out.printf("%.3f [INFO] �Ե�ʳ��\n", (float) (System.currentTimeMillis() - Constant.TIME_STAMP) / 1000);
				foods.set(i, food.generateFood(this));
				return true;
			}
		}
		return false;
	}

	/**
	 * �ƶ�, �����ʳ��,��Ե���;ͬʱ��ײ���
	 *
	 * @param foods ʳ��
	 */
	public void move1(ArrayList<Food> foods) {
		if (isFoodFront(snakeBody.coordinates.getLast(), direction, foods)) {
			return;
		}
		/*		if (direction == Direction.UP) {*/
		if (!hitDetect(direction)) {
			move0(direction);
		} else {
			hitBorder();
		}

	}

}

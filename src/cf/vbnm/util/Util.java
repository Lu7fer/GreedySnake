package cf.vbnm.util;

import java.awt.*;
import java.util.Random;

/**
 * ������
 * ֮���Բ�ʹ�� (int)(Math.random()*bounds)����Ϊ��ĳЩ�����
 * ����һЩֵ����ȡ��,����ʹ��Random��ֱ����������ͬ���㷨��α�����
 */
public class Util {
	private static Random random;
	/**
	 * ��ǰ�����������
	 */
	private static long randomSeed;

	static {
		random = new Random();
		random.setSeed((randomSeed = System.currentTimeMillis()));
	}

	/**
	 * ����һ��α�����������ȡ�Դ���������������еġ��� 0��������
	 * ��ָ��ֵ����������֮����ȷֲ��� int ֵ��
	 * �˷�������2�����һ�������������������
	 *
	 * @param bounds ��Χ
	 * @return ����[0, bounds)��α�������
	 */
	public static int random(int bounds) {
//		random.setSeed(System.currentTimeMillis());
		long l = System.currentTimeMillis();
		if (l - randomSeed > Constant.RANDOM_SEED_UPDATE_TIME)
			random.setSeed((randomSeed = l));
		return random.nextInt(bounds);
	}

	/**
	 * ����һ����Χ�������
	 *
	 * @param start  ��start��ʼ
	 * @param bounds ��Χ
	 * @return ����[start, bounds)��Χ�ڵ�α�������
	 */
	public static int random(int start, int bounds) {
		return random(bounds - start) + start;
	}


	/**
	 * �˷���ֱ���������һ��Point����,����Point�����X,YȡֵΪ[0,XBounds),[0,YBounds)
	 *
	 * @param XBounds X��ȡֵ��Χ,��0��ʼ
	 * @param YBounds Y��ȡֵ��Χ,��0��ʼ
	 * @return ����һ��������ɵ�Point����, ����Point�����X, YȡֵΪ[0, XBounds),[0,YBounds)
	 */
	public static Point randomPoint(int XBounds, int YBounds) {
		return new Point(random(XBounds), random(YBounds));
	}
}

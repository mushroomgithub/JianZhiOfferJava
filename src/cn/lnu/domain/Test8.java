package cn.lnu.domain;

public class Test8 {

	public static void main(String[] args) {
		// ���н���Է�Ϊ��λ
		int money =0;
				
		// ���г�Ʊ���Է�Ϊ��λ���Ӵ�С���У�10000��100�飬20��2��
		int[] rmbs = {1,5,10,20,50,100};

		// rest��ʣ���Ǯ���տ�ʼΪ�����Ǯ�����ѡǮrestԽ��ԽС��ֱ��Ϊ0
		int rest = money;
		for (int rmb : rmbs) {
			// numΪ��Ʊ����
			int num = rest / rmb;
			if (num > 0) {
				rest = rest - rmb * num;

				System.out.println("��Ʊ���(��)��" + rmb + " ������" + num + " �������Ǯ(��)��" + rest);

				// Ǯ�����ˣ��������
				if (rest == 0) {
					System.exit(1);
				}
			}  // end if num
		} // end for rmb
	}

}

package cn.lnu.domain;

public class Test8 {

	public static void main(String[] args) {
		// 所有金额以分为单位
		int money =0;
				
		// 所有钞票面以分为单位，从大到小排列，10000是100块，20是2角
		int[] rmbs = {1,5,10,20,50,100};

		// rest是剩余的钱，刚开始为所求的钱，随便选钱rest越变越小，直到为0
		int rest = money;
		for (int rmb : rmbs) {
			// num为钞票个数
			int num = rest / rmb;
			if (num > 0) {
				rest = rest - rmb * num;

				System.out.println("钞票面额(分)：" + rmb + " 个数：" + num + " 还差多少钱(分)：" + rest);

				// 钱凑齐了，程序结束
				if (rest == 0) {
					System.exit(1);
				}
			}  // end if num
		} // end for rmb
	}

}

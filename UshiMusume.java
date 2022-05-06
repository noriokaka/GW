import java.util.*;
public class UshiMusume{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String[] species={"ホルスタイン","ジャージー","黒毛和牛","褐毛和牛","無角和牛","ショートホーン","シャロレー"};
		String[] params={"ライフ","ちから","丈夫さ","命中","回避","かしこさ"};
		double[][] spRatio={
			{1,1,1,1,1,1},
			{1.2,0.8,1.2,1,0.8,1},
			{0.8,1.6,0.8,0.8,0.8,1.2},
			{1.2,1.2,0.8,0.8,1,1},
			{0.8,1,0.8,1,1.2,1.2},
			{1,1.2,1,1.2,0.8,0.8},
			{1,0.8,1.2,1,1.2,0.8},
		};
		while(true){
			System.out.println("きこえますか……きこえますか……");
			System.out.println("1: はい");
			System.out.println("2: いいえ");
			System.out.print("選択肢を入力>>");
			int select = sc.nextInt();sc.nextLine();
			if(select==1){
				break;
			}
		}
		System.out.println("*****");
		System.out.println("私の名前はSHAZNA。今あなたの心に直接語り掛けています。");
		System.out.println("あなたにはウシ娘のブリーダーとして世界を救う使命があります。");
		System.out.println("最初に、あなたのパートナーとなるウシ娘を召喚しましょう。");
		int nSp;
		int[] status;
		while(true){
			System.out.println("召喚の呪文を唱えてください。");
			System.out.print("呪文を入力>>");
			String spell = sc.nextLine();
			System.out.println("*****");
			int seed=calcSeed(spell);
			nSp = new Random(seed).nextInt(species.length);
			System.out.printf("%sのウシ娘が召喚されました。%n",species[nSp]);
			status=makeStatus(seed,nSp,spRatio);
			System.out.println("*****");
			showStatus(status,params);
			System.out.println("*****");
			System.out.println("このウシ娘をパートナーにしますか？");
			System.out.println("1: はい");
			System.out.println("2: いいえ");
			System.out.print("選択肢を入力>>");
			int select = sc.nextInt();sc.nextLine();
			System.out.println("*****");
			if(select==1){
				break;
			}
			System.out.printf("%sは悲しそうな表情を浮かべながら消滅してしまいました。%n",species[nSp]);
			System.out.println("*****");
		}
		System.out.printf("%sに名前を付けましょう。%n",species[nSp]);
		System.out.print("名前を入力>>");
		String name = sc.nextLine();
		System.out.printf("%s……良い名前ですね。%n",name);
		System.out.printf("%sを最高のウシ娘に育てましょう!%n",name);
		try{
			Thread.sleep(777);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("*****");
		System.out.println("ファームに移動しました。");
		int age=0;
		int fatigue=0; //疲労パラメータ
		int shape=50; //体型パラメータ
		int bse=0; //狂牛病パラメータ
		double boost=1.0; //能力UP補正
		int month=1;
		while(true){
			System.out.println("*****");
			System.out.printf("Month %d%n",month);
			System.out.println("*****");
			if(age>240){
				System.out.printf("%sは天寿を全うしました。%n",name);
				System.out.println("Fin");
				break;
			}
			if(fatigue<20){
				System.out.printf("%sはとても元気です。%n",name);
			}else if(fatigue<40){
				System.out.printf("%sは元気です。%n",name);
			}else if(fatigue<60){
			}else if(fatigue<80){
				System.out.printf("%sは疲れています。%n",name);
			}else if(fatigue<100){
				System.out.printf("%sはとても疲れています。休ませてあげてください。%n",name);
			}else{
				System.out.printf("%sは過労死しました。%n",name);
				System.out.println("GAME OVER");
				break;
			}
			if(shape<0){
				System.out.printf("%sは栄養失調で死んでしまいました。%n",name);
				System.out.println("GAME OVER");
				break;
			}else if(shape<20){
				System.out.printf("%sは痩せ過ぎです。栄養が不足しています。%n",name);
			}else if(shape<40){
				System.out.printf("%sは痩せています。%n",name);
			}else if(shape<60){
			}else if(shape<80){
				System.out.printf("%sは太っています。%n",name);
			}else if(shape<100){
				System.out.printf("%sは太り過ぎです。食事に気を付けてください。%n",name);
			}else{
				System.out.printf("%sは高度肥満症により死亡しました。%n",name);
				System.out.println("GAME OVER");
				break;
			}
			System.out.println("*****");
			System.out.printf("%sの餌を選択してください。%n",name);
			System.out.println("1: 草");
			System.out.println("2: 穀物");
			System.out.println("3: 肉骨粉");
			System.out.print("選択肢を入力>>");
			int feed = sc.nextInt();sc.nextLine();
			if(feed==1){
				System.out.printf("%sは草を食べた。%n",name);
				shape+=3;
				boost=1.0;
			}else if(feed==2){
				System.out.printf("%sは穀物を食べた。%n",name);
				shape+=10;
				boost=1.2;
			}else{
				System.out.printf("%sは肉骨粉を食べた。%n",name);
				shape+=10;
				int dB=rand.nextInt(30);
				bse+=dB;
				boost=3.0;
			}
			if(bse>100){
				System.out.printf("%sは狂牛病になり殺処分されてしまいました。%n",name);
				System.out.println("GAME OVER");
				break;
			}
			if(age>30){
				for(int i=0;i<status.length;i++){
					status[i]=(int)(status[i]*0.9);
				}
			}
			int action=0;
			while(action==0){
				System.out.println("*****");
				System.out.println("行動を選択してください。");
				System.out.printf("0: %sのステータスを確認する%n",name);
				System.out.printf("1: %sを調教する%n",name);
				System.out.printf("2: %sを休養させる%n",name);
				System.out.printf("3: %sをドナドナする%n",name);
				System.out.print("選択肢を入力>>");
				action = sc.nextInt();sc.nextLine();
				System.out.println("*****");
				if(action==0){
					System.out.printf("名前：%s%n",name);
					System.out.printf("種族：%s%n",species[nSp]);
					System.out.printf("年齢：%s歳%sヵ月%n",age/12,age%12);
					showStatus(status,params);
				}	
			}
			if(action==1){
				training(status,params,spRatio,nSp,boost);
				fatigue+=(rand.nextInt(11)+5);;
				shape-=(rand.nextInt(6)+5);
			}else if(action==2){
				System.out.printf("%sは体を休めました。%n",name);
				fatigue-=50;
				if(fatigue<0){
					fatigue=0;
				}
			}else if(action==3){
				danadana(name,status);
				System.out.println("Fin");
				break;
			}
			age+=1;
			month+=1;
			try{
				Thread.sleep(777);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	static int calcSeed(String spell){
		int seed=0;
		for(int i=0;i<spell.length();i++){
			seed+=spell.charAt(i);
		}
		return seed;
	}
	static int[] makeStatus(int seed,int nSp,double[][] spRatio){
		int[] vals=new int[spRatio[nSp].length];
		for(int i=0;i<vals.length;i++){
			int cor = new Random(seed+i).nextInt(50);
			vals[i]=(int)(100*spRatio[nSp][i]+cor);
		}
		return vals;
	}
	static void showStatus(int[] status,String[] params){
		for(int i=0;i<status.length;i++){
			System.out.println(params[i] + ":" + status[i]);
		}
	}
	static void training(int[] status,String[] params,double[][] spRatio,int nSp,double boost){
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("調教内容を選択してください。");
		System.out.println("0: ライフ調教");
		System.out.println("1: ちから調教");
		System.out.println("2: 丈夫さ調教");
		System.out.println("3: 命中調教");
		System.out.println("4: 回避調教");
		System.out.println("5: かしこさ調教");
		System.out.print("選択肢を入力>>");
		int select = sc.nextInt();sc.nextLine();
		System.out.printf("%s調教をしました。%n",params[select]);
		int val = rand.nextInt(21)+10;
		int dSt = (int)(val*spRatio[nSp][select]*boost);
		System.out.printf("%sが%d上がりました。%n",params[select],dSt);
		status[select]+=dSt;
	}
	static void danadana(String name,int[] status){
		String[] foods={"ローストビーフ","ユッケ","ステーキ","焼肉","すき焼き","ビーフストロガノフ","牛丼"};
		double[][] fdRatio={
			{1.1,1.1,1.1,1.1,1.1,1.1},
			{1.4,0.8,1.2,0.8,0.8,1.1},
			{1.1,1.3,1.3,1.1,0.8,0.8},
			{1,1.2,1,0.8,1.2,1},
			{1.2,1.1,1.1,0.9,1.1,1.1},
			{0.8,0.9,1,1.3,1.3,1.2},
			{0.9,0.9,0.9,0.9,0.9,0.9},
		};
		System.out.printf("%sはドナドナされました。%n",name);
		int result = new Random().nextInt(7);
		System.out.printf("%sは%sに調理されました。%n",name,foods[result]);
		int point=0;
		for(int i=0;i<status.length;i++){
			point+=(int)(status[i]*fdRatio[result][i]);
		}
		System.out.println("おいしくできました。");
		System.out.printf("評価：%d点%n",point);
	}
}

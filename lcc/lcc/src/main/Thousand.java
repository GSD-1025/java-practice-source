package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Thousand {
	private String cheonex= "天地玄黃 宇宙洪荒  " + 
					"日月盈昃 辰宿列張  " + "寒來暑往 秋收冬藏  " + "閏餘成歲 律呂調陽  " + 
					"雲騰致雨 露結爲霜  " + "金生麗水 玉出崑岡  " + "劍號巨闕 珠稱夜光  " + 
					"果珍李柰 菜重芥薑  " + "海鹹河淡 鱗潛羽翔  " + "龍師火帝 鳥官人皇  " + 
					"始制文字 乃服衣裳  " + "推位讓國 有虞陶唐  " + "弔民伐罪 周發殷湯  " + 
					"坐朝問道 垂拱平章  " + "愛育黎首 臣伏戎羌  " + "遐邇壹體 率賓歸王  " + 
					"鳴鳳在樹 白駒食場  " + "化被草木 賴及萬方  " + "蓋此身髮 四大五常  " + 
					"恭惟鞠養 豈敢毁傷  " + "女慕貞烈 男效才良  " + "知過必改 得能莫忘  " + 
					"罔談彼短 靡恃己長  " + "信使可覆 器欲難量  " + "墨悲絲染 詩讚羔羊  " + 
					"景行維賢 克念作聖  " + "德建名立 形端表正  " + "空谷傳聲 虛堂習聽  " + 
					"禍因惡積 福緣善慶  " + "尺璧非寶 寸陰是競  " + "資父事君 曰嚴與敬  " + 
					"孝當竭力 忠則盡命  " + "臨深履薄 夙興溫凊  " + "似蘭斯馨 如松之盛  " + 
					"川流不息 淵澄取暎  " + "容止若思 言辭安定  " + "篤初誠美 愼終宜令  " + 
					"榮業所基 籍甚無竟  " + "學優登仕 攝職從政  " + "存以甘棠 去而益詠  " + 
					"樂殊貴賤 禮別尊卑  " + "上和下睦 夫唱婦隨  " + "外受傅訓 入奉母儀  " + 
					"諸姑伯叔 猶子比兒  " + "孔懷兄弟 同氣連枝  " + "交友投分 切磨箴規  " + 
					"仁慈隱惻 造次弗離  " + "節義廉退 顚沛匪虧  " + "性靜情逸 心動神疲  " + 
					"守眞志滿 逐物意移  " + "堅持雅操 好爵自縻  " + "都邑華夏 東西二京  " + 
					"背邙面洛 浮渭據涇  " + "宮殿盤鬱 樓觀飛驚  " + "圖寫禽獸 畵采仙靈  " + 
					"丙舍傍啓 甲帳對楹  " + "肆筵設席 鼓瑟吹笙  " + "陞階納陛 弁轉疑星  " + 
					"右通廣內 左達承明  " + "旣集墳典 亦聚群英  " + "杜稿鍾隸 漆書壁經  " + 
					"府羅將相 路夾槐卿  " + "戶封八縣 家給千兵  " + "高冠陪輦 驅轂振纓  " + 
					"世祿侈富 車駕肥輕  " + "策功茂實 勒碑刻銘  " + "磻溪伊尹 佐時阿衡  " + 
					"奄宅曲阜 微旦孰營  " + "桓公匡合 濟弱扶傾  " + "綺回漢惠 說感武丁  " + 
					"俊乂密勿 多士寔寧  " + "晉楚更覇 趙魏困橫  " + "假途滅虢 踐土會盟  " + 
					"何遵約法 韓弊煩刑  " + "起翦頗牧 用軍最精  " + "宣威沙漠 馳譽丹靑  " + 
					"九州禹跡 百郡秦幷  " + "嶽宗恒岱 禪主雲亭  " + "雁門紫塞 鷄田赤城  " + 
					"昆池碣石 鉅野洞庭  " + "曠遠綿邈 巖峀杳冥  " + "治本於農 務玆稼穡  " + 
					"俶載南畝 我藝黍稷  " + "稅熟貢新 勸賞黜陟  " + "孟軻敦素 史魚秉直  " + 
					"庶幾中庸 勞謙謹勅  " + "聆音察理 鑑貌辨色  " + "貽厥嘉猷 勉其祗植  " + 
					"省躬譏誡 寵增抗極  " + "殆辱近恥 林皐幸卽  " + "兩疏見機 解組誰逼  " + 
					"索居閑處 沈黙寂寥  " + "求古尋論 散慮逍遙  " + "欣奏累遣 慼謝歡招  " + 
					"渠荷的歷 園莽抽條  " + "枇杷晚翠 梧桐早凋  " + "陳根委翳 落葉飄颻  " + 
					"遊鵾獨運 凌摩絳霄  " + "耽讀翫市 寓目囊箱  " + "易輶攸畏 屬耳垣牆  " + 
					"具膳飱飯 適口充腸  " + "飽飫烹宰 饑厭糟糠  " + "親戚故舊 老少異糧  " +
					"妾御績紡 侍巾帷房  " + "紈扇圓潔 銀燭煒煌  " + "晝眠夕寐 藍筍象床  " + 
					"弦歌酒讌 接杯擧觴  " + "矯手頓足 悅豫且康  " + "嫡後嗣續 祭祀蒸嘗  " + 
					"稽顙再拜 悚懼恐惶  " + "牋牒簡要 顧答審詳  " + "骸垢想浴 執熱願涼  " + 
					"驢騾犢特 駭躍超驤  " + "誅斬賊盜 捕獲叛亡  " + "布射僚丸 嵇琴阮嘯  " + 
					"恬筆倫紙 鈞巧任釣  " + "釋紛利俗 竝皆佳妙  " + "毛施淑姿 工顰姸笑  " + 
					"年矢每催 曦暉朗耀  " + "璇璣懸斡 晦魄環照  " + "指薪修祐 永綏吉劭  " + 
					"矩步引領 俯仰廊廟  " + "束帶矜莊 徘徊瞻眺  " + "孤陋寡聞 愚蒙等誚  " + 
					"謂語助者 焉哉乎也  ";
	private String cheonjayinex= "천지현황 우주홍황  " + "일월영측 진수렬장  " + "한래서왕 추수동장  " + "윤여성세 율여조양  " + 
								"운등치우 로결위상  " + "금생려수 옥출곤강  " + "검호거궐 주칭야광  " + "과진리내 채중개강  " + 
								"해함하담 인잠우상  " + "용사화제 조관인황  " + "시제문자 내복의상  " + "추위양국 유우도당  " + 
								"조민벌죄 주발은탕  " + "좌조문도 수공평장  " + "애육려수 신복융강  " + "하이일체 솔빈귀왕  " + 
								"명봉재수 백구식장  " + "화피초목 뇌급만방  " + "개차신발 사대오상  " + "공유국양 기감훼상  " + 
								"녀모정렬 남효재량  " + "지과필개 득능막망  " + "망담피단 미시기장  " + "신사가복 기욕난량  " + 
								"묵비사염 시찬고양  " + "경행유현 극념작성  " + "덕건명립 형단표정  " + "공곡전성 허당습청  " + 
								"화인악적 복연선경  " + "척벽비보 촌음시경  " + "자부사군 왈엄여경  " + "효당갈력 충칙진명  " + 
								"임심리박 숙흥온청  " + "사란사형 여송지성  " + "천유불식 연징취영  " + "용지약사 언사안정  " + 
								"독초성미 신종의영  " + "영업소기 적심무경  " + "학우등사 섭직종정  " + "존이감당 거이익영  " + 
								"악수귀천 례별존비  " + "상화하목 부창부수  " + "외수부훈 입봉모의  " + "제고백숙 유자비아  " + 
								"공회형제 동기연지  " + "교우투분 절마잠규  " + "인자은측 조차불리  " + "절의렴퇴 전패비휴  " + 
								"성정정일 심동신피  " + "수진지만 축물의이  " + "견지아조 호작자미  " + "도읍화하 동서이경  " + 
								"배망면락 부위거경  " + "궁전반울 루관비경  " + "도사금수 화채선령  " + "병사방계 갑장대영  " + 
								"사연설석 고슬취생  " + "승계납폐 변전의성  " + "우통광내 좌달승명  " + "기집분전 역취군영  " + 
								"두고종예 칠서벽경  " + "부라장상 로협괴경  " + "호봉팔현 가급천병  " + "고관배련 구곡진영  " + 
								"세록치부 거가비경  " + "책공무실 륵비각명  " + "반계이윤 좌시아형  " + "엄택곡부 미단숙영  " + 
								"환공광합 제약부경  " + "기회한혜 열감무정  " + "준예밀물 다사식영  " + "진초갱패 조위곤횡  " + 
								"가도멸괵 천토회맹  " + "하준약법 한폐번형  " + "기전파목 용군최정  " + "선위사막 치예단청  " + 
								"구주우적 백군진병  " + "악종항대 선주운정  " + "안문자색 계전적성  " + "곤지갈석 거야동정  " + 
								"광원면막 암수묘명  " + "치본어농 무자가색  " + "숙재남무 아예서직  " + "세숙공신 권상출척  " + 
								"맹가돈소 사어병직  " + "서기중용 로겸근칙  " + "령음찰리 감모변색  " + "이궐가유 면기지식  " + 
								"성궁기계 총증항극  " + "태욕근치 림고행즉  " + "양소견기 해조수핍  " + "색거한처 침묵적요  " + 
								"구고심론 산려소요  " + "흔주누견 척사환초  " + "거하적력 원망추조  " + "비파만취 오동조조  " + 
								"진근위예 락엽표요  " + "유곤독운 릉마강소  " + "탐독완시 우목낭상  " + "이유유외 속이원장  " + 
								"구선손반 적구충장  " + "포어팽재 기염조강  " + "친척고구 로소이량  " + "첩어적방 시건유방  " + 
								"환선원결 은촉위황  " + "주면석매 람순상상  " + "현가주연 접배거상  " + "교수돈족 열예차강  " + 
								"적후사속 제사증상  " + "계상재배 송구공황  " + "전첩간요 고답심상  " + "해구상욕 집열원량  " + 
								"려라독특 해약초양  " + "주참적도 포획반망  " + "포사료환 혜금완소  " + "념필륜지 균교임조  " + 
								"석분리속 병개가묘  " + "모시숙자 공빈연소  " + "년시매최 희휘랑요  " + "선기현알 회백환조  " + 
								"지신수우 영수길소  " + "구보인령 부앙랑묘  " + "속대긍장 배회첨조  " + "고루과문 우몽등초  " + 
								"위어조자 언재호야";
	private ArrayList<Character> cheonja= new ArrayList<Character>();
	private ArrayList<Character> cheonjayin= new ArrayList<Character>();
	private HashMap<String,String> wordmean= new HashMap<String,String>();
	private HashMap<String,String> sentmean= new HashMap<String,String>();
	private String sentword=null;
	private String sentyin=null;
	private ArrayList<Integer> a= new ArrayList<Integer>();
	
	Thousand(){
		insert();
	}
	
	public void insert() {
		for(int i=0; i<cheonex.length(); i++) {
			if(cheonex.charAt(i)!=' ') {
				cheonja.add(cheonex.charAt(i));
			}
		}
		for(int i=0;i<cheonjayinex.length(); i++) {
			if(cheonjayinex.charAt(i)!=' ') {
				cheonjayin.add(cheonjayinex.charAt(i));
			}
		}

	}
	public void prt() {
		Scanner in=new Scanner(System.in);
		System.out.println("전체보기는 40개씩 끊어서 나옵니다");
		int a=0;
		for(int j=0; j<50; j++) {
			for(int i=0; i<40; i++) {
				if(j%2==0) {
					System.out.print(cheonja.get(40*a+i));
					if(i%4==3) {
						System.out.print("\t");
					}
				}else {
					System.out.print(cheonjayin.get(40*a+i));
					if(i%4==3) {
						System.out.print("\t");
					}
				}
			}
			System.out.println();	
			if(j%2==1) {
			a++;
			}
		}	
	}
	
	public void wordprt(int r) {
		if(r==0) {
			Scanner in=new Scanner(System.in);
			System.out.println("출력하고 싶은 단어 번호를 입력해 주세요\n(1~1000)");
			int a=in.nextInt()-1;
			in.nextLine();
			System.out.println("단어: "+cheonja.get(a)+" 음: "+cheonjayin.get(a));
		}else if(r==1) {
			Random rum=new Random();
			a=new ArrayList<Integer>();
			for(int i=0; i<10; i++) {
				a.add(rum.nextInt(1000));	
			}
			for(int j=0; j<2; j++) {
				for(int i=0; i<10; i++) {
					if(j==0) {
						System.out.print(cheonja.get(a.get(i)));
						System.out.print("\t");
					}else {
						System.out.print(cheonjayin.get(a.get(i)));
						System.out.print("\t");
					}
				}
				System.out.println();
			}
		}
		
	}
	
	public void sentprt(int c) {
		Scanner in=new Scanner(System.in);
		if(c==0) {
			System.out.println("출력하고 싶은 문장 번호를 입력해 주세요\n(1~125)");
			int b=in.nextInt()-1;
			in.nextLine();
			for(int j=0; j<2; j++) {
				for(int i=0; i<8; i++) {
					if(j==0) {
						System.out.print(cheonja.get(8*b+i));
						if(i==3) {
							System.out.print(" ");
							System.out.println("\t");
						}
					}else {
						System.out.print(cheonjayin.get(8*b+i));
						if(i==3) {
							System.out.print(" ");
							System.out.println("\t");
						}
					}
				}
				System.out.println();
			}
		}else if(c==1) {
			Random rum=new Random();
			sentword="";
			sentyin="";
			int b=rum.nextInt(125);
			for(int j=0; j<2; j++) {
				for(int i=0; i<8; i++) {
					if(j==0) {
						System.out.print(cheonja.get(8*b+i));
						sentword+=cheonja.get(8*b+i);
						if(i==3) {
							System.out.print(" ");
							sentword+=" ";
						}
					}else {
						System.out.print(cheonjayin.get(8*b+i));
						sentyin+=cheonjayin.get(8*b+i);
						if(i==3) {
							System.out.print(" ");
							sentyin+=" ";
						}
					}
				}
				System.out.println();
			}
		}
	}

	public void setmean(int b) {
		Scanner in = new Scanner(System.in);
		if(b==1) {
			for(int i=0; i<10; i++) {
				System.out.println((i+1)+"번째  입력");
				String mean=in.nextLine();
				wordmean.put(cheonja.get(a.get(i))+" "+cheonjayin.get(a.get(i)), mean);
			}
		}else if(b==2) {
			System.out.println("뜻을 입력하세요");
			String mean=in.nextLine();
			sentmean.put(sentword+" "+sentyin, mean);
		}
		
		
	}

	
	public void meanprt(int a) {
		if(a==1) {
			int space=0;
			for(String key: wordmean.keySet()) {
				String value=wordmean.get(key);
				System.out.print(key+":"+value+"  ");
				space++;
				if(space%10==0&&space!=0) {
					System.out.println();
				}
			}
			System.out.println();
		}else if(a==2) {
			for(String key: sentmean.keySet()) {
				String value=sentmean.get(key);
				System.out.println(key+":"+value+"  ");
				
			}
			
		}
	}
	
	public void modmean(String key, String value) {
		int f=0;
		for(String k2:wordmean.keySet()) {
			if(key.equals(k2)) {
				wordmean.replace(key, value);
				f++;
				System.out.println("등록완료");
			}
		}
		for(String k2:sentmean.keySet()) {
			if(key.equals(k2)) {
				sentmean.replace(key, value);
				f++;
				System.out.println("등록완료");
			}
		}
		if(f==0) {
			System.out.println("해당 단어나 문장이 없음");
		}
	}
	public ArrayList<Character> getCheonja(){
		return cheonja;
	}
	public ArrayList<Character> getCheonjayin(){
		return cheonjayin;
	}
}

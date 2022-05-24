
public class Rank {
	
	public void rank() {
	int[] arr = {};
	int[] rank = {1,1,1,1,1};
	
	for (int i = 0; i < rank.length; i++) {
		for (int j = 0; j < arr.length; j++) {
			if(arr[i]<arr[j]) {
				rank[i]++;
			}
		}
	}
	System.out.println("[랭킹]");
	int[] index= new int[rank.length];
	for (int i = 0; i < rank.length; i++) {
		index[rank[i]-1] = i;
	}
	for (int i = 0; i < rank.length; i++) {
		int a = index[i];
		System.out.println(rank[a]+"등"+"\t"+arr[a]);
	}
	
	String[] a1 = {
			"요구하다","technology","individual","공급하다",
			"object","employ","attitude","improve","demand",
			"recognize","opportunity","professional","biology",
			"영향, 세력","즉시, 당면한","원료, 인물 물질적인 구체적인 육체의",
			"허락 / 허가증","유리 우월 / 이롭게 하다","지역, 지방, 범위, 분야",
			"주장하다, 강요하다","결론짓다, 체결하다","용어, 말투, 기간, 학기",
			"접근하다 / 접근","간절히 바라다 / 욕구, 욕망","감소하다, 축소하다",
			"연료 / 연료를 공급하다","설득, 신념, 유죄판결","차지하다, 거주하다",
			"유효한, 유능한, 효율적인","논쟁, 발행 부수 / 유출하다, 발행하다",
			"설명하다, 책임지다 / 설명, 이유, 중요성, 계산, 회계, 은행계좌",
			"secretary","굳은, 확고한 / 회사","단지, 그저",
			"복잡한, 합성의 / 합성물질, (아파트)단지, 강박관념",
			"audience","구하다, 경감하다",
			"대학의, 학원의, 학구적인 / 교수, 학회원","공포, 혐오",
			"위협, 협박","순수한, 결백한","분위기, 기분, 변덕",
			"소비하다","폭발시키다","찬성하다, 승인하다, 입증하다",
			"안정된, 진지한 / 받침대","도덕적인, 교훈적인, 순결한",
			"psychology","조수, 계절 / 조수를 타고 흐르다",
			"안정된, 확고한 / 안전하게 하다, 보증하다",
			"증인, 증거 / 목격하다, 증언하다","감소하다 / 감소",
			"약속, 보증, 보증인, 출연료 / 다짐하다, 보증하다",
			"shadow","좌절시키다, 방해하다","pupil",
			"여가, 틈, 자유시간 / 한가한","괴롭히다, 성가시게 굴다",
			"분배 몫, 1인분, 일부 / 분배하다","고객, 단골 손님",
			"전문가 / 전문적 조언을 하다","묘사하다, 서술하다",
			"의무, 직책, 세금","정의를 내리다, 한정하다, 밝히다",
			"긍정적인, 적극적인, 명확한 / 긍정, (수학) 양수, (전기) 양극",
			"참가하다, 관계하다","average","널리 알리다, 출판하다",
			"세부사항","소설 / 새로운, 진기한","반대하다, 대립하다",
			"기쁨 / 기쁘게 하다","본질적인, 필수적인","간결한, 잠깐의 / 개요",
			"의도하다, ～할 작정이다","놀라게 하다",
			"균형, 조화, 저울, (회계) 차액 / 균형을 잡다, 저울로 달다",
			"격렬한, 난폭한","정리하다, 준비하다, 각색·편곡하다",
			"부족, 결핍 / 모자라다","싸우다, 애쓰다","신뢰하다, 의지하다",
			"혁명, 회전, 공전",
			"요구하다, 주장하다 / 요구, 주장, 지불 청구, 보상 청구",
			"시도하다, 노리다 / 시도","손상시키다, 상처 입히다",
			"중요한, 의미하는","거의 ～하지 않다 / 드물게",
			"허락하다, 인정하다, 받아들이다","인정하다, 승인하다, 주다, 수여하다",
			"당황하게 하다, 방해하다","가로막다, 중단시키다","항아리, 단지",
			"10 개 묶음, 10 년","가장자리, 날, 날카로움 / 날을 세우다",
			"연기하다, 늦추다 / 지연, 연기","가리키다, 나타내다, 지시하다",
			"실수, 과실, 오류","초점, 진원지 / 초점을 맞추다",
			"마음의, 정신의, 지능의 / 정신병 환자"
			};
	String[] a2 = {
			"require","과학기술","개인","provide","물체","고용","태도",
			"개량","요구","인식","기회","전문가","생물학","influence",
			"immediate","material","permit","advantage","region",
			"insist","conclude","term","approach","desire",
			"reduce","fuel","conviction","occupy","efficient",
			"issue","account","비서","firm","merely","complex",
			"청중","relieve","academic","horror","threat","pure",
			"mood","consume","explode","approve","steady",
			"moral","psychology","tide","secure","witness",
			"decrease","guarantee","그림자","frustrate","학생",
			"leisure","annoy","portion","client","expert",
			"describe","duty","define","positive","participate",
			"평균","publish","detail","novel","oppose","delight",
			"essential","brief","intend","amaze","balance",
			"violent","arrange","lack","struggle","rely",
			"revolution","claim","attempt","injure","significant",
			"seldom","admit","grant","embarrass","interrupt",
			"pot","decade","edge","delay","indicate","error",
			"focus","mental"
			};
	
	
	
	
	
	
	
	
}
}
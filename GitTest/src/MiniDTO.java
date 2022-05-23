
public class MiniDTO {
	private String id,name,pw,eng,kor;
	
	

	public MiniDTO(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	public MiniDTO(String id, String pw) {
		this.id = id;
		this.pw=pw;
	}
	public MiniDTO(String id) {
		this.id=id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEng() {
		return eng;
	}
	
	
	
	public void setEng(String eng) {
		this.eng = eng;
	}
	
	
	
	public String getKor() {
		return kor;
	}
	
	
	
	public void setKor(String kor) {
		this.kor = kor;
	}
	
}

class Game extends MiniDTO{

	public Game(String kor, String eng) {
		super(kor, eng);
		// TODO Auto-generated constructor stub
	}
	
}

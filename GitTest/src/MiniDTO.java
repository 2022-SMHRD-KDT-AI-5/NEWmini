
public class MiniDTO {
	private String id,name,pw;
	
	
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
	
	
}

class Game extends MiniDTO{
	
	public Game(String kor, String eng) {
		super(kor, eng);
	}
	
}


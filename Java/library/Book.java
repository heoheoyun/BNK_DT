package Library;

public class Book {
	private String bno;
    private String b_name ;
    private String publish;
    private String author;
    private int cno;
    private boolean in_Library;	// true: 대출가능, false: 대출중
    
	//신규 도서 등록용
    public Book(String bno, String b_name, String publish, String author, int cno) {
		this.bno = bno;
		this.b_name = b_name;
		this.publish = publish;
		this.author = author;
		this.cno = cno;
		in_Library = true;
	}

    // DB 데이터 조회용 ('Y'/'N' -> boolean 변환)
    // status 값이 "Y"이면 true, 아니면 false
    public Book(String bno, String b_name, String publish, String author, int cno, String status) {
        this(bno, b_name, publish, author, cno);
        this.in_Library = "Y".equals(status);// "Y"와 같으면 true, "N"이면 false
    }

	public void setIn_Library(boolean in_Library) {
        this.in_Library = in_Library;
    }
    
    public String getBno() {
		return bno;
	}
    public String getB_name() {
		return b_name;
	}
    public String getPublish() {
		return publish;
	}
    public String getAuthor() {
		return author;
	}
    public int getCno() {
		return cno;
	}
    
    public String getLoanable(){
    	String s = "( 대출 가능 여부 : ";
		if(in_Library) s += " 대출 가능";
		else s += "대출 불가능";
		s += " )";
		return s;
	}
    
    @Override
    public String toString() {
    	return "[ 책번호 : " + bno +" ] [ 책이름 : " + b_name +" ] [ 저자 : " + author + "] [ 출판사 : " + publish + " ]";
    }
}

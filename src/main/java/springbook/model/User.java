package springbook.model;

import springbook.chapter5.Level;

public class User {
	private int deptno;
	private String dname;
	private String loc;
	Level level;
	int login;
	int recommend;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public User(int deptno, String dname, String loc, Level level, int login, int recommend) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.level = level;
		this.login = login;
		this.recommend = recommend;
	}

	public User(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public User() {

	}

}
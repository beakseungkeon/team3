package team3_Project1.model.vo;

import lombok.Data;

@Data
public class Member {
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_email;
	private String me_admin;
	
	public Member(String me_id, String me_pw, String me_name, String me_email) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_name = me_name;
		this.me_email = me_email;
	}
}

package community.model.vo;

import java.util.Objects;


import lombok.Data;


@Data

public class MemberVO {
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private int authority;
	public MemberVO(String id, String pw, String email,String nickname) {
		this.id=id;
		this.pw=pw;
		this.email=email;
		this.nickname=nickname;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(pw, other.pw);
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", email=" + email + ", authority="
				+ authority + "]";
	}
	
}

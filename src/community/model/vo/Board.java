package community.model.vo;

import lombok.Data;

@Data
public class Board {
	private String title;
	private String ca_title;
	public Board(String title) {
		this.title=title;
	}
	public Board(String title, String ca_title) {
		this.title=title;
		this.ca_title=ca_title;
	}
}

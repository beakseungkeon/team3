package community.model.vo;

import lombok.Data;

@Data
public class Category {
	private String title;
	public Category(String title) {
		this.title=title;
	}

}

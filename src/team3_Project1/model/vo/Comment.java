package team3_Project1.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private int co_num;
	private String co_content;
	private int co_po_num;
	private String co_me_id;
	public Comment(String co_content, int co_po_num, String co_me_id) {
		super();
		this.co_content = co_content;
		this.co_po_num = co_po_num;
		this.co_me_id = co_me_id;
	}
}

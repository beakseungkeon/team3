package community.model.vo;

import lombok.Data;

@Data
public class post {
	public post(String po_content, String po_title) {
		this.po_content=po_content;
		this.po_title=po_title;
	}
	private String po_content;
	private String po_title;
	private int view;
	private String me_id;
	private int bo_num;
	private String me_name;
	
	
}

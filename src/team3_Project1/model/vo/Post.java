package team3_Project1.model.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
	private int po_num;
	private String po_content;
	private String po_title;
	private int po_view;
	private String po_me_id;
	private int po_bo_num;
	private String po_me_name;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return po_num == other.po_num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(po_num);
	}
	public Post(int po_num) {
		super();
		this.po_num = po_num;
	}
	public Post(String po_content, String po_title, String po_me_id, int po_bo_num, String po_me_name) {
		super();
		this.po_content = po_content;
		this.po_title = po_title;
		this.po_me_id = po_me_id;
		this.po_bo_num = po_bo_num;
		this.po_me_name = po_me_name;
	}
	
}

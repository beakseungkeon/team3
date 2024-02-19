package team3_Project1.model.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
	private int bo_num;
	private String bo_title;
	private String bo_ca_title;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return bo_num == other.bo_num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bo_num);
	}
	public Board(int bo_num) {
		super();
		this.bo_num = bo_num;
	}
	public Board(String bo_title, String bo_ca_title) {
		super();
		this.bo_title = bo_title;
		this.bo_ca_title = bo_ca_title;
	}
	
}

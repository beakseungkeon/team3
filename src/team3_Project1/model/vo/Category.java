package team3_Project1.model.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Category {
	private String ca_title;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(ca_title, other.ca_title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ca_title);
	}

	public Category(String ca_title) {
		super();
		this.ca_title = ca_title;
	}
}

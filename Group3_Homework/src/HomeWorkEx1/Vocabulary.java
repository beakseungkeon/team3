package HomeWorkEx1;

import java.util.ArrayList;
import java.util.Objects;
import lombok.Data;

//단어, 뜻, 품사
@Data
public class Vocabulary {
	
	String word, partOfSpeach;
	ArrayList<String> mean = new ArrayList<String>();
	int viewNum;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vocabulary other = (Vocabulary) obj;
		return Objects.equals(word, other.word);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(word);
	}

	public Vocabulary(String word, String partOfSpeach, ArrayList<String> mean, int viewNum) {
		this.word = word;
		this.partOfSpeach = partOfSpeach;
		this.mean = mean;
		this.viewNum = viewNum;
	}
	
	public Vocabulary(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "단어 : " + word + ",  품사 : " + partOfSpeach + ",  뜻 : " + mean+"  조회수 : " + viewNum+"\n";
	}
}

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Lexicon {
	
	public Lexicon(String[] words) {
		mdag = new MDAG(Arrays.asList(words));
	}
	
	public Lexicon(String filePath) throws IOException {
		mdag = new MDAG(new File(filePath));
	}
	
	public boolean containsWord(String s) {
		return mdag.contains(s);
	}
	
	public boolean containsPrefix(String s) {
		return mdag.prefixExists(s);
	}
	
	private MDAG mdag;
}

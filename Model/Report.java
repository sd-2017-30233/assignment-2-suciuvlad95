package Model;

import java.util.ArrayList;
import java.io.FileNotFoundException;

public interface Report {
	void generate(ArrayList<String> titles) throws FileNotFoundException;
}

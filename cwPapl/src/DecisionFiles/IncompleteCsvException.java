package DecisionFiles;

import java.io.FileNotFoundException;

public class IncompleteCsvException extends FileNotFoundException {

    public IncompleteCsvException(String s){
        super(s);
    }
}

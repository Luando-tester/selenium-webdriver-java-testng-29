package selenium.javatester;

import java.util.ArrayList;
import java.util.List;

public class Topic_15_Generic {

    public static void main(String[] args){
        //List chi chua kieu du lieu
        List<String> student = new ArrayList<String>();
        student.add("John");
        student.add("Mary");
        student.add("Peter");
        student.add("Nam");

        //non-Generic
        List addresses =  new ArrayList<>();
        addresses.add("123 Main St.");//String
        addresses.add(15);//Interger
        addresses.add(true);//Boolean
        addresses.add(15.56);// Float
    }
}

package selenium.javatester;

public class Topic_07_String {

    public static void main (String[] args){
        String firstName = "Automation";
        String latsName = "FC";

        String fullName = firstName + "" + latsName;
        System.out.println(fullName);

        fullName = firstName.concat(" ").concat(latsName);
        System.out.println(fullName);

        String hotelMSG ="Welcome" + fullName + "to InterContinal Hotel";

        System.out.println(hotelMSG);
    }

}

package selenium.javatester;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

public class Topic_08_Parameter {
    static String fullNameGlobal = "Automation Testing";
    static String firstName = "Testing";
    public static void main (String[] args) {
        Topic_08_Parameter topic = new Topic_08_Parameter();
        System.out.println(getFullName());
        setFullName("Manual Testing");

        System.out.println(getFullName());

        System.out.println(fullNameGlobal);

        System.out.println(firstName);

        topic.setFullName("Manual Testing");

        System.out.println(topic.getFullName());


    }
    public static void setFullName(String fullName) {
        fullNameGlobal = fullName;
    }

    public static String getFullName(){
        return fullNameGlobal;
    }

}

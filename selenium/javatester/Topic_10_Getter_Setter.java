package selenium.javatester;

public class Topic_10_Getter_Setter {

    private String fullName;

    public void testGetterSetter(){
        setFullName("Automation Testing");
        System.out.println(fullName);

        setFullName("Manual Testing");
        System.out.println(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }




}

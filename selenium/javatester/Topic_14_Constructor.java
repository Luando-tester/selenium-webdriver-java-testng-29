package selenium.javatester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_14_Constructor {

    public Topic_14_Constructor(String name){
        System.out.println(name);
    }
     public Topic_14_Constructor(int numberStudent){
         System.out.println(numberStudent);
     }

    public Topic_14_Constructor(String name,int numberStudent){
        System.out.println(numberStudent);
    }
     public static void main(String[] args){
        Topic_14_Constructor topic01 = new Topic_14_Constructor("Automation FC");
        Topic_14_Constructor topic02 = new Topic_14_Constructor(15);
        Topic_14_Constructor topic03 = new Topic_14_Constructor("Automation",15);
     }
}

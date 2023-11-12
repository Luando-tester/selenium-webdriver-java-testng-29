package selenium.javatester;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_11_List {

    @Test
    public void testList(){
        // Arraylist - truy xuất dữ liệu(query)
        // LinkListed -Thêm sửa xóa
        List<String> studentName = new ArrayList<String>();
        studentName.add(("Nguyễn Đình Lương"));
        studentName.add(("Hoàng Văn Nam"));
        studentName.add(("Nguyễn Ánh Hồng"));

        System.out.println(studentName.size());
        System.out.println(studentName.get(0));
        System.out.println(studentName.get(1));
        System.out.println(studentName.get(2));
        System.out.println(studentName.get(3));



    }





}

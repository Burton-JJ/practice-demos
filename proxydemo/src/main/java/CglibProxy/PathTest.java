package CglibProxy;

import java.io.File;
import java.io.IOException;

public class PathTest {
    public static void main(String[] args) throws IOException {
        System.out.println("----------------");
        System.out.println( System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.dir"));

        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath() ;
        System.out.println(courseFile);

        File f = new File(PathTest.class.getResource("/").getPath());
        System.out.println(f);

        File f3 = new File(PathTest.class.getResource("").getPath());
        System.out.println(f3);

        File f2 = new File(PathTest.class.getResource("PathTest.class").getPath());
        System.out.println(f2);

        File faa = new File(".");
        faa.getCanonicalPath(); //得到的是C:/test
        faa.getAbsolutePath();    //得到的是C:/test/.
        faa.getPath();





    }
}

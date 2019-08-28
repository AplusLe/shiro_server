package aplus.four_a.shiro_server;

import aplus.four_a.shiro_server.common.Fileserver;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    Fileserver fileserver;

    @Test
    public void test1() {
        //
        File file1 = new File("C:\\Users\\kevinboli\\Desktop\\导入-业务单.xlsx");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file1);
            MultipartFile file = new MockMultipartFile(file1.getName(), file1.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
            fileserver.upload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws InterruptedException {
        Thread threadA = new Thread();
        threadA.join();
    }

}

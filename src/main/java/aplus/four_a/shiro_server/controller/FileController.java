package aplus.four_a.shiro_server.controller;

import aplus.four_a.shiro_server.common.Fileserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @packae aplus.four_a.shiro_server.controller
 * @auther Kevin
 * @date 24/07/2019 16:30
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    Fileserver fileserver;

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        ResponseEntity entity = fileserver.upload(file);
        HttpStatus statusCode = entity.getStatusCode();
        statusCode.getReasonPhrase();
        return "";
    }
}

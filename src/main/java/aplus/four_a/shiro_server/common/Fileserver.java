package aplus.four_a.shiro_server.common;

import aplus.four_a.shiro_server.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务调用客户端
 *
 * @packae aplus.four_a.shiro_server.common
 * @auther Kevin
 * @date 24/07/2019 10:39
 */
@FeignClient(value = "FILE-SERVICE", path = "/file/info", configuration = MultipartSupportConfig.class)
public interface Fileserver {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity upload(@RequestPart("file") MultipartFile file);
}

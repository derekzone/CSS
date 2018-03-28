package com.derek.controller.api;

import com.derek.annotation.Log;
import com.derek.model.User;
import com.derek.model.response.BaseResponse;
import com.derek.service.StorageService;
import com.derek.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/25 11:47
 */
@Controller
@RequestMapping("/api")
public class UploadApiController {
    private final static Logger logger = LoggerFactory.getLogger(UploadApiController.class);

    @Autowired
    private StorageService storageService;

    @RequestMapping("/upload")
    @ResponseBody
    @Log
    public BaseResponse upload(final HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getType() != 2) {
            return BaseResponse.fail("请重新登陆");
        }
        logger.info("用户:" + user.getUsername() + "上传文件");
        //TODO 文件删除替换逻辑
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1); // 文件后缀
        String fileName = FileUtils.genFileName(suffix);
        storageService.store(file, fileName);
        return BaseResponse.success("/files/image/" + fileName);
    }
}

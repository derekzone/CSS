package com.derek.controller.api;

import com.derek.model.response.BaseResponse;
import com.derek.service.StorageService;
import com.derek.util.FileUtils;
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

    @Autowired
    private StorageService storageService;

    @RequestMapping("/upload")
    @ResponseBody
    public BaseResponse upload(final HttpServletRequest request, @RequestParam("file") MultipartFile file, HttpSession httpSession) {

        //TODO log
        // TODO 统一做异常处理的切面
        //TODO 文件删除替换逻辑
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1); // 文件后缀
        String fileName = FileUtils.genFileName(suffix);
        storageService.store(file, fileName);
        return BaseResponse.success("/files/image/" + fileName);
    }
}

package com.derek.service.impl;

import com.derek.service.FileService;
import com.derek.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author Derek
 * @date 2018/3/25 22:33
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void delete(String path) {
        //TODO log
        //TODO 在controller那一层统一做异常处理的切面
        File file = new File(path);
        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }


//    @Override
//    public String save(MultipartFile file, String parentPath) {
//        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); // 文件后缀
//        String fileName = FileUtils.genFileName(suffix);
//        File targetFile = new File(parentPath, fileName);
//        //TODO 将异常进一步封装抛出，在异常处理切面统一处理
//        try {
//            file.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return fileName;
//    }

    @Override
    public String save(MultipartFile file) {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); // 文件后缀
        String fileName = FileUtils.genFileName(suffix);
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(fileName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
//                return "上传失败," + e.getMessage();
                //TODO throw exception message
            } catch (IOException e) {
                e.printStackTrace();
//                return "上传失败," + e.getMessage();
                //TODO throw exception message
            }
        } else {
//            return "上传失败，因为文件是空的.";
            //TODO throw exception message
        }
        return fileName;
    }
}

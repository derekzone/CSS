package com.derek.controller;

import com.derek.model.Content;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:32
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/")
    public String index(ModelMap modelMap, HttpSession httpSession, @RequestParam(value = "type", required = false) Integer type) {


        List<Content> contentList = contentService.getAll();
        modelMap.addAttribute("contentList", contentList);


//        System.out.println("httpSession in indexController: " + httpSession.getAttribute("user"));
//        User loginUser = (User) httpSession.getAttribute("user");
//        List<Content> contentList = contentService.getAll();
////        if( contentList != null ){
////            StringUtil.fileNum = contentList.get(contentList.size()-1).getId()+1;//设置文件上传时使用的编号
////        }
//        List<Product> productList;
//
//        if (type == null) type = 0;
//
//        httpSession.setAttribute("listType", type);
//
//        if (loginUser == null) {
////            modelMap.addAttribute("productList", contentList);
//            httpSession.setAttribute("productList", contentList);
//        } else {
//            httpSession.removeAttribute("productList");
////            modelMap.remove("productList");
//            System.out.println("In IndexC LoginUser: " + loginUser);
//            productList = productService.getProductList(loginUser);
//
//            if (type.equals(1)) {
//                for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext(); ) {
//                    Product product = iterator.next();
//                    if (product.getIsBuy()) {//已购买内容删除
//                        iterator.remove();
//                    }
//                }
//            }
////            modelMap.addAttribute("productList", productList);
//            httpSession.setAttribute("productList", productList);
//        }
////        System.out.println("modelMap.get(\"productList\"): "+modelMap.get("productList"));
//        System.out.println("httpSession productList: " + httpSession.getAttribute("productList"));
        return "index";
    }
}

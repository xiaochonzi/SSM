package com.xiaochonzi.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by stone on 17/6/6.
 */
@Controller
public class FileUploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdir();
            }
            File newFile = new File(path+File.separator+filename);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(newFile.length()>0){
                return "上传成功";
            }
        }
        return "上传失败！";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename")String filename, Model model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachement",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

}

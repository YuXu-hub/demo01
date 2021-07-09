package com.yx.menu.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

public class FileUploadUtil {


    //url上传路径
    public static String uploadFile(MultipartFile file, String url){
        //获取文件名称
        String filename = file.getOriginalFilename();
        //得到一个uuid随机的字符串
        String uuid = UUID.randomUUID().toString();
        //uuid和文件的后缀名称拼接得到一个新的文件名称
        String newFileName = uuid+filename.substring(filename.lastIndexOf("."));
        //根据需要上传的路径创建一个文件
        File f1 = new File(url);
        //判断文件是否存在
        if(!f1.exists()){
            System.out.println("文件夹不存在，需要创建");
            //mkdirs创建多级文件夹
            f1.mkdirs();
        }
        //根据文件夹和新的文件拼接成一个新的文件
        String fileUrl = url+"/"+newFileName;
        File f = new File(fileUrl);
        try{
            //将源文件拷贝到目标文件中
            file.transferTo(f);
        }catch (Exception e){
            e.printStackTrace();
        }
        //uuid和文件的后缀名称拼接得到一个新的文件名称
        return newFileName;
    }


    public static ResponseEntity downloadFile(String url,String fileName){
        try{
            FileInputStream inputStream = new FileInputStream(url + "/" + fileName);
           // int available = inputStream.available();
            byte[] buff=new byte[inputStream.available()];
            inputStream.read(buff);
            //
            fileName=new String(fileName.getBytes("gbk"),"iso-8859-1");
            HttpHeaders headers=new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename="+fileName);
            HttpStatus statusCode=HttpStatus.OK;
            ResponseEntity<byte[]> responseEntity=new ResponseEntity<>(buff,headers,statusCode);
            return responseEntity;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

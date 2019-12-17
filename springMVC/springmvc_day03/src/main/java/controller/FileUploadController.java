package controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {


    @RequestMapping("/upLoad1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传中......");
        // 使用文件fileupload组件完成上传
        // 上传到文件的位置
       String path= request.getSession().getServletContext().getRealPath("uploads/");
       // 判断当前文件路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdir();
        }
        // 解析文件项，并过去
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

        // 解析request
       List<FileItem> fileList= fileUpload.parseRequest(request);
       for(FileItem fileItem:fileList){
           // 上传的文件类型判断
               // 说明是上传文件项
              String fileName =fileItem.getName();

               String uuid=UUID.randomUUID().toString().replace("-","");
              fileName=uuid+"_"+fileName;
              // 完成文件的上传
               fileItem.write(new File(path,fileName));
               // 删除临时文件
               fileItem.delete();
               System.out.println("上传成功了....");
               System.out.println("文件名:"+fileName);
           }
        return "success";
    }

    /**
     * springmvc 文件上传
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/upLoad2")
    public String fileUpload2(HttpServletRequest request,MultipartFile upload) throws Exception {
        System.out.println("文件上传中......");
        // 使用文件fileupload组件完成上传
        // 上传到文件的位置
        String path= request.getSession().getServletContext().getRealPath("uploads/");
        // 判断当前文件路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdir();
        }
        //获取上传的文件名称
        String fileName = upload.getOriginalFilename();
        // 生成唯一 名字
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName=uuid+fileName;
        // 调用上传文件的方法就可以直接的上传了
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    @RequestMapping("/upLoad3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传中......");
        // 定义上传文件服务器的路径
        String path ="http://localhost:9000/uploads/";
        //获取上传的文件名称
        String fileName = upload.getOriginalFilename();
        // 生成唯一 名字
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器建立连接
        WebResource webResource =client.resource(path+fileName);
        //上传文件
        webResource.put(upload.getBytes());
        System.out.println("文件上传成功...");

        return "success";
    }

}

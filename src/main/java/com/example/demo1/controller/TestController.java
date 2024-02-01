package com.example.demo1.controller;

import com.example.demo1.Vo.ResponseObjectForCaching;
import com.example.demo1.service.CacheTestService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import static com.example.demo1.service.CacheTestService.prefixMap;

@RestController
@CrossOrigin
@RequestMapping("/demo")
public class TestController {

    @Autowired
    private Environment env;

    @Autowired
    private CacheTestService cacheTestService;

    @GetMapping("/combinedPdf")
    public ResponseEntity<Boolean> getCombinedPdf(@RequestParam Integer pageSize) throws IOException {
        PDDocument pdDocument=new PDDocument();
        for(int i=0;i<pageSize;i++){
            System.out.println("Printing page number at "+i);
            PDPage page=new PDPage(PDRectangle.A4);
            pdDocument.addPage(page);
            PDPage currentPage=pdDocument.getPage(pdDocument.getNumberOfPages()-1);
            PDImageXObject image= PDImageXObject.createFromFile("C:/pngwing.com.png",pdDocument);
            PDImageXObject image2= PDImageXObject.createFromFile("C:/test/holiday.jpg",pdDocument);
            PDPageContentStream pdPageContentStream=new PDPageContentStream(pdDocument, currentPage);
            pdPageContentStream.drawImage(image,200,500,300,300);
            pdPageContentStream.drawImage(image2,200,100,200,200);
            pdPageContentStream.close();

        }

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        pdDocument.save(baos);

        FileOutputStream fos=new FileOutputStream(new File("C:/test/demo.pdf"));
        try {
            baos.writeTo(fos);
        }catch (IOException e){
            System.out.println("Dosya yazımında hata!!");
        }finally {
            fos.close();
        }

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/test")
    public ResponseEntity<Boolean> getCombinedPdf2() throws IOException {

        System.out.println("This is a deneme property: "+env.getProperty("test.deneme"));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Cacheable("endpointCache1")
    @GetMapping("/cacheTest1")
    public ResponseEntity<Object> cacheTest1(@RequestParam String param) throws IOException {
        ResponseObjectForCaching responseObjectForCaching=new ResponseObjectForCaching(cacheTestService.insertIntoCache("cacheTest2",param),
                cacheTestService.insertIntoCache2(param));

        try {
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("Hata oldu");
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseObjectForCaching);
    }

    @Cacheable("endpointCache2")
    @GetMapping("/cacheTest2")
    public ResponseEntity<Object> cacheTest2(@RequestParam String param) throws IOException {
        ResponseObjectForCaching responseObjectForCaching=new ResponseObjectForCaching(cacheTestService.insertIntoCache("cacheTest2",param),
                cacheTestService.insertIntoCache2(param));

        System.out.println(prefixMap);



        return ResponseEntity.status(HttpStatus.OK).body(responseObjectForCaching);
    }



}

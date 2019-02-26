package products;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;

@Controller("/product")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    
    @Inject
    ValidationService validationService;

    @Get("/")
    public HttpStatus index() {
        log.info("Loading sample data");

        return HttpStatus.OK;
    }
    
    @Post(value = "/", consumes = MediaType.MULTIPART_FORM_DATA) 
    public HttpResponse<String> uploadCompleted(CompletedFileUpload file) { 
        try {
            File tempFile = File.createTempFile(file.getFilename(), "temp"); 
            log.info(tempFile.getAbsolutePath());
            Path path = Paths.get(tempFile.getAbsolutePath());
            Files.write(path, file.getBytes()); 
            
            
            validationService.validate(tempFile.getAbsolutePath());
            
            
            
            
            
            return HttpResponse.ok("Uploaded");
        } catch (IOException exception) {
            return HttpResponse.badRequest("Upload Failed");
        }
    }

}
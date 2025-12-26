package ie.atu.onlineshopp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;


@RestController
    @RequestMapping("/api/images")
    @Tag(name = "Image Controller", description = "APIs for managing images")
    public class ImageController {

        @Operation(
                summary = "Upload an image",
                description = """
                        ## Image Upload Process
                        
                        ![Phone Image Example](https://i.pinimg.com/originals/7f/40/d9/7f40d9e7196fb308ee8440bbe0a94141.jpg)
                        *Example: Ishigami Senku
                        """,
                responses = {
                        @ApiResponse(responseCode = "200", description = "Success"),
                        @ApiResponse(responseCode = "400", description = "Invalid format")
                }
        )
        @PostMapping("/upload")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
            // Your Java controller logic here
            return ResponseEntity.ok("Upload successful");
        }
    }


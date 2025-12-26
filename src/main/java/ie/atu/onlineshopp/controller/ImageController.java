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



    @RestController
    @RequestMapping("/api/images")
    @Tag(name = "Image Controller", description = "APIs for managing images")
    public class ImageController
    {

        @Operation(
                summary = "Upload an image",
                description = """
            ## Image Upload Process
            
            ![Upload Flow Diagram](https://i.pinimg.com/originals/fb/11/4a/fb114a6402be9bceeb6a896b7d67d6dc.jpg)
            *Figure 1: Image upload flow*
            
            ### Steps:
            1. Select image file
            2. Validate image format
            3. Upload to server
            4. Generate thumbnail
            
            ### Supported Formats:
            - PNG ![PNG Icon](https://example.com/icons/png.png)
            - JPEG ![JPEG Icon](https://example.com/icons/jpeg.png)
            - GIF ![GIF Icon](https://example.com/icons/gif.png)
            """,
                responses = {
                        @ApiResponse(
                                responseCode = "200",
                                description = "Image uploaded successfully",
                                content = @Content(mediaType = "application/json")
                        ),
                        @ApiResponse(
                                responseCode = "400",
                                description = "Invalid image format"
                        )
                }
        )
        @PostMapping("/upload")
        public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
            // Controller logic
            return ResponseEntity.ok("Image uploaded successfully");
        }
    }


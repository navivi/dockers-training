package com.navivi.training.dockers.api;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/training/dockers")
public class TrainingController {

    @Value("${training.config-message}")
    private String configMessage;

    @Value("${training.files-dir}")
    private String filesDir;

    @GetMapping(value="", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "<html>\n<body>\n"
                + "<h2>Welcome</h2>\n" +
                configMessage
                + "\n</body>\n</html>";
    }

    @GetMapping("files")
    public String listFiles(){
        return  "<html>\n<body>\n"
                + "<h2>Files List:</h2>\n<ul>\n" +
                Stream.of(Objects.requireNonNull(new File(filesDir).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(file -> "<li>"+file.getName()+"</li>")
                .collect(Collectors.joining("\n"))
                + "\n</ul>\n</body>\n</html>";
    }

    @GetMapping(value = "files/{fileName}")
    public ResponseEntity<byte[]> getImageWithMediaType(@PathVariable("fileName") String fileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        Path path = Paths.get(filesDir+"/"+fileName);
        if(!Files.isReadable(path) && !Files.isDirectory(path))
            return new ResponseEntity<>("File not found!!".getBytes(), headers, HttpStatus.NOT_FOUND);

        InputStream in = Files.newInputStream(path);

        if(fileName.toLowerCase().endsWith("jpg") || fileName.toLowerCase().endsWith("jpeg"))
            headers.add(HttpHeaders.CONTENT_TYPE,MediaType.IMAGE_JPEG_VALUE);
        return new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
    }
}
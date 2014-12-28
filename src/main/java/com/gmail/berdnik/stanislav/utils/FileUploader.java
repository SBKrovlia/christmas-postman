package com.gmail.berdnik.stanislav.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Berdniky on 28.12.2014.
 */
@Component
public class FileUploader  implements java.io.Serializable{
    private static final String FOLDER = "D:\\congratulation\\";
    private static final String DOT = ".";

    public String saveFile(String congratulationId, MultipartFile multipartFile, String fileExtension) {
        final String fileName = congratulationId + fileExtension + DOT + fileExtension;
        final String filePath = FOLDER + fileName;

        try {
            final File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        } catch (IOException e) {
             e.printStackTrace();
        }
        return filePath;
    }
}

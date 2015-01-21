package com.gmail.berdnik.stanislav.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Saving files to repository
 *
 * Created by Berdniky on 28.12.2014.
 */
@Component
public class FileUploader  implements java.io.Serializable{
    private static final String FOLDER = "D:\\var";  //todo: get rid of hardcoding
    private static final String DOT = ".";

    public String saveFile(String congratulationId, MultipartFile multipartFile, String fileExtension) throws IOException {
        final String fileName = congratulationId + fileExtension + DOT + fileExtension;
        final String filePath = FOLDER + fileName;
            final File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        return filePath;
    }
}

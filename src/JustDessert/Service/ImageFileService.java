package JustDessert.Service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;

@Service
public class ImageFileService implements IImageFileService{
    //@Transactional
    @Override
    public String saveFile(MultipartFile file, String applicationPath) {
        String filename = null;
        try {
            if (!file.isEmpty()) {
                String artifactPath = applicationPath
                        + "WEB-INF\\resources\\img\\";

                String sourcePath = applicationPath + "..\\..\\..\\"
                        + "web\\WEB-INF\\resources\\img\\";

                filename = file.getOriginalFilename();


                File imageFile = new File(artifactPath, filename);
                file.transferTo(imageFile);

                File copyOfImage = new File(sourcePath, filename);
                FileUtils.copyFile(imageFile, copyOfImage);
            }
        } catch (Exception e) {
        }

        return filename;
    }
}

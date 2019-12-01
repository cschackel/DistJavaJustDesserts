package JustDessert.Service;

import org.springframework.web.multipart.MultipartFile;

public interface IImageFileService {
    String saveFile(MultipartFile file,
                    String applicationPath);
}

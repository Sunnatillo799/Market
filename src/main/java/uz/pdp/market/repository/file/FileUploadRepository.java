package uz.pdp.market.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.market.entity.fileUpload.FileUpload;
import uz.pdp.market.repository.AbstractRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long>, AbstractRepository {
}

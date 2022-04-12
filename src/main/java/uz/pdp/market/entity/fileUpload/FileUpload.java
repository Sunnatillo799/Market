package uz.pdp.market.entity.fileUpload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.base.Auditable;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FileUpload extends Auditable {
    
    private String name;

    private String originalName;

    private Long size;

    private String contentType;
}

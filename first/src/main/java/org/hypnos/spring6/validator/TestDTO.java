package org.hypnos.spring6.validator;

import lombok.Data;
import org.hypnos.spring6.validator.annotation.FileConstraint;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/3-19:33
 */
@Data
@Validated
public class TestDTO {

    @FileConstraint(maxSize = 1024, allowedTypes = {"image/png"})
    private MultipartFile file;

}

package org.hypnos.spring6.validator;

import org.hypnos.spring6.validator.annotation.FileConstraint;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/3-15:34
 */
public class FileValidator implements ConstraintValidator<FileConstraint, MultipartFile> {

    private long maxSize;
    private String[] allowedTypes;

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        if (multipartFile.getSize() > maxSize) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("File too large").addConstraintViolation();
            return false;
        }
        if (!isSupportedContentType(multipartFile.getContentType())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("File type not allowed").addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(FileConstraint constraint) {
        this.maxSize = constraint.maxSize();
        this.allowedTypes = constraint.allowedTypes();
    }

    private boolean isSupportedContentType (String contentType) {
        return allowedTypes.length == 0 || Arrays.asList(allowedTypes).contains(contentType);
    }
}

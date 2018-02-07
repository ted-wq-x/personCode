package com.go2going.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 实际进行校验的类,必须是public方法
 */
public class Temp implements ConstraintValidator<LocationValidation, Location> {

    private LocationValidation locationValidation;
    @Override
    public void initialize(LocationValidation constraintAnnotation) {
        this.locationValidation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Location value, ConstraintValidatorContext context) {

        if (value == null) {
            System.err.println("Default value :" + context.getDefaultConstraintMessageTemplate());

            //禁用默认的提示信息
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(locationValidation.message()).addConstraintViolation();
            return false;
        } else {
            //禁用默认的提示信息，不清楚原有的是什么样的，可以去掉看看结果
            context.disableDefaultConstraintViolation();
            if (value.getX() > locationValidation.maxX()) {
                context.buildConstraintViolationWithTemplate("x value is bigger than max"+locationValidation.message())
                        .addConstraintViolation();
                return false;
            }

            if (value.getY() > locationValidation.maxY()) {
                context.buildConstraintViolationWithTemplate("y value is bigger than max"+locationValidation.message
                        ()).addConstraintViolation();
                return false;
            }

        }
        return true;
    }
}



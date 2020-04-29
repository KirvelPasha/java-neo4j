package com.demo.utility;

import com.demo.wrapper.StudentDtoList;
import org.springframework.stereotype.Component;

@Component
public class CheckHelper {
    public boolean isEmptyList(StudentDtoList studentDtoList) {
        return studentDtoList.getStudentDtoList().isEmpty();
    }
}

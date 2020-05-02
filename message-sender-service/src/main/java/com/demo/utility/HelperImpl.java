package com.demo.utility;

import com.demo.dto.StudentDto;
import com.demo.wrapper.StudentDtoList;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelperImpl {
    public boolean isEmptyList(StudentDtoList studentDtoList) {
        return studentDtoList.getStudentDtoList().isEmpty();
    }

    public void createMessage(List<StudentDto> studentDtoList, SimpleMailMessage simpleMailMessage) {
        StringBuilder message = new StringBuilder();
        studentDtoList.forEach(studentDto -> message.append(studentDto.getMail()).append('\n'));
        simpleMailMessage.setText(message.toString());
    }
}

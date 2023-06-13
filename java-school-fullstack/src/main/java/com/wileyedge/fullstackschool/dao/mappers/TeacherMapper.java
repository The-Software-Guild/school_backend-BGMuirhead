package com.wileyedge.fullstackschool.dao.mappers;

import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        int teacherId = rs.getInt("tid");
        String teacherFName = rs.getString("tFName");
        String teacherLName= rs.getString("tLName");;
        String dept= rs.getString("dept");;
        
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherFName(teacherFName);
        teacher.setTeacherLName(teacherLName);
        teacher.setDept(dept);
        
        
        return teacher;

        //YOUR CODE ENDS HERE
    }
}

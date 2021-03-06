package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.StudentModel;

@Mapper
public interface StudentMapper
{
    @Select("select * from student where npm = #{npm}")
    StudentModel selectStudent (@Param("npm") String npm);

    @Select("select * from student")
    List<StudentModel> selectAllStudents ();

    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    boolean addStudent (StudentModel student);
    
    @Delete("DELETE FROM student WHERE npm = #{npm}")
    boolean deleteStudent (@Param("npm") String npm);

    @Update("UPDATE student SET name = #{name}, gpa = #{gpa} WHERE npm = #{npm}")
    boolean updateStudent(StudentModel student);
}

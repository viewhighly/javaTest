package framework.mybatis.data.mapper;

import framework.mybatis.data.entity.Student;

/**
 * User: gaozhan
 * Date: 1/16/14
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StudentMapper {
    void saveStudent(Student student);
    void selectStudentForUpdate(Student student);
}

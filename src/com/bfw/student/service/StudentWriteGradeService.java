package com.bfw.student.service;

import java.util.List;

import com.bfw.po.StudentWriteGrade;

/**
 * 学员成绩的业务逻辑接口
 * @author 老牛
 * 2014年11月30日
 *
 */
public interface StudentWriteGradeService {

	/**
	 * 添加
	 * @param info
	 * @return
	 */
	public boolean add(StudentWriteGrade info);
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	public boolean update(StudentWriteGrade info);
	
	/**
	 * 删除
	 * @param info
	 * @return
	 */
	public boolean delete(Integer writeGradeId);
	
	/**
	 * 根据ID查询学员成绩
	 * @param writeGradeId
	 * @return
	 */
	public StudentWriteGrade getStudentWriteGrade(Integer writeGradeId);
	
	/**
	 * 根据条件查询学员成绩信息
	 * @param info
	 * @return
	 */
	public List<StudentWriteGrade> getList(StudentWriteGrade info);
}

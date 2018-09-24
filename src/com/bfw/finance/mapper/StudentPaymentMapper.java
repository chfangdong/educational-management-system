package com.bfw.finance.mapper;

import java.util.List;

import com.bfw.po.StudentPayment;

public interface StudentPaymentMapper {
    int deleteByPrimaryKey(Integer paymentId);

    int insert(StudentPayment record);

    int insertSelective(StudentPayment record);

    StudentPayment selectByPrimaryKey(Integer paymentId);

    int updateByPrimaryKeySelective(StudentPayment record);

    int updateByPrimaryKey(StudentPayment record);
    
    public List<StudentPayment> getStudentPaymentList(StudentPayment record);
}
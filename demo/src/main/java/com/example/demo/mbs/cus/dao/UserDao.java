package com.example.demo.mbs.cus.dao;

import com.example.demo.mbs.cus.dto.DuplicateDataRsp;
import com.example.demo.mbs.m1.model.UUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  @description  自定义dao练习
 *  @date  2022/5/24 12:34
 */

public interface UserDao {

    List<UUser> sqlCusShow();

    List<DuplicateDataRsp> duplicateData();

    List<UUser> paramLearn(@Param("id") Long id);
}

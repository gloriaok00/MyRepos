package com.example.demo.mbs.cus.dao;

import com.example.demo.mbs.cus.dto.DuplicateDataRsp;
import com.example.demo.mbs.cus.dto.UUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  @description  自定义dao练习
 *  @date  2022/5/24 12:34
 */

public interface UserDao {

    List<UUser> sqlCusShow();

    List<DuplicateDataRsp> duplicateData();

    List<UUser> paramLearn(@Param("id") Long idParam,String name);

    @Select("select * from u_user where id=#{id} and username=#{name}")
    List<UUser> paramLearnScript(Long id,String name);

    List<UUser> charDiff(@Param("tableName") String tableName,@Param("username") String name);

    List<UUser> resultMapLearn();

}

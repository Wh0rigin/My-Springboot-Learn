package com.who.springboot.mapper;

import com.who.springboot.model.Test;
import com.who.springboot.model.TestExample;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface TestMapper {
    int countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    Integer selectAllTestCount();
}
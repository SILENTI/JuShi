package com.example.jushi.mapper;

import com.example.jushi.model.District;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface DistrictMapper {

    /**
     * 根据parent获取District实体对象
     * @param parent 父类id
     * @return 返回父类旗下的所有的信息
     */
    List<District> selectByParent (String parent);

    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    District selectByPrimaryKey(Integer id);

    List<District> selectAll();

    int updateByPrimaryKey(District record);
}
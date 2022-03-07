package com.example.jushi.service.impl;

import com.example.jushi.mapper.DistrictMapper;
import com.example.jushi.model.District;
import com.example.jushi.service.DistrictService;
import com.example.jushi.service.ex.DistrictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 19:17
 * Description:
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 查询District信息
     * @param parent
     * @return 返回相关地区信息
     */
    @Override
    public List<District> findDistrict(String parent) {

        //将传递的parent
        List<District> districts = districtMapper.selectByParent(parent);

        //判断是否出现未知错误
        if (districts == null){
            throw new DistrictException("遇到未知错误，查询失败");
        }

        //屏蔽关键信息
        for (District district : districts) {
            district.setId(null);
            district.setParent(null);
        }

        return districts;
    }

    /**
     * 根据code查询省市区名称
     * @param code
     * @return 名称
     */
    @Override
    public String findDistrictName (String code){
        String name = districtMapper.selectDistrictNameByCode(code);

        if (name == null || name.equals("")){
            throw new DistrictException("遇到未知原因，查询DistrictName失败");
        }

        return name;
    }
}

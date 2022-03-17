package com.example.jushi.service;

import com.example.jushi.model.District;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 19:13
 * Description: 关于省份地区的信息的service层
 */
@Service
public interface IDistrictService {

    /**
     * 更具parent父ID查询相关信息
     * @param parent
     * @return
     */
    List<District> findDistrict (String parent);

    /**
     * 根据code查询district名称
     * @param code
     * @return
     */
    String findDistrictName (String code);
}

package com.example.jushi.controller;

import com.example.jushi.model.District;
import com.example.jushi.service.IDistrictService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 19:39
 * Description: 地区信息查询
 */
@RestController
@RequestMapping("/jushi/district")
public class DistrictController {

    @Autowired
    private IDistrictService IDistrictService;

    /**
     * 根据parent查询地区信息
     * @param parent
     * @return
     */
    @RequestMapping("")
    public JsonResult<List<District>> findDistrict (String parent){

        List<District> districts = IDistrictService.findDistrict(parent);

        return new JsonResult<>(districts,"地区查询成功");
    }

}

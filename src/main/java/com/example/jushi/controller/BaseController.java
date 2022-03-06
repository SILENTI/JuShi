package com.example.jushi.controller;

import com.example.jushi.controller.ex.*;
import com.example.jushi.service.ex.*;
import com.example.jushi.util.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 居無何
 * date: 2022/2/23 17:19
 * Description: 统一捕获controller层的异常
 */
@ControllerAdvice
public class BaseController {

    /**
     * @ControllerAdvice 标明该类时一个处理controller全局异常类
     * @ExceptionHandler 指明抛出的异常类
     * Throwable
     * */

    /*
    * 增 3000
    * 删 4000
    * 改 5000
    * 查 6000
    * 其 7000
    * */

    /**
     * 捕获异常UserController异常
     *      UserNameOccupyException ，确认用户名已被占用
     *      InsertException ，出现未知错误，导致用户注册失败
     * @param e
     * @return  返回处理后的JOSN数据
     */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> UserControllerException (Throwable e){
        JsonResult jsonDesign = new JsonResult();
        if (e instanceof UserNameOccupyException){
            jsonDesign.setStatus(3000);
            jsonDesign.setDescription("用户名已被占用");
        }else if (e instanceof UpdateException){
            jsonDesign.setStatus(5000);
            jsonDesign.setDescription("数据修改出现未知错误");
        }else  if (e instanceof UserPasswordWrongException){
            jsonDesign.setStatus(6000);
            jsonDesign.setDescription("登录密码错误");
        }else  if (e instanceof UserNotExitException){
            jsonDesign.setStatus(6005);
            jsonDesign.setDescription("用户不存在");
        }else if (e instanceof UserLoginInfoExpiredException){
            jsonDesign.setStatus(6010);
            jsonDesign.setDescription("登录信息过期");
        }else if (e instanceof UserNameNotExistsException){
            jsonDesign.setStatus(6015);
            jsonDesign.setDescription("该用户不存在");
        }else if (e instanceof AddressNotExistException){
            jsonDesign.setStatus(6020);
            jsonDesign.setDescription("当前用户未建收货地址");
        }else if (e instanceof DistrictException){
            jsonDesign.setStatus(6025);
            jsonDesign.setDescription("遇到未知错误，地区信息查询失败");
        }else  if (e instanceof InsertException){
            jsonDesign.setStatus(7000);
            jsonDesign.setDescription("数据新增出现未知错误");
        } else if (e instanceof FileUploadException){
            jsonDesign.setStatus(7010);
            jsonDesign.setDescription("出现文件相关未知异常");
        } else if (e instanceof FileRedWriteException){
            jsonDesign.setStatus(7020);
            jsonDesign.setDescription("文件读写错误");
        } else if (e instanceof FileSizeOutException){
            jsonDesign.setStatus(7030);
            jsonDesign.setDescription("文件大小超出限制");
        } else if (e instanceof FileTypeNotMatchException ){
            jsonDesign.setStatus(7040);
            jsonDesign.setDescription("文件类型不符");
        } else if (e instanceof FileEmptyException){
            jsonDesign.setStatus(7050);
            jsonDesign.setDescription("文件为空");
        }
        return jsonDesign;
    }

}

package com.lynch.web.controller;

import com.google.common.base.Strings;
import com.lynch.biz.bo.BizResult;
import com.lynch.biz.service.UserService;
import com.lynch.web.vo.RestResponse;
import com.lynch.web.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Controller
@RequestMapping(value = "/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",produces = "application/json")
    @ResponseBody
    public Object  register(@RequestParam(required = true) String userName,
                            @RequestParam(required = true) String passWord){
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(passWord)){
            return new RestResponse(Result.Reason.PARAM_ABSENT,
                    Result.Status.FAILURE,Result.ErrorCode.PARAM_ERROR);
        }
        BizResult result = userService.register(userName,passWord);
        if (result.isResult()){
            return new RestResponse(Result.Reason.SUCCESS,
                    Result.Status.SUCCESS,result.getData());
        }
        return new RestResponse(Result.Reason.FAILURE,
                Result.Status.FAILURE,Result.ErrorCode.UNKNOWN_ERROR);
    }


    @RequestMapping(value = "/login",produces = "application/json")
    @ResponseBody
    public Object login(Long uid,String passWord){
        if (null == uid || Strings.isNullOrEmpty(passWord)){
            return new RestResponse(Result.Reason.PARAM_ABSENT,
                    Result.Status.FAILURE,Result.ErrorCode.PARAM_ERROR);
        }
        BizResult result = userService.login(uid,passWord);
        if (result.isResult()){
            return new RestResponse(Result.Reason.SUCCESS,
                    Result.Status.SUCCESS,result.getData());
        }
        return new RestResponse(Result.Reason.FAILURE,
                Result.Status.FAILURE,Result.ErrorCode.UNKNOWN_ERROR);
    }
}

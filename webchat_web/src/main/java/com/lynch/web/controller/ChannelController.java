package com.lynch.web.controller;

import com.google.common.base.Strings;
import com.lynch.biz.bo.BizResult;
import com.lynch.biz.service.ChannelService;
import com.lynch.web.vo.RestResponse;
import com.lynch.web.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Controller
@RequestMapping(value = "/group/v1")
public class ChannelController {

    @Autowired
    private ChannelService groupService;

    @RequestMapping(value = "/create",produces = "application/json")
    @ResponseBody
    public Object createChannel(@RequestParam(required = true) Long uid,
                              @RequestParam(required = true) String channelName, String channelDesc){
        if (Strings.isNullOrEmpty(channelName) || null == uid){
            return new RestResponse(Result.Reason.PARAM_ABSENT,
                    Result.Status.FAILURE,Result.ErrorCode.PARAM_ERROR);
        }
        BizResult result = groupService.createGroup(uid,channelName,channelDesc);
        if (result.isResult()){
            return new RestResponse(Result.Reason.SUCCESS,
                    Result.Status.SUCCESS,result.getData());
        }
        return new RestResponse(Result.Reason.FAILURE,
                Result.Status.FAILURE,Result.ErrorCode.UNKNOWN_ERROR);
    }

    @RequestMapping
    @ResponseBody
    public Object joinChannel(@RequestParam(required = true) Long channelId,
                            @RequestBody ArrayList<Long> uid){
        if (null == channelId || null == uid){
            return new RestResponse(Result.Reason.PARAM_ABSENT,
                    Result.Status.FAILURE,Result.ErrorCode.PARAM_ERROR);
        }
        BizResult result = groupService.joinGroup(uid,channelId);
        if (result.isResult()){
            return new RestResponse(Result.Reason.SUCCESS,
                    Result.Status.SUCCESS,result.getData());
        }
        return new RestResponse(Result.Reason.FAILURE,
                Result.Status.FAILURE,Result.ErrorCode.UNKNOWN_ERROR);
    }



}

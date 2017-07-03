package com.lynch.biz.service;

import com.lynch.biz.bo.BizResult;

import java.util.List;

/**
 * Created by LuQiang on 2017/7/2.
 */
public interface ChannelService {

    BizResult createGroup(Long uid,String channelName,String channelDesc);

    BizResult joinGroup(List<Long> uids, Long channelId);

}

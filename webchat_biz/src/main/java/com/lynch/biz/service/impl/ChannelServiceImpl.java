package com.lynch.biz.service.impl;

import com.lynch.biz.bo.BizResult;
import com.lynch.biz.bo.ErrorCode;
import com.lynch.biz.service.ChannelService;
import com.lynch.dao.groupdao.ChannelDao;
import com.lynch.dao.model.Channel;
import com.lynch.dao.model.ChannelMember;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private RedisTemplate  redisTemplate;

    @Autowired
    private ChannelDao channelDao;

    private String GROUP_INDEX = "group:index";

    @Override
    public BizResult createGroup(Long uid, String channelName, String channelDesc) {
        BizResult bizResult = new BizResult();
        Channel channel = new Channel();
        channel.setChannelDesc(channelDesc);
        channel.setOwner(uid);
        channel.setChannelName(channelName);
        channel.setChannelId(generateGroupId());
        boolean isSuccess = channelDao.createChannel(channel);
        if (isSuccess){
            bizResult.setResult(true);
            bizResult.setData(channel);
        }
        return bizResult;
    }


    @Override
    public BizResult joinGroup(List<Long> uids, Long channelId) {
        BizResult bizResult = new BizResult();
        Channel channel = channelDao.getChannel(channelId);
        if (null == channel){
            bizResult.setErrorCode(ErrorCode.GROUP_NOT_EXIST);
            return bizResult;
        }
        DateTime now= DateTime.now(DateTimeZone.UTC);
        List<ChannelMember> channelMembers = new ArrayList<ChannelMember>();
        for (Long uid : uids){
            ChannelMember member = new ChannelMember();
            member.setChannelId(channelId);
            member.setUid(uid);
            member.setJoinTime(now.toDate());
            channelMembers.add(member);
        }
        boolean isSuccess = channelDao.saveChannelMember(channelMembers);
        if (isSuccess){
            bizResult.setResult(true);
        }
        return bizResult;
    }


    private long generateGroupId(){
        long index = redisTemplate.opsForValue().increment(GROUP_INDEX,1);
        return (200 << 10) + index;
    }

}

package com.lynch.dao.groupdao;

import com.lynch.dao.mapper.ChannelMapper;
import com.lynch.dao.mapper.ChannelMemberExtMapper;
import com.lynch.dao.model.Channel;
import com.lynch.dao.model.ChannelMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Service
public class ChannelDaoImpl implements ChannelDao {

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private ChannelMemberExtMapper channelMemberExtMapper;

    @Override
    public boolean createChannel(Channel channel) {
        return channelMapper.insert(channel) > 0;
    }

    @Override
    public Channel getChannel(Long channelId) {
        return channelMapper.selectByPrimaryKey(channelId);
    }

    @Override
    public boolean saveChannelMember(List<ChannelMember> members) {
        return channelMemberExtMapper.saveChannelMembers(members);
    }
}

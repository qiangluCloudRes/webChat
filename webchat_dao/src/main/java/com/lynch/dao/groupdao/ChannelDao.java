package com.lynch.dao.groupdao;

import com.lynch.dao.model.Channel;
import com.lynch.dao.model.ChannelMember;

import java.util.List;

/**
 * Created by LuQiang on 2017/7/2.
 */
public interface ChannelDao {

    boolean createChannel(Channel channel);

    Channel getChannel(Long channelId);

    boolean saveChannelMember(List<ChannelMember> members);
}

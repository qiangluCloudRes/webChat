package com.lynch.dao.mapper;

import com.lynch.dao.model.ChannelMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LuQiang on 2017/7/2.
 */
public interface ChannelMemberExtMapper {

    boolean saveChannelMembers(@Param("records") List<ChannelMember> records);
}

package com.timlis.gmall.user.mapper;

import com.timlis.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();


    void delete(String memberId);
}

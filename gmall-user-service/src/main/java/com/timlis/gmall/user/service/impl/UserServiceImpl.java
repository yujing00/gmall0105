package com.timlis.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.timlis.gmall.bean.UmsMember;
import com.timlis.gmall.bean.UmsMemberReceiveAddress;
import com.timlis.gmall.service.UserService;
import com.timlis.gmall.user.mapper.UmsMenbetReceiveAddressMapper;
import com.timlis.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMenbetReceiveAddressMapper umsMenbetReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userMapper.selectAllUser();
        return umsMembers;
    }




    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMenberId(String memberId) {

        Example e = new Example(UmsMemberReceiveAddress.class);

        e.createCriteria().andEqualTo("memberId", memberId);

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMenbetReceiveAddressMapper.selectByExample(e);

        return umsMemberReceiveAddresses;
    }

    @Override
    public void deleteUserById(String memberId) {
        Example example = new Example(UmsMember.class);

        example.createCriteria().andEqualTo("id", memberId);

        userMapper.deleteByExample(memberId);
    }


}

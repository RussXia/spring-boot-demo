package com.xzy.demo.service;

import com.xzy.demo.model.UserVO;
import com.xzy.demo.result.DubboResult;

/**
 * Created by RuzzZZ on 2017/4/20.
 */
public interface DemoDubboService {

    DubboResult<UserVO> getUserInfoById(Long id);
}

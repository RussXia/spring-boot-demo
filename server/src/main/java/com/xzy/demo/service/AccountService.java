package com.xzy.demo.service;

import com.xzy.demo.dao.repo.AccountRepository;
import com.xzy.demo.pojo.entity.Account;
import com.xzy.demo.pojo.vo.AccountVO;
import com.xzy.demo.util.BeanConverter;
import com.xzy.demo.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public int insert(AccountVO accountVO) {
        Account record = BeanConverter.copyProperties(accountVO, Account.class);
        return accountRepository.insert(record);
    }

    public int updateByPrimaryKey(AccountVO accountVO) {
        Account record = BeanConverter.copyProperties(accountVO, Account.class);
        return accountRepository.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(AccountVO accountVO) {
        Account record = BeanConverter.copyProperties(accountVO, Account.class);
        return accountRepository.updateByPrimaryKeySelective(record);
    }

    public int deleteById(Integer id) {
        return accountRepository.deleteById(id);
    }

    public AccountVO selectById(Integer id) {
        Optional<Account> account = accountRepository.selectByPrimaryKey(id);
        return BeanConverter.copyProperties(account.orElse(null), AccountVO.class);
    }

    public Page<AccountVO> pageQueryByUserNameLike(String userName, Integer pageNum, Integer pageSize) {
        List<Account> userNameLike = accountRepository.selectByUserNameLike(userName, pageNum, pageSize);
        int totalCount = accountRepository.countByUserNameLike(userName, pageNum, pageSize);

        List<AccountVO> accountVOList = BeanConverter.copyPropertiesOfList(userNameLike, AccountVO.class);
        return new Page<>(totalCount, pageNum, pageSize, accountVOList);
    }

}

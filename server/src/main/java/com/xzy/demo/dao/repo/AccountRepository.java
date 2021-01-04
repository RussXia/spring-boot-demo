package com.xzy.demo.dao.repo;

import com.xzy.demo.dao.mapper.AccountMapper;
import com.xzy.demo.pojo.entity.Account;
import com.xzy.demo.util.PageHelper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static com.xzy.demo.dao.mapper.AccountDynamicSqlSupport.account;
import static org.mybatis.dynamic.sql.SqlBuilder.count;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@Repository
public class AccountRepository {

    @Autowired
    private AccountMapper accountMapper;

    public int countByUserNameLike(String userName, Integer pageNum, Integer pageSize) {
        SelectStatementProvider count = select(count())
                .from(account)
                .where(account.userName, isLike("%" + userName + "%"))
                .orderBy(account.id)
                .limit(pageSize)
                .offset(PageHelper.offset(pageNum, pageSize))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return (int) accountMapper.count(count);
    }

    @Cacheable(value = "account", key = "#id")
    public Optional<Account> selectByPrimaryKey(Integer id) {
        return accountMapper.selectOne(c -> c.where(account.id, isEqualTo(id)));
    }

    public List<Account> selectByUserNameLike(String userName, Integer pageNum, Integer pageSize) {
        SelectStatementProvider select = select(account.allColumns())
                .from(account)
                .where(account.userName, isLike("%" + userName + "%"))
                .orderBy(account.id)
                .limit(pageSize)
                .offset(PageHelper.offset(pageNum, pageSize))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return accountMapper.selectMany(select);
    }

    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    public int deleteById(Integer id) {
        return accountMapper.delete(c -> c.where(account.id, isEqualTo(id)));
    }

    @CacheEvict(value = "account", key = "#record.id")
    public int updateByPrimaryKeySelective(Account record) {
        Assert.notNull(record, "account can't be null");
        Assert.notNull(record.getId(), "id can't be null");

        return accountMapper.update(c -> AccountMapper.updateSelectiveColumns(record, c)
                .where(account.id, isEqualTo(record.getId())));
    }

    @CacheEvict(value = "account", key = "#record.id")
    public int updateByPrimaryKey(Account record) {
        Assert.notNull(record, "account can't be null");
        Assert.notNull(record.getId(), "id can't be null");

        return accountMapper.update(c -> AccountMapper.updateAllColumns(record, c)
                .where(account.id, isEqualTo(record.getId())));
    }
}

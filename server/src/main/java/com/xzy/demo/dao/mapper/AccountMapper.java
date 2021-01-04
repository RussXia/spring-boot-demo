package com.xzy.demo.dao.mapper;

import static com.xzy.demo.dao.mapper.AccountDynamicSqlSupport.*;

import com.xzy.demo.pojo.entity.Account;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface AccountMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:26.906+08:00", comments="Source Table: test_account")
    BasicColumn[] selectList = BasicColumn.columnList(id, userName, address, score, sex, registerTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:16.541+08:00", comments="Source Table: test_account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:17.011+08:00", comments="Source Table: test_account")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:17.353+08:00", comments="Source Table: test_account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Account> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:17.686+08:00", comments="Source Table: test_account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Account> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:20.062+08:00", comments="Source Table: test_account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountResult")
    Optional<Account> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:20.39+08:00", comments="Source Table: test_account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.DECIMAL),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="register_time", property="registerTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Account> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:21.287+08:00", comments="Source Table: test_account")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:22.79+08:00", comments="Source Table: test_account")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:23.673+08:00", comments="Source Table: test_account")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:24.851+08:00", comments="Source Table: test_account")
    default int insert(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(address).toProperty("address")
            .map(score).toProperty("score")
            .map(sex).toProperty("sex")
            .map(registerTime).toProperty("registerTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:25.991+08:00", comments="Source Table: test_account")
    default int insertMultiple(Collection<Account> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, account, c ->
            c.map(id).toProperty("id")
            .map(userName).toProperty("userName")
            .map(address).toProperty("address")
            .map(score).toProperty("score")
            .map(sex).toProperty("sex")
            .map(registerTime).toProperty("registerTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:26.4+08:00", comments="Source Table: test_account")
    default int insertSelective(Account record) {
        return MyBatis3Utils.insert(this::insert, record, account, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(score).toPropertyWhenPresent("score", record::getScore)
            .map(sex).toPropertyWhenPresent("sex", record::getSex)
            .map(registerTime).toPropertyWhenPresent("registerTime", record::getRegisterTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:27.011+08:00", comments="Source Table: test_account")
    default Optional<Account> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:27.016+08:00", comments="Source Table: test_account")
    default List<Account> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:28.416+08:00", comments="Source Table: test_account")
    default List<Account> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:29.072+08:00", comments="Source Table: test_account")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:29.397+08:00", comments="Source Table: test_account")
    static UpdateDSL<UpdateModel> updateAllColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(userName).equalTo(record::getUserName)
                .set(address).equalTo(record::getAddress)
                .set(score).equalTo(record::getScore)
                .set(sex).equalTo(record::getSex)
                .set(registerTime).equalTo(record::getRegisterTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:28:30.683+08:00", comments="Source Table: test_account")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(score).equalToWhenPresent(record::getScore)
                .set(sex).equalToWhenPresent(record::getSex)
                .set(registerTime).equalToWhenPresent(record::getRegisterTime);
    }
}
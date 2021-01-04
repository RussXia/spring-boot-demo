package com.xzy.demo.dao.mapper;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:02.527+08:00", comments="Source Table: test_account")
    public static final Account account = new Account();

    /**
     * Database Column Remarks:
     *   主键ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:02.531+08:00", comments="Source field: test_account.id")
    public static final SqlColumn<Integer> id = account.id;

    /**
     * Database Column Remarks:
     *   姓名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:57.397+08:00", comments="Source field: test_account.user_name")
    public static final SqlColumn<String> userName = account.userName;

    /**
     * Database Column Remarks:
     *   地址
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:58.167+08:00", comments="Source field: test_account.address")
    public static final SqlColumn<String> address = account.address;

    /**
     * Database Column Remarks:
     *   积分
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:58.721+08:00", comments="Source field: test_account.score")
    public static final SqlColumn<BigDecimal> score = account.score;

    /**
     * Database Column Remarks:
     *   性别:0-女性;1-男性
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:59.195+08:00", comments="Source field: test_account.sex")
    public static final SqlColumn<Integer> sex = account.sex;

    /**
     * Database Column Remarks:
     *   注册时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:59.669+08:00", comments="Source field: test_account.register_time")
    public static final SqlColumn<Date> registerTime = account.registerTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-04T10:27:02.53+08:00", comments="Source Table: test_account")
    public static final class Account extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> score = column("score", JDBCType.DECIMAL);

        public final SqlColumn<Integer> sex = column("sex", JDBCType.TINYINT);

        public final SqlColumn<Date> registerTime = column("register_time", JDBCType.TIMESTAMP);

        public Account() {
            super("test_account");
        }
    }
}
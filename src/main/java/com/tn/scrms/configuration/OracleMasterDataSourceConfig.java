package com.tn.scrms.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(OracleMasterDruidProperties.class)
@MapperScan(basePackages = "com.tn.scrms.dao.oracle", sqlSessionTemplateRef = "oracleMasterSqlSessionTemplate")
public class OracleMasterDataSourceConfig {
    Logger logger = LoggerFactory.getLogger(OracleMasterDataSourceConfig.class);

    @Autowired
    private OracleMasterDruidProperties druidProperties;

    /**
     * 根据给定的配置创建数据源
     */
    @Bean(name = "oracleMasterDataSource")
    @ConfigurationProperties(value = "spring.datasource.oracle-master")
    public DataSource createDruidDatasource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setName(druidProperties.getName());
        datasource.setUrl(druidProperties.getUrl());
        datasource.setUsername(druidProperties.getUsername());
        datasource.setPassword(druidProperties.getPassword());
        datasource.setDriverClassName(druidProperties.getDriverClassName());
        datasource.setInitialSize(druidProperties.getInitialSize());
        datasource.setMinIdle(druidProperties.getMinIdle());
        datasource.setMaxActive(druidProperties.getMaxActive());
        datasource.setMaxWait(druidProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidProperties.getValidationQuery());
        datasource.setTestWhileIdle(druidProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(druidProperties.isTestOnBorrow());
        datasource.setTestOnReturn(druidProperties.isTestOnReturn());
        datasource.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
        try {
            datasource.setFilters(druidProperties.getFilters());
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }


    //    @Bean(name="oracleMasterJdbcTemplate")
//    @Primary
//    public JdbcTemplate jdbcTemplate(@Qualifier("oracleMasterDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//
    @Bean(name = "oracleMasterTransactionManager")
    public DataSourceTransactionManager master2TransactionManager(@Qualifier("oracleMasterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "oracleMasterSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleMasterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "oracleMasterSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oracleMasterSqlSessionFactory") SqlSessionFactory sessionFactory)  {
        return new SqlSessionTemplate(sessionFactory);
    }

}

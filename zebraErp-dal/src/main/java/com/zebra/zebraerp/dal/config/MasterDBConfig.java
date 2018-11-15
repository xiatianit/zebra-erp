//package com.zebra.zebraerp.dal.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * 写数据库配置
// * mybatis配置
// * 
// * @author owen
// */
//@Configuration
//@EnableTransactionManagement
//@MapperScan("com.zebra.zebraerp.dal.mapper")
//public class MasterDBConfig {
//
//    /**
//     * 创建dataSource 以后还可以扩展创建多个数据源
//     * 
//     * @return
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }
//
//    /***
//     * 创建sqlSeesionFactory
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//
//        // 设置数据元
//        bean.setDataSource(dataSource());
//        bean.setTypeAliasesPackage("com.zebra.zebraerp.dal.dataobject");
//        // 添加插件
//        // bean.setPlugins(new Interceptor[] { pageHelper });
//        // 添加xml目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources("classpath:/com/zebra/zebraerp/dal/mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    /***
//     * 事务管理
//     * @return
//     */
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//}

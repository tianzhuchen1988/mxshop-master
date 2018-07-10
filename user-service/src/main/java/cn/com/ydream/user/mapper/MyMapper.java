package cn.com.ydream.user.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper接口
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper{
}

package live.chenchen.springdemo.dao;

import live.chenchen.springdemo.pojo.Girl;

public interface GirlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Girl record);

    int insertSelective(Girl record);

    Girl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);
}
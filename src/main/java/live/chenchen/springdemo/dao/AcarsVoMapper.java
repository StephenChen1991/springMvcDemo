package live.chenchen.springdemo.dao;

import live.chenchen.springdemo.pojo.AcarsVo;

public interface AcarsVoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AcarsVo record);

    int insertSelective(AcarsVo record);

    AcarsVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AcarsVo record);

    int updateByPrimaryKey(AcarsVo record);
}
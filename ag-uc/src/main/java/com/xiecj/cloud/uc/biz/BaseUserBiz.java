package com.xiecj.cloud.uc.biz;

import com.xiecj.cloud.uc.entity.BaseUser;
import com.xiecj.cloud.uc.mapper.BaseUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xiecj.cloud.common.biz.BaseBiz;

@Service
@Transactional
public class BaseUserBiz extends BaseBiz<BaseUserMapper,BaseUser>{
//    @Override
//    public BaseUser selectById(Object id) {
//        throw new BaseException("Test Global Exception!", 400);
//    }
//    @Autowired
//    private BaseUserMapper baseUserMapper;
//
//    public int deleteByPrimaryKey(Object key) {
//        return 0;
//    }
//
//
//    public int delete(BaseUser record) {
//        return 0;
//    }
//
//
//    public int insert(BaseUser record) {
//        return 0;
//    }
//
//
//    public int insertSelective(BaseUser record) {
//        return 0;
//    }
//
//
//    public boolean existsWithPrimaryKey(Object key) {
//        return false;
//    }
//
//
//    public List<BaseUser> selectAll() {
//        return null;
//    }
//
//
//    public BaseUser selectByPrimaryKey(Object key) {
//        return baseUserMapper.selectByPrimaryKey(key);
//    }
//
//
//    public int selectCount(BaseUser record) {
//        return 0;
//    }
//
//
//    public List<BaseUser> select(BaseUser record) {
//        return null;
//    }
//
//
//    public BaseUser selectOne(BaseUser record) {
//        return null;
//    }
//
//
//    public int updateByPrimaryKey(BaseUser record) {
//        return 0;
//    }
//
//
//    public int updateByPrimaryKeySelective(BaseUser record) {
//        return 0;
//    }
//
//
//    public int deleteByExample(Object example) {
//        return 0;
//    }
//
//
//    public List<BaseUser> selectByExample(Object example) {
//        return null;
//    }
//
//
//    public int selectCountByExample(Object example) {
//        return 0;
//    }
//
//
//    public int updateByExample(BaseUser record, Object example) {
//        return 0;
//    }

}

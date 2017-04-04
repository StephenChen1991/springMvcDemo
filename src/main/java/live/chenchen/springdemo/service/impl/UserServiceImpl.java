package live.chenchen.springdemo.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  
import live.chenchen.springdemo.dao.UserMapper;  
import live.chenchen.springdemo.pojo.User;  
import live.chenchen.springdemo.service.IUserService;  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private UserMapper userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    } 
}

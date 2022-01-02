package org.example.springboard1.user;

import org.example.springboard1.Const;
import org.example.springboard1.UserUtils;
import org.example.springboard1.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession hs;

public int login(UserEntity entity){
    UserEntity loginUser = null;
    try{loginUser = mapper.selUser(entity);}
    catch (Exception e){
        e.printStackTrace();
        return 0;
    }
    if(loginUser == null){
        return 2; //아이디없음
    }
    if(BCrypt.checkpw(entity.getUpw(),loginUser.getUpw())){
        loginUser.setUpw(null);
        loginUser.setRdt(null);
        hs.setAttribute(Const.LOGIN_USER,loginUser);
        return 1;
}
    return 3;//비밀번호 다름
    }


    public int join(UserEntity entity){
    String plainPw = entity.getUpw();
    String hashPw = BCrypt.hashpw(plainPw,BCrypt.gensalt());
    entity.setUpw(hashPw);
    int result = mapper.insUser(entity);
    entity.setUpw(plainPw);
    return result;
    }

}

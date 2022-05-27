package com.inexture.springBootTask.Service;

import java.util.List;

import com.inexture.springBootTask.Model.AssignBean;
import com.inexture.springBootTask.Model.UserBean;

public interface AdminService {

	List<AssignBean> checkUserType(UserBean uBean);

}
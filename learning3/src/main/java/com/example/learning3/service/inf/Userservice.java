package com.example.learning3.service.inf;

import java.util.List;



import com.example.learning3.viewmodel.Userviewmodel;


public interface Userservice {
	List<Userviewmodel> allUser();
	Boolean postallUser(Userviewmodel postAll);
	Boolean putUser(Userviewmodel postAll);
	Boolean deleteUser(String id);
	Userviewmodel oneUser(String id);
}

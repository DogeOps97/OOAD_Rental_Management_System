/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author user
 */
import java.lang.String.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Collections;

class Tenant extends User{
	Tenant(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userID, userName, userPassword, userRealName, userContact, accountType);
	}

	Tenant(String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userName, userPassword, userRealName, userContact, accountType);
	}
}


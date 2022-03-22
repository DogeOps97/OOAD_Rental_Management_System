/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.lang.String.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Collections;

class PropertyAgent extends User{
	PropertyAgent(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userID, userName, userPassword, userRealName, userContact, accountType);
	}

	PropertyAgent(String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userName, userPassword, userRealName, userContact, accountType);
	}
}
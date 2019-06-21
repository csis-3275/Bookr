package com.csis3275.Boundary;

import com.csis3275.Entities.*;

public class TestAllDAOImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOImpl nud = new UserDAOImpl();
		User nu = new User();
		
		nu.set_role_id(10);
		nu.set_firstname("Deji");
		nu.set_lastname("Ojo");
		nu.set_email("deji2109@gmail.com");
		nud.createUser(nu);
		
	}

}

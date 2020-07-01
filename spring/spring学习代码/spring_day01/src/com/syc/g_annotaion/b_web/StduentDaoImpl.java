package com.syc.g_annotaion.b_web;

import org.springframework.stereotype.Repository;

@Repository("studentDaoId")
public class StduentDaoImpl implements StudentDao {

	@Override
	public void save() {
		System.out.println("Dao");
		
	}
}

package com.model;

import java.util.ArrayList;

import com.obrs.*;
public class RegistrationModel {
private String email_id;
private String name;
private String dl_no;
private String ph_no;
private String password;
private String location;
private String utype;
private String s_quest;
private String s_ans;
private String u_id;
private String model;
private String pday_rent;
private String b_colour;
private String rent_type;

public RegistrationModel()
{

}

public RegistrationModel( String email_id, String name, String dl_no,  String ph_no, String password, String location,   String utype, String s_quest,  String s_ans, String u_id) {
	
	this.email_id = email_id;
	this.name = name;
	this.dl_no=dl_no;
	this.ph_no = ph_no;
	this.password = password;
	this.location=location;
	this.utype=utype;
	this.s_quest = s_quest;
	this.s_ans = s_ans;
	this.u_id=u_id;
	
}
public String getEmail_id() {
	return email_id;
}

public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getDl_no() {
	return dl_no;
}

public void setDl_no(String dl_no) {
	this.dl_no = dl_no;
}
public String getPh_no() {
	return ph_no;
}

public void setPh_no(String ph_no) {
	this.ph_no = ph_no;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
public String getS_quest() {
	return s_quest;
}

public void setS_quest(String s_quest) {
	this.s_quest = s_quest;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getS_ans() {
	return s_ans;
}

public void setS_ans(String s_ans) {
	this.s_ans = s_ans;
}

public String getU_id() {
	return u_id;
}

public void setU_id(String n) {
	this.u_id = u_id+n;
}

public String getUtype() {
	return null;
}

public void setUtype(String utype) {
	this.utype = null;
}
public RegistrationModel(String model,String pday_rent,String b_colour)
{
	this.model = model;
	this.pday_rent = pday_rent;
	this.b_colour=b_colour;
	
}


public String getB_colour() {
	return b_colour;
}

public void setB_colour(String b_colour) {
	this.b_colour = b_colour;
}

public RegistrationModel(String email_id, String name, String ph_no, String location) {
	
	this.email_id = email_id;
	this.name = name;
	this.ph_no = ph_no;
	this.location = location;
}

public String getPday_rent() {
	return pday_rent;
}

public void setPday_rent(String pday_rent) {
	this.pday_rent = pday_rent;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}
public  ArrayList<RegistrationModel> showAllBikes()
{
	ArrayList  <RegistrationModel> arr=null;
	arr=AvailableBikesDAO.allbikes(rent_type);
	if(arr!=null)
	    return arr;
	else
		return null; 
}

public String getRent_type() {
	return rent_type;
}

public void setRent_type(String rent_type) {
	this.rent_type = rent_type;
}

}
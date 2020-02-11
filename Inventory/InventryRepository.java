package com.akshay.webServices;

import java.util.ArrayList;
import java.util.List;

public class InventryRepository {

	List<Inventry> inventry= new ArrayList<>();;
	
	public InventryRepository()
	{
		Inventry a1 = new Inventry();
		a1.setName("Apple");
		a1.setQuantity(10);
		
		Inventry a2 = new Inventry();
		a2.setName("Banana");
		a2.setQuantity(20);
		
		Inventry a3 = new Inventry();
		a3.setName("Grapes");
		a3.setQuantity(10);
		
		inventry.add(a1);
		inventry.add(a2);
		inventry.add(a3);
	}
	
	
	public List<Inventry> getInventry()
	{	
		return inventry;
	}
	
	public Inventry getInvent(String name)
	{
		for(Inventry a:inventry)
		{
			if(name.equals(a.getName()))
				return a;
		}
		return new Inventry();
	}
	
	public List<Inventry> create(Inventry a)
	{	
		System.out.println("hi create called!!");
		System.out.println(a.getName());
		inventry.add(a);
		 return inventry;
	}


	public void update(Inventry a) {
		// TODO Auto-generated method stub
		inventry.removeAll(inventry);
		inventry.add(a);
	}


	public List<Inventry> update(Inventry a, String name) 
	{
		// TODO Auto-generated method stub
		for(Inventry a1:inventry)
		{
			if(name.equals(a1.getName()))
			{
				a1.setName(a.getName());
				a1.setQuantity(a.getQuantity());
				break;
			}
		}
		return inventry;
		
	}


	public void deleteAll() {
		
		inventry.removeAll(inventry);
	}


	public List<Inventry> deleteOne(String name) {
		
		inventry.remove(getInvent(name));
		return inventry;
	}
	
}

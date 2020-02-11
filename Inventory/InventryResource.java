package com.akshay.webServices;

import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.*;

@Path("Inventry")
public class InventryResource 
{
	InventryRepository repo = new InventryRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Inventry> getInventry()
	{
		System.out.println("getInventry is called !!!");
		return repo.getInventry();
	}
	
	@GET
	@Path("{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Inventry getInventry(@PathParam("name") String name)
	{
		System.out.println(name);
		return repo.getInvent(name);
	}
	
	
	@POST
	@Path("/inventry")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Inventry> createInventry(Inventry a)
	{
		System.out.println(a);
		return repo.create(a);
		
	}
	
	@PUT
	public List<Inventry> updateInventory(Inventry a)
	{
		repo.update(a);
		return repo.getInventry();
	}

	@PUT
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventry> updateInvent(Inventry a, @PathParam("name") String name)
	{
		repo.update(a, name);
		return repo.getInventry();
	}
	
	@DELETE
	public List<Inventry> deleteInventory()
	{
		repo.deleteAll();
		return repo.getInventry();
	}
	
	@DELETE
	@Path("/{name}")
	public List<Inventry> deleteOneInventory(@PathParam("name") String name)
	{
		//Inventry a = repo.getInvent(name);
		return repo.deleteOne(name);
	}
}

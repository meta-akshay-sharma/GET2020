
import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTests {

	/* Test Cases For Cage Class */
	
	@Test
	public void test_addAnimalInCage(){
		
		Animal animal = new Lion("Lion1", 9, 30);
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(animal);
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void test_addAnimalInCageMoreThenCapacity(){
		
		
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		isAdded = cage.addAnimal(new Lion("Lion3", 9, 30));
		assertEquals(false, isAdded);
	}
	
	@Test
	public void test_removeAnimalFromCage(){
		
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		boolean isRemoved = cage.removeAnimal(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void test_removeAnimalWithoutAddingAnyAnimal(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isRemoved = cage.removeAnimal(1);
		assertEquals(false,isRemoved);
		
	}
	
	public void test_removeAnimalWithWrongIndex(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isRemoved = cage.removeAnimal(5);
		assertEquals(false,isRemoved);
	}
	
	@Test
	public void test_isSpaceAvailableWhenCageHavingSpace(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));	
		boolean isSpaceAvailable = cage.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void test_isSpaceAvailableWhenCageIsFull(){
		Cage cage = new Cage("Carnivore" , 2);
		boolean isAdded = cage.addAnimal(new Lion("Lion1", 9, 30));		
		isAdded = cage.addAnimal(new Lion("Lion2", 9, 30));
		boolean isSpaceAvailable = cage.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	

	/* Test Cases For Zone Class */
	
	@Test
	public void test_addCageInZone(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void test_addCageInZoneMoreThenCapacity(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		assertEquals(false, isAdded);
		
	}
	
	@Test
	public void test_removeCageFromZone(){
		
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		boolean isRemoved = zone.removeCage(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void test_removeCageWithoutAddingAnyCage(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isRemoved = zone.removeCage(1);
		assertEquals(false, isRemoved);
		
	}
	
	public void test_removeCageWithWrongIndex(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		boolean isRemoved = zone.removeCage(4);
		assertEquals(true, isRemoved);
	}
	
	@Test
	public void test_isSpaceAvailableWhenZoneHavingSpace(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));	
		boolean isSpaceAvailable = zone.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void test_isSpaceAvailableWhenZoneIsFull(){
		Zone zone = new Zone("Carnivore" , 2);
		boolean isAdded = zone.addCage(new Cage("Carnivore" , 2));		
		isAdded = zone.addCage(new Cage("Carnivore" , 2));
		isAdded = zone.addCage(new Cage("Carnivore" , 2));	
		boolean isSpaceAvailable = zone.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	
	

	/* Test Cases For Zoo Class */
	
	@Test
	public void test_addZoneInZoo(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		assertEquals(true, isAdded);
		
	}
	

	@Test
	public void test_addZoneInZooMoreThenCapacity(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		assertEquals(false, isAdded);
		
	}
	
	@Test
	public void test_removeZoneFromZoo(){
		
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isRemoved = zoo.removeZone(1);
		assertEquals(true, isRemoved);
		
	}
	
	@Test
	public void test_removeZoneWithoutAddingAnyZone(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isRemoved = zoo.removeZone(1);
		assertEquals(false, isRemoved);
	}
	
	public void test_removeZoneWithWrongIndex(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isRemoved = zoo.removeZone(5);
		assertEquals(false, isRemoved);
		
	}
	
	@Test
	public void test_isSpaceAvailableWhenZooHavingSpace(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));	
		boolean isSpaceAvailable = zoo.isSpaceAvaliable();
		assertEquals(true,isSpaceAvailable);
		
	}
	
	@Test
	public void test_isSpaceAvailableWhenZooIsFull(){
		Zoo zoo = new Zoo("Carnivore" , 2);
		boolean isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		isAdded = zoo.addZone(new Zone("Carnivore" , 2));
		boolean isSpaceAvailable = zoo.isSpaceAvaliable();
		assertEquals(false,isSpaceAvailable);
		
	}
	
}
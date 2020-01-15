import java.util.*;
/**
 * 
 * @author Akshay
 * Cart class declare the Variables used in a shoping cart.
 * for example => item name, Quantity, price etc;
 * and contains all the functions for (view cart, update cart, add or remove item, view cart, generate bill, add new item to the shop)
 */
class Cart {

	int choice=0,flow=1,purchaseItemNo,purchaseQuantity,total=0;
	Scanner input = new Scanner(System.in);
	ArrayList<String> itemName = new ArrayList<String>();
	ArrayList<Integer> quantity = new ArrayList<Integer>();
	ArrayList<Integer> maxLimit = new ArrayList<Integer>();
	ArrayList<Integer> maxLimitCopy = new ArrayList<Integer>();
	ArrayList<Integer> price = new ArrayList<Integer>();

	/**
	 * view_list Function shows the list of items available in the shop.
	 */

	void view_list()
	{
		System.out.println("Item No.\t\t\t\tItem\t\t\t\t\tPrice\t\t\t\tMax. Quantity");
		for(int i=0;i<itemName.size();i++)
		{
			if(maxLimitCopy.get(i)!=0)
			{
				System.out.println(i+1+"\t\t\t\t\t"+itemName.get(i)+"\t\t\t\t\t"+price.get(i)+"\t\t\t\t\t"+maxLimitCopy.get(i));
			}
		}
	}

	/**
	 * update_list Function ask for item no. and quantity you want to purchase and add them to your cart if available.
	 */

	void update_list()
	{
		System.out.print("\nEnter the Item no. you want to Purchase or update the quantity:");
		purchaseItemNo = input.nextInt();
		System.out.print("\nEnter the Quantity:");
		purchaseQuantity = input.nextInt();
		if(purchaseQuantity <= maxLimit.get(purchaseItemNo-1) && purchaseQuantity!=0)
		{
			maxLimitCopy.set(purchaseItemNo-1,maxLimit.get(purchaseItemNo-1)-purchaseQuantity);
			quantity.set(purchaseItemNo-1,purchaseQuantity);
		}
		else if((maxLimitCopy.get(purchaseItemNo-1))!=(maxLimit.get(purchaseItemNo-1)) && purchaseQuantity == 0)
		{
			maxLimitCopy.set(purchaseItemNo-1, maxLimit.get(purchaseItemNo-1));
			quantity.set(purchaseItemNo-1, purchaseQuantity);
		}
		else
		{
			System.out.println("You Have Entered The Wrong Limit of Quantity !!!!!");
		}
	}

	/**
	 * view_cart Function Shows The items in your Cart. 
	 */

	void view_cart()
	{
		total = 0;
		System.out.println("Item\t\t\t\t\tPrice\t\t\t\t\tQuantity\t\t\t\t\tSub_Total");
		for(int i=0;i<itemName.size();i++)
		{
			if(quantity.get(i)!=0)
			{
				System.out.println(itemName.get(i)+"\t\t\t\t\t"+price.get(i)+"\t\t\t\t\t"+quantity.get(i)+"\t\t\t\t\t\t"+(quantity.get(i)*price.get(i)));
				total+=(quantity.get(i)*price.get(i));
			}
		}
		System.out.println("The Total Ammont To be paid ===>>"+total);
	}

	/**
	 * add_new_item Function Adds new Item to the shop
	 */

	void add_new_item()
	{
		String name="";
		int priceCopy=0,maxQuantity=0;
		System.out.println("\nEnter the New Item Name :");
		input.nextLine();
		try{
			name = input.nextLine();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid Input");
			System.exit(0);
		}
		//itemName.add(name);
		try{
			System.out.println("\nEnter the Price of Item :");
			priceCopy = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid Input");
			System.exit(0);
		}
		if(priceCopy <= 0)
		{
			System.out.println("\nYou Entered Invalid Details \n Your Entry is Not Added in the Record !!!!!");
		}
		//price.add(input.nextInt());
		try{
			System.out.println("\nEnter the Maximum Quantity : ");
			maxQuantity = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nInvalid Input");
			System.exit(0);
		}
		if(priceCopy<=0 || maxQuantity <=0)
		{
			System.out.println("\nYou Entered Invalid Details \n Your Entry is Not Added in the Record !!!!!");
		}
		else
		{
			itemName.add(name);
			maxLimit.add(maxQuantity);
			maxLimitCopy.add(maxQuantity);
			quantity.add(0);
			price.add(priceCopy);
		}
	}

	/**
	 * generate_bill Function Generates an invoice with the tax and Grand Total To be paid by the customer.
	 */

	void generate_bill()
	{
		total = 0;
		int invoiceNo;
		invoiceNo = (int)(Math.random()*10000);
		System.out.println("\nInvoice No. : "+invoiceNo);
		System.out.println("Item\t\t\t\t\tPrice\t\t\t\t\tQuantity\t\t\t\t\tSub_Total");
		for(int i=0;i<itemName.size();i++)
		{
			if(quantity.get(i)!=0)
			{
				System.out.println(itemName.get(i)+"\t\t\t\t\t"+price.get(i)+"\t\t\t\t\t"+quantity.get(i)+"\t\t\t\t\t\t"+(quantity.get(i)*price.get(i)));
				total+=(quantity.get(i)*price.get(i));
			}
		}
		System.out.println("Total Ammont===>>"+total);
		float gst = (float) (total*.02);
		float grand_total = gst + total;
		System.out.println("GST ( 2% of Total )     ===>>"+gst);
		System.out.println("Grant Total to be paid  ===>>"+grand_total);
	}
	void removeItem()
	{
		int itemNo=0;
		try{
			System.out.println("\nEnter the Item number You want to delete :");
			itemNo = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("\nYou Entered Invalid Input !!!!!");
			System.exit(0);
		}
		if((maxLimit.get(itemNo-1))==(maxLimitCopy.get(itemNo-1)))
		{
			itemName.remove(itemNo-1);
			maxLimit.remove(itemNo-1);
			maxLimitCopy.remove(itemNo-1);
			price.remove(itemNo-1);
			System.out.println("\nReMoved Item SuccessFully !!!!!");
		}
		else
		{
			System.out.println("\nYou Have This Item In your Cart.\nPlease Remove it from your cart First !!!!!");
		}
	}
	public static void main(String[] args) throws Exception{
		int choice=0,flow=1,purchase_item_no,purchase_quantity,total=0;
		//int[] qty={0,0,0,0,0};
		//String[] item_name={"pen","pencil","Eraser","File","Folder"};
		//int[] price={10,5,5,20,50};
		Cart cart = new Cart(); 
		cart.itemName.addAll(Arrays.asList("pen","pencil","Eraser","File","Folder"));
		cart.quantity.addAll(Arrays.asList(0,0,0,0,0));
		cart.maxLimit.addAll(Arrays.asList(10,10,10,10,10));
		cart.maxLimitCopy.addAll(Arrays.asList(10,10,10,10,10));
		cart.price.addAll(Arrays.asList(10,5,5,20,50));
		Scanner input = new Scanner(System.in);
		ArrayList<String> itemName = new ArrayList<String>();
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<Integer> maxLimit = new ArrayList<Integer>();
		ArrayList<Integer> maxLimitCopy = new ArrayList<Integer>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		itemName.addAll(Arrays.asList("pen","pencil","Eraser","File","Folder"));
		cart.quantity.addAll(Arrays.asList(0,0,0,0,0));
		maxLimit.addAll(Arrays.asList(10,10,10,10,10));
		maxLimitCopy.addAll(Arrays.asList(10,10,10,10,10));
		price.addAll(Arrays.asList(10,5,5,20,50));
		do{
			System.out.println("\t\t\t\t\tWelcome To AKSHAY Shoping Center");
			System.out.println("\t\t\t\t\t________________________________");
			System.out.println("1.View Item List With Price");
			System.out.println("2.Update Your Cart(Add/remove items)");
			System.out.println("3.View Cart");
			System.out.println("4.Add New Item To the Shop");
			System.out.println("5.Generate Bill");
			System.out.println("6.Remove Item From Shop List");
			total=0;
			input.nextLine();
			try{
				System.out.print("\nEnter Your choice:");
				choice = input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input !!!!!");
			}
			switch(choice)
			{
			case 1: cart.view_list();
			break;
			case 2: cart.update_list();
			break;
			case 3: cart.view_cart();
			break;
			case 4: cart.add_new_item();
			break;
			case 5: cart.generate_bill();
			break;
			case 6: cart.removeItem();
			break;
			default:System.out.println("Invalid Choice");
			}
			input.nextLine();
			try{
				System.out.print("\nDo you Want To continue(1 ->Continue / 0-> quit ):");
				flow = input.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nYou Entered Invalid Input !!!!!");
			}
		}while(flow==1);
		System.out.println("Thank you Visit Again!!!");
	}
}
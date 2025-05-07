import java.io.*;
import java.text.*;
import java.util.*;

public class Main 
{
	public static SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
	public static int idCount = 0;
	
	
	public static void main(String[] args) 
	{
		/*
		 * Add, Update, Delete tasks
		 * Mark a task as in progress or done
		 * List all tasks, done tasks, not done tasks, in-progress tasks
		 * Use JSON file to store Tasks
		 * Use positional command line args to take in user input
		 * Make sure to handle exceptions and edge cases
		 */
		ArrayList<Task> allTasks = new ArrayList<Task>();
		File f = new File("task_list.JSON");
		try 
		{
			FileOutputStream fo = new FileOutputStream(f, true);
			PrintWriter out = new PrintWriter(fo);
			Scanner in = new Scanner(f);

			while(in.hasNextLine())
			{
				String next = in.nextLine();
				String[] split = next.split(",");
				Task t = new Task(Integer.valueOf(split[0]), split[1], split[2], split[3], split[4]);
				allTasks.add(t);
				idCount++;
			}

			switch(args[0])
			{
			case "add": //done
				try
				{
					idCount++;
					Task t = new Task(idCount, args[1], "todo", ft.format(new Date()), ft.format(new Date()));
					out.print(t.getId() + "," + t.getDescription() + "," + t.getStatus() + "," + t.getCreatedAt() + "," + t.getUpdatedAt() + "\n");
					System.out.print("Task added successfully (ID: " + t.getId() + ")");
					out.flush();
					out.close();
					break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Please provide a valid input");
					break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Please provide a valid input");
					break;
				}
				
			case "update": //done
				try 
				{
					int idToUpdate = Integer.valueOf(args[1]);
					FileOutputStream fdelete = new FileOutputStream(f, false);
					for(Task t : allTasks)
					{
						if(t.getId() == idToUpdate)
						{
							t.setDescription(args[2]);
							t.setUpdatedAt(ft.format(new Date()));
							
						}
						out.print(t.getId() + "," + t.getDescription() + "," + t.getStatus() + "," + t.getCreatedAt() + "," + t.getUpdatedAt() + "\n");
					}
					out.flush();
					out.close();
					System.out.println("Task updated successfully");
					break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Please provide a task index to update");
					break;
				}
				
			case "delete": //done
				try 
				{
					int idToDelete = Integer.valueOf(args[1]);
					FileOutputStream fdelete = new FileOutputStream(f, false);
					Task d = null;
					for(Task t : allTasks)
					{
						if(t.getId() == idToDelete)
						{
							d = t;	
						}
					}
					allTasks.remove(d);
					for(Task t : allTasks)
					{
						out.print(t.getId() + "," + t.getDescription() + "," + t.getStatus() + "," + t.getCreatedAt() + "," + t.getUpdatedAt() + "\n");
					}
					out.flush();
					out.close();
					System.out.println("Task deleted successfully");
					break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Please provide a task index to delete");
					break;
				}
				
			case "mark-in-progress": //done
				try 
				{
					int idToMark = Integer.valueOf(args[1]);
					FileOutputStream fdelete = new FileOutputStream(f, false);
					for(Task t : allTasks)
					{
						if(t.getId() == idToMark)
						{
							t.setStatus("in-progress");
							t.setUpdatedAt(ft.format(new Date()));	
						}
						out.print(t.getId() + "," + t.getDescription() + "," + t.getStatus() + "," + t.getCreatedAt() + "," + t.getUpdatedAt() + "\n");
					}
					out.flush();
					out.close();
					System.out.println("Task marked as in-progress");
					break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Please provide a task index to mark");
					break;
				}
				
			case "mark-done": //done
				try 
				{
					int idToMark = Integer.valueOf(args[1]);
					FileOutputStream fdelete = new FileOutputStream(f, false);
					for(Task t : allTasks)
					{
						if(t.getId() == idToMark)
						{
							t.setStatus("done");
							t.setUpdatedAt(ft.format(new Date()));
						}
						out.print(t.getId() + "," + t.getDescription() + "," + t.getStatus() + "," + t.getCreatedAt() + "," + t.getUpdatedAt() + "\n");
					}
					out.flush();
					out.close();
					System.out.println("Task marked as in-progress");
					break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Please provide a task index to mark");
					break;
				}
			case "list": //done
				try 
				{
					switch(args[1])
					{	
					case "done":
						for(Task t : allTasks)
						{
							if(t.getStatus().equals("done"))
							{
								System.out.println(t);
							}
						}
						break;
					case "todo":
						for(Task t : allTasks)
						{
							if(t.getStatus().equals("todo"))
							{
								System.out.println(t);
							}
							
						}
						break;
					case "in-progress":
						for(Task t : allTasks)
						{
							if(t.getStatus().equals("in-progress"))
							{
								System.out.println(t);
							}
						}
						break;
					}
					
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					for(Task t : allTasks)
					{
						System.out.println(t);
					}
				}
				break;
				
			default:
				System.out.println("Please provide a valid input");
			}
			in.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occured during file reading or creation");
		}
		
	}

}

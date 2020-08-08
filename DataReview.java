import java.util.*;
public class DataReview
{
	public static void main (String args[])
	{
		ArrayList<Integer> array = new ArrayList<>();

		int rand = (int)(Math.random()*101)+50;

		for(int x = rand; x > 0; x--)
		{
				array.add(rand);
		}

		System.out.print(array);

		int size = (int) (Math.pow((double) array.size(), 0.5) + 1);

		 if(size*size > array.size())
            size--;

		int[][] TwoDarray = new int[size][size];


		for(int row = 0; row < size; row++)
		{
			for(int column = 0; column<size; column++)
			{
				try
				{
					TwoDarray[row][column] = array.remove((int)(Math.random()*array.size()));
				}
				catch(Exception e)
				{
				}
				System.out.print(TwoDarray[row][column]);
			}

        }
        System.out.println();


        Stack<Integer> stack = new Stack<>();

        for(int column = 0; column<size; column++)
        {
			for(int row = 0; row<size; row++)
			{
				stack.push(TwoDarray[row][column]);
			}
        }

        Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}

		HashSet<Integer> hashSet = new HashSet<Integer>();
		while(!stack.isEmpty())
		{
			hashSet.add(stack.pop());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
		Iterator<Integer> hashSetIter = hashSet.iterator();
		while(hashSetIter.hasNext())
		{
			Integer n = hashSetIter.next();
			System.out.println(n);
			pq.add(n);
        }

		TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();

		int key = 0;
		/*int num=pq.poll();
		if(num%2==0)
		{
			key=num;
			if(!map.containsKey(num))
			map.put(key,new TreeSet<Integer>());

		}
		else if(map.size()>0)
			map.get(key).add(num); */

		while(!pq.isEmpty())
		{
			int n = pq.poll();

			if(n%2 == 0)
			{
				key = n;
				if(!treeMap.containsKey(n))
				{
					treeMap.put(key,new TreeSet<Integer>());
				}
			}
			else if(treeMap.size() > 0) {
				treeMap.get(key).add(n);
			}
        }

	}
}
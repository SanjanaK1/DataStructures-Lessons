public class TreeSetRunner
{
    public TreeSetRunner()
    {
        TreeSet<Character> treeSet = new TreeSet<Character>();
        TreeSet<Integer> numSet = new TreeSet();


        for(int x = 0; x < 26; x++)
        {
            treeSet.add((char)(123-((int)(Math.random()*26)+1)));
        }
        System.out.println(treeSet.getList());

        int average = 0;

        for(int c=0;c<treeSet.getList().size();c++)
        {
            average+= c;
		}

        average/=treeSet.size();
        System.out.println("Average asci value is "+average+" and the char is "+(char)average);
        System.out.println(treeSet.size());
        // pre, in, post
        treeSet.preOrderToString();
        treeSet.inOrderToString();
        treeSet.postOrderToString();

       // treeNode.preOrderToString();
	   //treeNode.inOrderToString();
       // treeNode.postOrderToString();

        TreeSet<Character> preOrderSet = new TreeSet<Character>();
        TreeSet<Character> inOrderSet = new TreeSet<Character>();
        TreeSet<Character> postOrderSet = new TreeSet<Character>();

        for(String x : treeSet.preOrderToString().split(" "))
        {
            preOrderSet.add(x.charAt(0));
		}
        System.out.println("PreOrder: ");
        // pre order sets
        System.out.println(preOrderSet.preOrderToString());
        System.out.println(preOrderSet.inOrderToString());
        System.out.println(preOrderSet.postOrderToString());

        for(String x : treeSet.inOrderToString().split(" "))
        {
            inOrderSet.add(x.charAt(0));
		}
        System.out.println("InOrder: ");

        // in order sets
        System.out.println(inOrderSet.preOrderToString());
        System.out.println(inOrderSet.inOrderToString());
        System.out.println(inOrderSet.postOrderToString());

        for(String x : treeSet.postOrderToString().split(" "))
        {
            postOrderSet.add(x.charAt(0));
		}

        System.out.println("PosetOrder: ");

        //post order sets
        System.out.println(postOrderSet.preOrderToString());
        System.out.println(postOrderSet.inOrderToString());
        System.out.println(postOrderSet.postOrderToString());
        treeSet.remove((char)((int)(Math.random()*(26))+(123-26)));



       for(int x = 0; x < 30; x++)
        {
            numSet.add((int)(Math.random()*100)+1);
        }
        System.out.println(numSet.size());
        TreeSet<Integer> preOrderNumSet = new TreeSet();
        TreeSet<Integer> inOrderNumSet = new TreeSet();
        TreeSet<Integer> postOrderNumSet = new TreeSet();

        for(String x : numSet.preOrderToString().split(" "))
        {
            preOrderNumSet.add(Integer.parseInt(x));
		}

        System.out.println("PreOrder: ");
        //pre order sets
        System.out.println(preOrderNumSet.preOrderToString());
        System.out.println(preOrderNumSet.inOrderToString());
        System.out.println(preOrderNumSet.postOrderToString());

        for(String x : numSet.inOrderToString().split(" "))
        {
            inOrderNumSet.add(Integer.parseInt(x));
		}
        System.out.println("InOrder: ");

        //in order sets
        System.out.println(inOrderNumSet.preOrderToString());
        System.out.println(inOrderNumSet.inOrderToString());
        System.out.println(inOrderNumSet.postOrderToString());

        for(String x : numSet.postOrderToString().split(" "))
        {
            postOrderNumSet.add(Integer.parseInt(x));
		}

        System.out.println("postOrder:");
        //post order sets
        System.out.println(postOrderNumSet.preOrderToString());
        System.out.println(postOrderNumSet.inOrderToString());
        System.out.println(postOrderNumSet.postOrderToString());

        System.out.println("Tree: ");
        //current tree
        System.out.println(numSet.preOrderToString());
        System.out.println(numSet.inOrderToString());
        System.out.println(numSet.postOrderToString());
        try {
            numSet.rotateLeft();
        } catch (Error err)
        {
        }
        System.out.println("RotateLeft: ");
        System.out.println(numSet.preOrderToString());
        System.out.println(numSet.inOrderToString());
        System.out.println(numSet.postOrderToString());
        try
        {
            numSet.rotateRight();
        } catch (Error err)
        {

        }
        System.out.println("RotateRight: ");
        System.out.println(numSet.preOrderToString());
        System.out.println(numSet.inOrderToString());
        System.out.println(numSet.postOrderToString());
        try {
            numSet.rotateLeft();
        } catch (Error err)
        {

        }
        try
        {
            numSet.rotateLeft();
        } catch (Error err)
			{

			}
        System.out.println("RotateLeft: ");
        System.out.println(numSet.preOrderToString());
        System.out.println(numSet.inOrderToString());
        System.out.println(numSet.postOrderToString());

       try
        {
            numSet.rotateRight();
        } catch (Error err)
			{

			}
        try
        {
            numSet.rotateRight();
        } catch (Error err)
			{

			}
        try
        {
            numSet.rotateRight();
        } catch (Error err)
			{

			}

        System.out.println("RotateLeft: ");
        System.out.println(numSet.preOrderToString());
        System.out.println(numSet.inOrderToString());
        System.out.println(numSet.postOrderToString());
        while(true){
            try
            {
                numSet.rotateRight();
            }catch(Error err)
            {
                break;
            }
        }

    }
    public static void main( String [] args)
    {
        new TreeSetRunner();
    }
}

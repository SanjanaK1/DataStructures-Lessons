import java.util.*;
public class TreeSet<E extends Comparable<E>>
{
    int size;
    TreeNode rootNode;
    HashSet<E> list = new HashSet<E>();

    public TreeSet(TreeNode<E> rootNode)
    {
        this.rootNode = rootNode;
    }
    public TreeSet()
    {
    }
    public void add(E value){
        TreeNode<E> element = new TreeNode<E>(value);
        if(size == 0){
            rootNode = element;
            size++;
            list.add(element.getValue());
        }else if(!list.contains(value))
        {
			list.add(value);
            add(value, rootNode);
            size++;
        }
    }
    public int size()
    {
        return size;
    }

    //rotate

	    public void rotateRight(TreeNode<E> rootNode)
	    {

	        if(rootNode == null || rootNode.getLeft() == null)
	        {
	            return;
	        }
	        TreeNode<E> temp = rootNode.getLeft();
	        rootNode.setLeft(temp.getRight());
	        temp.setRight(rootNode);
	        this.rootNode = temp;
	    }

	    public void rotateLeft(TreeNode<E> rootNode)
	    {

	        if(rootNode == null || rootNode.getRight() == null)
	        {
	            return;
	        }
	        TreeNode<E> temp = rootNode.getRight();
	        rootNode.setRight(temp.getLeft());
	        temp.setLeft(rootNode);
	        this.rootNode = temp;
	    }
 		public void rotateRight()
		{
			rotateRight(rootNode);
		}
		public void rotateLeft()
		{
			rotateLeft(rootNode);
	    }


    public TreeNode add(E value, TreeNode t)
    {
		if(t == null)
		{
			t = new TreeNode(value);
		}
		if(value.compareTo((E)t.getValue()) < 0)
		{
			t.setLeft(add(value, t.getLeft()));
		}
		if(value.compareTo((E)t.getValue()) > 0)
		{
			t.setRight(add(value, t.getRight()));
		}
		return t;
	}

    public String preOrderToString()
    {
        return preOrderToString(rootNode);
    }
    public String inOrderToString()
    {
        return inOrderToString(rootNode);
    }
    public String postOrderToString()
    {
        return postOrderToString(rootNode);
    }
     public HashSet<E> getList()
	{
		return list;
	}

    public String preOrderToString(TreeNode<E> root)
    {
		String temp = "";
        if(root!=null)
        {
            temp+=rootNode.getValue() + " ";
            temp+=preOrderToString(root.getLeft());
            temp+=preOrderToString(root.getRight());
        }
		return temp;
    }
    public String inOrderToString(TreeNode<E> root)
    {
		String temp = "";
        if(root!=null)
        {
            temp+=inOrderToString(root.getLeft());
            temp+=root.getValue() + " ";
            temp+=inOrderToString(root.getRight());
        }
		return temp;
    }
    public String postOrderToString(TreeNode<E> root)
    {
		String temp = "";
        if(root!=null)
        {
            temp+=postOrderToString(root.getLeft());
            temp+=postOrderToString(root.getRight());
            temp+=root.getValue() + " ";
        }
        return temp;
    }


//remove
	public void remove(E val)
	{
        this.rootNode = remove(this.rootNode, val);
        if(list.contains(val))
            list.remove(val);
    }
    public TreeNode remove(TreeNode root, E val)
    {
        if(root == null)
            return null;
        if(val.compareTo((E)root.getValue()) < 0)
        {
            root.setLeft(remove(root.getLeft(), val));
            return root;
        }
        if(val.compareTo((E)root.getValue()) > 0)
        {
            root.setRight(remove(root.getRight(), val));
            return root;
        }
        if(val.compareTo((E)root.getValue()) == 0)
        {
            if (root.getLeft() == null && root.getRight() == null)
            {
                return null;
            }
            if (root.getLeft() == null)
            {
                return root.getRight();
            }
            if (root.getRight() == null)
            {
                return root.getLeft();
            }
            TreeNode temp = root.getRight();
            while(temp.getLeft() != null)
            {
                temp = temp.getLeft();
            }
            root.setValue(temp.getValue());
            root.setRight(remove(root.getRight(),(E)temp.getValue()));
        }
        return root;
    }


    static class TreeNode<E>
    {
        private E value;
        private TreeNode onLeft;
        private TreeNode onRight;

        public TreeNode(E value)
        {
            this.value = value;
        }
        public E getValue()
        {
            return value;
        }
        public void setValue(E value)
        {
			this.value = value;
		}
        public TreeNode getLeft()
        {
            return onLeft;
        }
        public TreeNode getRight()
        {
            return onRight;
        }
        public void setLeft(TreeNode onLeft)
        {
            this.onLeft = onLeft;
        }
        public void setRight(TreeNode onRight)
        {
            this.onRight = onRight;
        }

        public boolean hasLeft()
        {
            if(onLeft!=null)
                return true;
            else
                return false;
        }

        public boolean hasRight()
        {
            if(onRight!=null)
                return true;
            else
                return false;
        }



      /*  public void rotateRight()
		{
			rotateRight(rootNode);
		}
		public void rotateLeft()
		{
			rotateRight(rootNode);
	    } */


    }
}



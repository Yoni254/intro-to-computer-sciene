package finalsPractice.src;
// Java program to construct a tree using inorder
// and postorder traversals

/* A binary tree node has data, pointer to left
child and a pointer to right child */

// this is from geeksforgeeks or something
class Node {
    int data;
    Node left, right;

    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    /* Recursive function to construct binary of size n
    from Inorder traversal in[] and Postrder traversal
    post[]. Initial values of inStrt and inEnd should
    be 0 and n -1. The function doesn't do any error
    checking for cases where inorder and postorder
    do not form a tree */
    Node buildUtil(int in[], int post[], int inStrt,
                   int inEnd, int postStrt, int postEnd)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

		/* Pick current node from Postrder traversal using
		postIndex and decrement postIndex */
        Node node = new Node(post[postEnd]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.data);

		/* Using index in Inorder traversal, construct left
		and right subtress */
        node.left = buildUtil(
                in, post, inStrt, iIndex - 1, postStrt,
                postStrt - inStrt + iIndex - 1);
        node.right = buildUtil(in, post, iIndex + 1, inEnd,
                postEnd - inEnd + iIndex,
                postEnd - 1);

        return node;
    }

    /* Function to find index of value in arr[start...end]
    The function assumes that value is postsent in in[]
    */
    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

    /* This funtcion is here just to test */
    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Driver Code
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        int in[] = new int[] { 2, 18, 99, 32, 25, 82, 42, 54, 77, 61 };
        int post[] = new int[] { 2, 18, 25, 32, 42, 54, 61, 77, 82, 99 };
        int n = in.length;
        Node root
                = tree.buildUtil(in, post, 0, n - 1, 0, n - 1);
        System.out.println(
                "Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}

// This code has been contributed by Mayank
// Jaiswal(mayank_24)

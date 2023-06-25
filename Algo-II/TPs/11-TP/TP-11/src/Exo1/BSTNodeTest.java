package Exo1;

public class BSTNodeTest {
    public static void main(String[] args) {
        var myTree = new BTSNode<Integer>(4); // root
        var leftRootBranch = new BTSNode<Integer>(3);
        leftRootBranch.setLeftChild(new BTSNode(2));
        myTree.setLeftChild(leftRootBranch);
        var rightRootBranch = new BTSNode<Integer>(7);
        var branch1 = new BTSNode<Integer>(5);
        branch1.setRigthChild(new BTSNode<Integer>(6));
        rightRootBranch.setLeftChild(branch1);
        var branch2 = new BTSNode<Integer>(8);
        branch2.setRigthChild(new BTSNode<Integer>(12));
        rightRootBranch.setRigthChild(branch2);
        rightRootBranch.setLeftChild(branch1);
        myTree.setLeftChild(leftRootBranch);
        myTree.setRigthChild(rightRootBranch);

//        myTree.display();
        System.out.printf("%d", myTree.getData());
        //System.out.printf("\n%d", myTree.getLeftChild().getRightChild().getData());
    }
}

package sr.unasat.verskeerssimulatie.datastructures.trees;

import sr.unasat.verskeerssimulatie.models.Voertuig;

public class TreeNode {

    private Voertuig nodeData;
    private TreeNode leftChild;
    private TreeNode rightChild;

    private int nodeKentekenNumber;

    public TreeNode(Voertuig voertuig) {
        this.nodeData = voertuig;
        this.nodeKentekenNumber = takeOutNumber(voertuig);
    }

    public void insert(Voertuig voertuig){

        int voertuigKentekenNumber = takeOutNumber(voertuig);

        if (voertuigKentekenNumber == nodeKentekenNumber){
            System.out.println("Duplicate number found: " + voertuigKentekenNumber);
            return;
        }
        if (voertuigKentekenNumber < nodeKentekenNumber){
            if (leftChild == null){
                leftChild = new TreeNode(voertuig);
            }else {
                leftChild.insert(voertuig);
            }
        }else {
            if (rightChild == null){
                rightChild = new TreeNode(voertuig);
            }else {
                rightChild.insert(voertuig);
            }
        }
    }

    public TreeNode get(int voertuigKentekenNumber){

        if (voertuigKentekenNumber == nodeKentekenNumber){
            System.out.println(nodeData);
            return this;
        }
        if (voertuigKentekenNumber < nodeKentekenNumber){
            if (leftChild != null){
                return leftChild.get(voertuigKentekenNumber);
            }
        }
        else {
            if (rightChild != null){
                return rightChild.get(voertuigKentekenNumber);
            }
        }
        System.out.println("Could not find: " + voertuigKentekenNumber);
        return null;
    }

    private int takeOutNumber(Voertuig voertuig) {
        String subString = voertuig.getKentekenNummer().substring(3, 7);
        return Integer.parseInt(subString);
    }

    public Voertuig getNodeData() {
        return nodeData;
    }

    public void setNodeData(Voertuig nodeData) {
        this.nodeData = nodeData;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "nodeData=" + nodeData +
                '}';
    }
}

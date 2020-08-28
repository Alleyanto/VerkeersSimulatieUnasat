package sr.unasat.verskeerssimulatie.datastructures.trees;

import sr.unasat.verskeerssimulatie.models.Voertuig;

public class Tree {

    private TreeNode root;

    public void insert(Voertuig voertuig){
        if (root == null){
            root = new TreeNode(voertuig);
        } else {
            root.insert(voertuig);
        }
    }

    public TreeNode get(int voertuigKentekenNumber){
        if (root != null){
            return root.get(voertuigKentekenNumber);
        }
        return null;
    }
}
